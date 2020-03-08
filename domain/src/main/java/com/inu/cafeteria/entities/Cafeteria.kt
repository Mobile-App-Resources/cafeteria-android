/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Cafeteria  (
    @PrimaryKey
    val id: Int = 0,
    val name: String = "",
    val imagePath: String = "",

    val supportMenu: Boolean = false,
    val supportDiscount: Boolean = false,
    val supportNotification: Boolean = false,

    /**
     * Ordering is an important part of this app.
     */
    val order: Int = 0,

    val corners: RealmList<Corner> = RealmList()
): RealmObject()