/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.api

import com.inu.cafeteria.api.models.*
import retrofit2.Call
import retrofit2.http.*

interface CafeteriaNetworkService {

    @GET("/cafeteria")
    fun getCafeteria(): Call<List<CafeteriaResponse>>

    @GET("/corners")
    fun getCorners(
        @Query("cafeteriaId") cafeteriaId: Int
    ): Call<List<CornerResponse>>

    @GET("/menus")
    fun getMenus(
        @Query("cornerId") cornerId: Int
    ): Call<List<MenuResponse>>

    @FormUrlEncoded
    @POST("/login")
    fun login(
        @Field("id") id: Long,
        @Field("token") token: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("/logout")
    fun logout(
        @Header("authorization") auth: String
    ): Call<Unit>

    @FormUrlEncoded
    @POST("/activeBarcode")
    fun activateBarcode(
        @Header("authorization") auth: String
    ): Call<Unit>

    @FormUrlEncoded
    @POST("/feedback")
    fun sendFeedback(
        @Header("authorization") auth: String,
        @Field("content") content: String
    ): Call<Unit>

    @FormUrlEncoded
    @GET
    fun getFeedbackReplies(
        @Header("authorization") auth: String
    ): Call<List<FeedbackReplyResponse>>

    @FormUrlEncoded
    @GET
    fun getNotices(): Call<List<NoticeResponse>>
}