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
import com.inu.cafeteria.model.FoodMenu
import com.inu.cafeteria.repository.CafeteriaRepository
import com.inu.cafeteria.repository.Repository

class GetFoodMenu(
    private val cafeteriaRepo: CafeteriaRepository
) : UseCase<Unit, List<FoodMenu>>() {

    override fun run(params: Unit) = Result.of {
        var result: List<FoodMenu>? = null
        var failure: Exception? = null

        cafeteriaRepo.getAllFoodMenu(
            Repository.DataCallback(
                async = false,
                onSuccess = { result = it },
                onFail = { failure = it }
            )
        )

        failure?.let { throw it }

        return@of result!!
    }
}