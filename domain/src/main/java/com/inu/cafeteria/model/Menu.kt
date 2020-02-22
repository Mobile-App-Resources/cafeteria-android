/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.model

import io.realm.RealmObject

/**
 * A Realm model that represents a single meal info.
 * Do not hold a reference to an instance of this class.
 * It will be removed on every update.
 */
open class Menu : RealmObject() {
    val foods: String = ""
    val price: Int = 0
    val calorie: Int = 0
}