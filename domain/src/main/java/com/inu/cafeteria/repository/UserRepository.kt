/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.repository

import com.inu.cafeteria.entities.User
import com.inu.cafeteria.functional.Result
import com.inu.cafeteria.model.scheme.*

abstract class UserRepository : Repository() {

    abstract fun getUser(): Result<User>
    abstract fun setUser(user: User): Result<Unit>
    abstract fun purgeUser(): Result<Unit>

    abstract fun activateBarcode(): Result<Unit>
}