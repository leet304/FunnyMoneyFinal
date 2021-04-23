package com.example.funnymoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    //Below are the default values. These will be "put" into the calculated activity
    //By using the putExtra command this will allow EditPercentageActivity.kt to easily edit the values.
    //Values are preset to .09 or 9% as this allows the calculations to be done properly without mathematical errors
    var utilityPercent: Double = .09
    var entertainPercent: Double = .09
    var grocerPercent: Double = .09
    var homeINSPercent: Double = .09
    var wifiTVPercent: Double = .09
    var carPayPercent: Double = .09
    var carINSPercent: Double = .09
    var carMaintGasPercent: Double = .09
    var phonePercent: Double = .09
    var gymPercent: Double = .09
    var healthINSPercent: Double = .09

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Calculate: Button = findViewById(R.id.calculate)
        var Income: EditText = findViewById(R.id.income)

        Calculate.setOnClickListener {

            val intent = Intent(this, CalculatedActivity()::class.java)
            //below is how the values are passed between intents. This allows the app to keep track of the values when loading each intent
            intent.putExtra("Income",Income.text.toString().toDouble())
            intent.putExtra("utility", utilityPercent)
            intent.putExtra("entertain", entertainPercent)
            intent.putExtra("grocery", grocerPercent)
            intent.putExtra("home", homeINSPercent)
            intent.putExtra("wifi", wifiTVPercent)
            intent.putExtra("carPay",carPayPercent)
            intent.putExtra("carINS", carINSPercent)
            intent.putExtra("carMaint", carMaintGasPercent)
            intent.putExtra("phone", phonePercent)
            intent.putExtra("gym", gymPercent)
            intent.putExtra("health", healthINSPercent)

            startActivity(intent)

        }

    }

}
