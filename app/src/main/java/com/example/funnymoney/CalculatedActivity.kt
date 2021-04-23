package com.example.funnymoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.lang.StringBuilder



class CalculatedActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculated)
        //These are the objects on the calculated screen (calculated.xml)
        var utilityText: TextView = findViewById(R.id.utilityOut)
        var entertainText: TextView = findViewById(R.id.entertainmentOut)
        var groceryText: TextView = findViewById(R.id.groceriesOut)
        var leftoverText: TextView = findViewById(R.id.leftOverOut)
        var homeINSText: TextView = findViewById(R.id.homeINSOut)
        var wifiText: TextView = findViewById(R.id.wifiout)
        var carPayText: TextView = findViewById(R.id.carPayOut)
        var carINSText: TextView = findViewById(R.id.carINSOut)
        var carMaintText: TextView = findViewById(R.id.carMaintOut)
        var phoneText: TextView = findViewById(R.id.phoneOut)
        var gymText: TextView = findViewById(R.id.gymOut)
        var healthText: TextView = findViewById(R.id.healthINSOut)



        var editIncome: Button = findViewById(R.id.editIncome)
        var editPercent: Button = findViewById(R.id.editPercent)

        //Values below are able to be gotten from both MainActivity.kt, and EditPercentageActivity.kt.
        //This allows the user to alter their percentages as they see fit
        var userIncome = intent.getDoubleExtra("Income",0.0)
        var utilityPercent = intent.getDoubleExtra("utility", 0.0)
        var entertainPercent = intent.getDoubleExtra("entertain", 0.0)
        var grocerPercent = intent.getDoubleExtra("grocery", 0.0)
        var homeINSPercent = intent.getDoubleExtra("home", 0.0)
        var wifiPercent = intent.getDoubleExtra("wifi", 0.0)
        var carPayPercent = intent.getDoubleExtra("carPay", 0.0)
        var carINSPercent = intent.getDoubleExtra("carINS", 0.0)
        var carMaintPercent = intent.getDoubleExtra("carMaint", 0.0)
        var phonePercent = intent.getDoubleExtra("phone", 0.0)
        var gymPercent = intent.getDoubleExtra("gym", 0.0)
        var healthINSPercent = intent.getDoubleExtra("health", 0.0)
        var leftOverPercent: Double = 1 - utilityPercent - entertainPercent - grocerPercent - homeINSPercent - wifiPercent - carPayPercent - carINSPercent - carMaintPercent - phonePercent - gymPercent


        //properly sets the values that appear into the TextView locations
        utilityText.text = (userIncome * utilityPercent).toString()
        entertainText.text = (userIncome * entertainPercent).toString()
        groceryText.text = (userIncome * grocerPercent).toString()
        leftoverText.text = (userIncome * utilityPercent).toString()
        homeINSText.text = (userIncome * homeINSPercent).toString()
        wifiText.text = (userIncome * wifiPercent).toString()
        carPayText.text = (userIncome * carPayPercent).toString()
        carINSText.text = (userIncome * carINSPercent).toString()
        carMaintText.text = (userIncome * carMaintPercent).toString()
        phoneText.text = (userIncome * phonePercent).toString()
        gymText.text = (userIncome * gymPercent).toString()
        healthText.text = (userIncome * healthINSPercent).toString()


        editIncome.setOnClickListener{ //allows the user to go back and re enter their monthly income
            val intent = Intent(this, MainActivity()::class.java)
            startActivity(intent)
        }

        editPercent.setOnClickListener{ //will take the user to the EditPercentageActivity page where they can edit where their money is spent
            val intent = Intent(this, EditPercentageActivity()::class.java)
            intent.putExtra("utility", utilityPercent)
            intent.putExtra("entertain", entertainPercent)
            intent.putExtra("grocery", grocerPercent)
            intent.putExtra("home", homeINSPercent)
            intent.putExtra("wifi", wifiPercent)
            intent.putExtra("carPay",carPayPercent)
            intent.putExtra("carINS", carINSPercent)
            intent.putExtra("carMaint", carMaintPercent)
            intent.putExtra("phone", phonePercent)
            intent.putExtra("gym", gymPercent)
            intent.putExtra("health", healthINSPercent)
            intent.putExtra("leftover", leftOverPercent)
            intent.putExtra("Income",userIncome)
            startActivity(intent)
        }

    }

}



