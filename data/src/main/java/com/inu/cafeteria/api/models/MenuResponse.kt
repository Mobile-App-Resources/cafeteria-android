/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.api.models

import com.google.gson.annotations.SerializedName

data class MenuResponse(
    @SerializedName("corner-id") val cornerId: Int,
    val foods: String,
    val price: Int,
    val calorie: Int
)