package br.com.firstaplication.cricketchrips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtChirps: EditText = findViewById(R.id.edtChirps)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val tvResult: TextView = findViewById(R.id.tvResult)
        btnCalculate.setOnClickListener {

            if (edtChirps.text.toString().isEmpty()) {
                Toast.makeText(this, "Please type the number os chrips", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val count = edtChirps.text.toString().trim().toInt()
                val temperature = (count / 3.0) + 4
                val correctTemperature = correcCases(temperature)
                val result = "The approximate temperature outside is: $correctTemperature  degrees Celcius"

                tvResult.setText(result)
                tvResult.visibility = View.VISIBLE
            }
        }
    }

    private fun correcCases(temperature: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val roundOff = df.format(temperature)
        return roundOff
    }

}