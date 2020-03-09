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

    /** Login and SAVE user info to local DB */
    abstract fun login(id: Long, token: String?=null, password: String?=null): Result<User>

    /** Get user saved in local DB */
    abstract fun getUser(): Result<User>

    /** Logout and PURGE user info in local DB */
    abstract fun logout(): Result<Unit>

    /** Activate barcode using the user info saved in local DB */
    abstract fun activateBarcode(): Result<Unit>
}