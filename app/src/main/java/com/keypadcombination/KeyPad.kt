package com.keypadcombination

import java.util.*

class KeyPad {
    fun initSearch(d: Int, n: Int): ArrayList<Int> {

        val finalList = arrayListOf<Int>()

        val keypad = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
            intArrayOf(-1, 0, -1)
        )

        var row = 0
        var col = 0

        //search for the position of d-number in the keypad(matrix)
        loop@ for (i in keypad.indices) {
            for (j in keypad[0].indices) {
                if (keypad[i][j] == d) {
                    row = i
                    col = j
                    break@loop
                }
            }
        }
        findAllCombinations(keypad, n, Stack(), row, col, finalList)

        return finalList
    }

    private fun findAllCombinations(
        keypad: Array<IntArray>,
        n: Int,
        pattern: Stack<String>,
        x: Int,
        y: Int,
        finalList: ArrayList<Int>
    ) {

        // add current number to string
        pattern.push(keypad[x][y].toString())
        // save pattern
        if (pattern.size == n) {
            val finalPattern = StringBuilder()
            pattern.forEach { finalPattern.append(it) }
            finalList.add(finalPattern.toString().toInt())
            return
        }

        // These arrays are used to get row and column
        // numbers of 4 neighbours of a given cell
        //left->top->right->bottom
        val row = intArrayOf(0, -1, 0, 1)
        val col = intArrayOf(-1, 0, 1, 0)

        // Recur for all connected neighbours
        for (k in 0..3) {
            if (isValid(x + row[k], y + col[k]) && keypad[x + row[k]][y + col[k]] != -1) {
                findAllCombinations(keypad, n, pattern, x + row[k], y + col[k], finalList)
                pattern.pop()
            }
        }
    }

    private fun isValid(x: Int, y: Int): Boolean {
        // row number is in range, column number
        // is in range and not yet visited
        return x in 0..3 && y in 0..2
    }
}