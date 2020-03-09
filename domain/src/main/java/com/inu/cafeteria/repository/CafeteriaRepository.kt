/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.repository

import com.inu.cafeteria.entities.Cafeteria
import com.inu.cafeteria.entities.Corner
import com.inu.cafeteria.entities.Menu
import com.inu.cafeteria.functional.Result
import java.util.*

abstract class CafeteriaRepository : Repository() {

    abstract fun getCafeteria(ordered: Boolean=true): Result<List<Cafeteria>>
    abstract fun getCorners(cafeteriaId: Int=0): Result<List<Corner>>
    abstract fun getMenus(cornerId: Int=0, date: Date?=null): Result<List<Menu>>

    abstract fun setCafeteriaOrder(cafeteriaIdToOrder: Map<Int, Int>): Result<Unit>
}