/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.repositories

import com.inu.cafeteria.api.CafeteriaApi
import com.inu.cafeteria.core.functional.Result
import com.inu.cafeteria.entities.Cafeteria
import com.inu.cafeteria.entities.Corner
import com.inu.cafeteria.entities.Menu
import com.inu.cafeteria.core.exception.Failure
import retrofit2.Call
import java.util.*

class CafeteriaRepositoryImpl(
    private val cafeteriaApi: CafeteriaApi
) : CafeteriaRepository() {

    override fun getCafeteria(ordered: Boolean): Result<List<Cafeteria>> =
        request(
            cafeteriaApi.getCafeteria(),
            { it.map { each -> each.toCafeteria() } },
            emptyList()
        )

    override fun getCorners(cafeteriaId: Int): Result<List<Corner>> =
        request(
            cafeteriaApi.getCorners(cafeteriaId),
            { it.map { each -> each.toCorner() } },
            emptyList()
        )

    override fun getMenus(cornerId: Int, date: Date?): Result<List<Menu>> =
        request(
            cafeteriaApi.getMenus(cornerId),
            { it.map { each -> each.toMenu() } },
            emptyList()
        )

    override fun setCafeteriaOrder(cafeteriaIdToOrder: Map<Int, Int>): Result<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Result<R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Result.Success(transform((response.body() ?: default)))
                false -> Result.Error(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Result.Error(Failure.NetworkConnection)
        }
    }
}