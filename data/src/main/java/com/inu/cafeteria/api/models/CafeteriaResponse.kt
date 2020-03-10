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

data class CafeteriaResponse(
    val id: Long,
    val name: String,
    @SerializedName("image-path") val imagePath: String,

    @SerializedName("support-menu") val supportMenu: Boolean,
    @SerializedName("support-discount") val supportDiscount: Boolean,
    @SerializedName("support-notification") val supportNotification: Boolean
)