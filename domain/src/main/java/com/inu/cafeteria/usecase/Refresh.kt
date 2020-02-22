/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.usecase

import com.inu.cafeteria.functional.Result
import com.inu.cafeteria.interactor.UseCase

/**
 * This use case refreshes all cafeteria, corners and menus.
 */
class Refresh : UseCase<Unit, Unit>() {

    override fun run(params: Unit): Result<Unit> = Result.of {

        




    }
}