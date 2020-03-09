/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.entities

class Cafeteria  (
    val id: Int = 0,
    val name: String = "",
    val imagePath: String = "",

    val supportMenu: Boolean = false,
    val supportDiscount: Boolean = false,
    val supportNotification: Boolean = false,


    val order: Int = 0
)