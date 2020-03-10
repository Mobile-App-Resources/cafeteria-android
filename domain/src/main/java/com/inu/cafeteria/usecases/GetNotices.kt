/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.usecases

import com.inu.cafeteria.entities.Notice
import com.inu.cafeteria.core.functional.Result
import com.inu.cafeteria.core.interactor.UseCase
import com.inu.cafeteria.repositories.InteractionRepository

class GetNotices(
    private val interactionRepo: InteractionRepository
) : UseCase<Unit, List<Notice>>() {

    override suspend fun run(params: Unit): Result<List<Notice>> =
        interactionRepo.getNotices()
}