/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria

import com.inu.cafeteria.api.CafeteriaApi
import com.inu.cafeteria.repositories.CafeteriaRepositoryImpl
import com.inu.cafeteria.repositories.PrivateRepositoryImpl
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.common.truth.Truth.assertThat
import com.inu.cafeteria.core.functional.Result
import com.inu.cafeteria.repositories.CafeteriaRepository

class CafeteriaRepositoryImplTest {

    @Test
    fun should_get_cafeteria() {
        assertSucceededAndListNotEmpty(repo.getCafeteria())
    }

    @Test
    fun should_get_corners() {
        assertSucceededAndListNotEmpty(repo.getCorners(1))
    }

    @Test
    fun should_get_menus() {
        assertSucceededAndListNotEmpty(repo.getMenus(1))
    }

    fun <T> assertSucceededAndListNotEmpty(result: Result<List<T>>) {
        assertThat(result).isInstanceOf(Result.Success::class.java)
        val elements = (result as Result.Success).data
        println(elements)
        assertThat(elements).isNotEmpty()
    }

    companion object {
        private lateinit var api: CafeteriaApi
        private lateinit var repo: CafeteriaRepository

        @BeforeClass
        @JvmStatic
        fun setup_api_and_repo() {
            val privateRepo = PrivateRepositoryImpl()

            val retrofitClient = Retrofit.Builder()
                .baseUrl(privateRepo.getServerBaseUrl())
                .client(OkHttpClient().newBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            api = retrofitClient.create(CafeteriaApi::class.java)
            repo = CafeteriaRepositoryImpl(api)
        }
    }
}