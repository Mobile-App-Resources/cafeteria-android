/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.repository

import com.inu.cafeteria.api.CafeteriaNetworkService
import com.inu.cafeteria.entities.Cafeteria
import com.inu.cafeteria.entities.Corner
import com.inu.cafeteria.entities.Menu
import com.inu.cafeteria.functional.Result
import java.util.*

class CafeteriaRepositoryImpl(
    private val service: CafeteriaNetworkService
) : CafeteriaRepository() {
    override fun getCafeteria(ordered: Boolean): Result<List<Cafeteria>> {
    }

    override fun getCorners(cafeteriaId: Int): Result<List<Corner>> {
    }

    override fun getMenus(cornerId: Int, date: Date?): Result<List<Menu>> {
    }

    override fun setCafeteriaOrder(cafeteriaIdToOrder: Map<Int, Int>): Result<Unit> {
    }
}