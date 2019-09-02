package org.inu.cafeteria.usecase

import org.inu.cafeteria.exception.ResponseFailException
import org.inu.cafeteria.functional.Result
import org.inu.cafeteria.interactor.UseCase
import org.inu.cafeteria.model.VersionCompared
import org.inu.cafeteria.repository.VersionRepository

/**
 *
 * IOException: Server failure
 * RuntimeException: Unexpected failure
 */
class GetVersion(
    private val versionRepo: VersionRepository
) : UseCase<Unit, VersionCompared>() {

    override fun run(params: Unit): Result<VersionCompared> = Result.of {

        return@of VersionCompared(
            currentVersion = versionRepo.getCurrentVersion(),
            latestVersion = versionRepo.getLatestVersion()
                .execute()
                .let { it.takeIf { it.isSuccessful } ?: throw ResponseFailException() }
                .body()
                ?.android
                ?.latest
                ?: throw RuntimeException("Body is null.")
        )
    }


}