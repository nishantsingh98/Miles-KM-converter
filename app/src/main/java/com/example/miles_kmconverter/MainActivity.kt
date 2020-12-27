package com.example.miles_kmconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.StringBuilder
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val givenKm = findViewById<EditText>(R.id.editText_enter_km)
        val givenMiles = findViewById<EditText>(R.id.editText_enter_miles)

        val textViewMiles = findViewById<TextView>(R.id.textView_miles)
        val textViewKm = findViewById<TextView>(R.id.textView_km)

        val buttonKmDone = findViewById<Button>(R.id.button_km_done)
        buttonKmDone.setOnClickListener {
            val miles = convertToMiles((givenKm.text.toString()).toDouble())
            val sb = StringBuilder()
            sb.append(givenKm.text.toString() + " Km = " + miles.toString() + " Miles")

            textViewMiles.visibility = View.VISIBLE
            textViewMiles.text = sb.toString()
        }

        val buttonMilesDone = findViewById<Button>(R.id.button_miles_done)
        buttonMilesDone.setOnClickListener {
            val km = convertToKm((givenMiles.text.toString()).toDouble())
            val sb = StringBuilder()
            sb.append(givenMiles.text.toString() + " Miles = " + km.toString() + " Km")

            textViewKm.visibility = View.VISIBLE
            textViewKm.text = sb.toString()
        }
    }

    private fun convertToKm(givenKm: Double): Any {
        val df = DecimalFormat("#.###")
        df.roundingMode = RoundingMode.CEILING
        return df.format(givenKm * 1.60934)
    }

    private fun convertToMiles(givenMiles: Double): Any {
        val df = DecimalFormat("#.###")
        df.roundingMode = RoundingMode.CEILING
        return df.format(givenMiles * 0.621371)
    }
}