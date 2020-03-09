/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.usecase

import com.inu.cafeteria.entities.User
import com.inu.cafeteria.functional.Result
import com.inu.cafeteria.interactor.UseCase
import com.inu.cafeteria.repository.UserRepository

class GetUser(
    private val userRepo: UserRepository
) : UseCase<Unit, User>() {

    override suspend fun run(params: Unit): Result<User> =
        userRepo.getUser()
}