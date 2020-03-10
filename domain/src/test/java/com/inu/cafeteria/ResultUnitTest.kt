/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria

import com.inu.cafeteria.functional.Result
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import java.lang.ArithmeticException

class ResultUnitTest {
    @Test
    fun result_chain_works() {

        val success = getNumber()
            .then { add5(it) }
            .then { mul4(it) }

        assertThat(success).isInstanceOf(Result.Success::class.java)
        assertThat((success as Result.Success).data).isEqualTo(32)

        val error = getNumber()
            .then { mul4(it) }
            .then { div0(it) }

        assertThat(error).isInstanceOf(Result.Error::class.java)
        assertThat((error as Result.Error).exception).isInstanceOf(ArithmeticException::class.java)
    }

    private fun getNumber(): Result<Int> {
        return Result.Success(3)
    }

    private fun add5(num: Int): Result<Int> {
        return Result.Success(num + 5)
    }

    private fun mul4(num: Int): Result<Int> {
        return Result.Success(num * 4)
    }

    private fun div0(num: Int): Result<Int> {
        return Result.Success(num / 0) /* this will throw */
    }

}
