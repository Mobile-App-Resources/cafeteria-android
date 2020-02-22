/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * A Realm model that holds all data of a cafeteria.
 * Once a Cafeteria instance is created, it won't be removed
 * until the server removes it.
 */
open class Cafeteria : RealmObject() {
    /**
     * Identifier of the cafeteria.
     */
    @PrimaryKey
    val id: Int = 0

    /**
     * Name of the cafeteria.
     */
    val name: String = ""

    /**
     * Path of header image of the cafeteria.
     */
    val imagePath: String = ""

    /**
     * Corners this cafeteria has.
     */
    val corners: RealmList<Corner> = RealmList()

    /**
     * Does this cafeteria support food menu?
     */
    val supportFoodMenu: Boolean = false

    /**
     * Does this cafeteria support alarm?
     */
    val supportAlarm: Boolean = false
}