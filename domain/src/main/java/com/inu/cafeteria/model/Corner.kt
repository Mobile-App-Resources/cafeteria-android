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

/**
 * A Realm model that holds food menus of a single corner.
 * Any instances of this class(in Realm) won't be removed
 * until server deletes it.
 */
open class Corner : RealmObject() {
    /**
     * Name of the corner
     */
    val name: String = ""

    /**
     * Menus of the corner.
     * This field will live as long as this instance lives,
     * but the contents will be purged and filled every time
     * user triggers update.
     */
    val menus: RealmList<Menu> = RealmList()
}