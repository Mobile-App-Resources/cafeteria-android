/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.service

import com.inu.cafeteria.base.FailableComponent
import com.inu.cafeteria.base.Startable
import timber.log.Timber

abstract class Service : FailableComponent(), Startable {
    override fun start() {
        Timber.v("${this::class.java.name} started.")
    }
}