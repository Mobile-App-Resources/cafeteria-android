/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.usecases

import com.inu.cafeteria.core.interactor.UseCase
import com.inu.cafeteria.repositories.UserRepository

class ActivateBarcode(
    private val userRepo: UserRepository
) : UseCase<Unit, Unit>() {

    override suspend fun run(params: Unit) = userRepo.activateBarcode()
}