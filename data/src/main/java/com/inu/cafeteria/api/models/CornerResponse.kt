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
import com.inu.cafeteria.entities.Corner

data class CornerResponse(
    val id: Int,
    val name: String,
    @SerializedName("cafeteria-id") val cafeteriaId: Int
) {
    fun toCorner() = Corner(
        id = this.id,
        name = this.name,
        cafeteriaId = this.cafeteriaId
    )
}