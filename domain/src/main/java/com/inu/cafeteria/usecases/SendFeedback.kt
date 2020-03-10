/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.usecases

import com.inu.cafeteria.core.functional.Result
import com.inu.cafeteria.core.interactor.UseCase
import com.inu.cafeteria.repositories.InteractionRepository

class SendFeedback(
    private val interactionRepo: InteractionRepository
) : UseCase<String, Unit>() {

    override suspend fun run(params: String): Result<Unit> =
        interactionRepo.sendFeedback(params)
}