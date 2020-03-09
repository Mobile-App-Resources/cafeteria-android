/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

class Menu(
    val foods: List<String>,
    val price: Int,
    val calorie: Int,

    val cornerId: Int
)