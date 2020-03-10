/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.services

import com.inu.cafeteria.functional.Result

abstract class InteractionService : Service() {

    abstract fun sendFeedback(content: String): Result<Unit>
}