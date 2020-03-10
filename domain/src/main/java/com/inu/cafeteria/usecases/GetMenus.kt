/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.usecases

import com.inu.cafeteria.entities.Menu
import com.inu.cafeteria.core.interactor.UseCase
import com.inu.cafeteria.repositories.CafeteriaRepository
import java.util.*

class GetMenus(
    private val cafeteriaRepo: CafeteriaRepository
) : UseCase<GetMenus.Param, List<Menu>>() {

    data class Param(val cornerId: Int, val date: Date?=null)

    override suspend fun run(params: Param) =
        cafeteriaRepo.getMenus(params.cornerId, params.date)
}