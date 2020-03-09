/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.usecase

import com.inu.cafeteria.entities.Cafeteria
import com.inu.cafeteria.interactor.UseCase
import com.inu.cafeteria.repository.CafeteriaRepository

class GetCafeteria(
    private val cafeteriaRepo: CafeteriaRepository
) : UseCase<Unit, List<Cafeteria>>() {

    override suspend fun run(params: Unit) = cafeteriaRepo.getCafeteria()
}