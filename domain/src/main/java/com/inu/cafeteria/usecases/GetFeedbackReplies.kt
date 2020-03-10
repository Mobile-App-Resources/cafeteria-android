/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.usecases

import com.inu.cafeteria.entities.FeedbackReply
import com.inu.cafeteria.functional.Result
import com.inu.cafeteria.interactor.UseCase
import com.inu.cafeteria.repositories.InteractionRepository

class GetFeedbackReplies(
    private val interactionRepo: InteractionRepository
) : UseCase<Unit, List<FeedbackReply>>() {

    override suspend fun run(params: Unit): Result<List<FeedbackReply>> =
        interactionRepo.getFeedbackReplies()
}