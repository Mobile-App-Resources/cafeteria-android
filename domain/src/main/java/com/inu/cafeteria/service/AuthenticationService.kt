/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.service

import com.inu.cafeteria.entities.User
import com.inu.cafeteria.functional.Result

abstract class AuthenticationService : Service() {

    abstract fun login(id: Long, token: String?=null, password: String?=null): Result<User>
    abstract fun logout(): Result<Unit>
}
