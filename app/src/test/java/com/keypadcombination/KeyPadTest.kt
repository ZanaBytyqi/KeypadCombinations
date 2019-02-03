package com.keypadcombination

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class KeyPadTest {

    private lateinit var keyPad: KeyPad

    @Before
    fun setUp() {
        keyPad = KeyPad()
    }

    @Test
    @Parameters(method = "params")
    fun `when initSearch called, return possible combinations`(
        startNumber: Int,
        searchLength: Int,
        expectedResult: IntArray
    ) {

        val actual = keyPad.initSearch(startNumber, searchLength).toIntArray()
        Assert.assertArrayEquals(expectedResult, actual)
    }

    @Suppress("unused")
    private fun params(): Array<Any> {

        return arrayOf(
            arrayOf(1, 2, intArrayOf(12, 14)),
            arrayOf(2, 2, intArrayOf(21, 23, 25)),
            arrayOf(1, 3, intArrayOf(121, 123, 125, 141, 145, 147)),
            arrayOf(5, 3, intArrayOf(541, 545, 547, 521, 523, 525, 565, 563, 569, 587, 585, 589,580))
        )

    }

}