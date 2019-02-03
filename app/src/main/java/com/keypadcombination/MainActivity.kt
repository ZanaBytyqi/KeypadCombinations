package com.keypadcombination

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startNumbers = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val startNumbersAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, startNumbers)
        startSpinner.adapter = startNumbersAdapter

        val lengthNumbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val lengthNumbersAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lengthNumbers)
        lengthSpinner.adapter = lengthNumbersAdapter

        btnShowResult.setOnClickListener {
            val result = KeyPad().initSearch(
                startSpinner.selectedItem.toString().toInt(),
                lengthSpinner.selectedItem.toString().toInt()
            )
            tvResult.text = "[${result.joinToString(" ")}]"
        }
    }
}
