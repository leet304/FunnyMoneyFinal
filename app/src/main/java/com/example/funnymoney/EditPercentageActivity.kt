package com.example.funnymoney
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
import java.lang.StringBuilder
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class EditPercentageActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editpercentage)

        //Gets the values from the caller intent
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
        var userIncome = intent.getDoubleExtra("Income",0.0) //used to pass the income to each activity that way it is stored.

        var totalPercent: Double = 0.0 //value will be used to ensure the users alterations equal 100% when finished

        //sets var of the percent boxes
        var setUtilityPercent: EditText = findViewById(R.id.setUtilityPercent)
        var setEntertainPercent: EditText = findViewById(R.id.setEntertainPercent)
        var setGroceryPercent: EditText = findViewById(R.id.setGroceryPercent)
        var setHomeINSPercent: EditText = findViewById(R.id.setHomeINSPercent)
        var setWifiPercent: EditText = findViewById(R.id.setWifiPercent)
        var setCarPayPercent: EditText = findViewById(R.id.setCarPayPercent)
        var setCarINSPercent: EditText = findViewById(R.id.setCarINSPercent)
        var setCarMaintPercent: EditText = findViewById(R.id.setCarMaintPercent)
        var setPhonePercent: EditText = findViewById(R.id.setPhonePercent)
        var setGymPercent: EditText = findViewById(R.id.setGymPercent)
        var setHealthINSPercent: EditText = findViewById(R.id.setHealthINSPercent)
        var setTotalPercent: EditText = findViewById(R.id.setTotalPercent)

        var recalc: Button = findViewById(R.id.recalc)

        //sets the text inside of the EditText boxes. *100 is used so that the user sees the whole number as a % and not as a decimal
        setUtilityPercent.setText((utilityPercent * 100).toString())
        setEntertainPercent.setText((entertainPercent * 100).toString())
        setGroceryPercent.setText((grocerPercent * 100).toString())
        setHomeINSPercent.setText((homeINSPercent * 100).toString())
        setWifiPercent.setText((wifiPercent * 100).toString())
        setCarPayPercent.setText((carPayPercent * 100).toString())
        setCarINSPercent.setText((carINSPercent * 100).toString())
        setCarMaintPercent.setText((carMaintPercent * 100).toString())
        setPhonePercent.setText((phonePercent * 100).toString())
        setGymPercent.setText((gymPercent * 100).toString())
        setHealthINSPercent.setText((healthINSPercent * 100).toString())
        setTotalPercent.setText((utilityPercent + entertainPercent + grocerPercent + homeINSPercent + wifiPercent + carPayPercent + carMaintPercent + carINSPercent + phonePercent + gymPercent + healthINSPercent).toString())




        recalc.setOnClickListener{
            totalPercent = 0.0
            utilityPercent = setUtilityPercent.text.toString().toDouble()
            totalPercent += (utilityPercent/100)//tracks the total percentage so that the user cannot go past 100% total in the budget. /100 is used to track the decimal value since the user will only put in whole numbers

            entertainPercent = setEntertainPercent.text.toString().toDouble()
            totalPercent += (entertainPercent/100)

            grocerPercent = setGroceryPercent.text.toString().toDouble()
            totalPercent += (grocerPercent/100)

            homeINSPercent = setHomeINSPercent.text.toString().toDouble()
            totalPercent += (homeINSPercent/100)

            wifiPercent = setWifiPercent.text.toString().toDouble()
            totalPercent += (wifiPercent/100)

            carPayPercent = setCarPayPercent.text.toString().toDouble()
            totalPercent += (carPayPercent/100)

            carINSPercent = setCarINSPercent.text.toString().toDouble()
            totalPercent += (carINSPercent/100)

            carMaintPercent = setCarMaintPercent.text.toString().toDouble()
            totalPercent += (carMaintPercent/100)

            phonePercent = setPhonePercent.text.toString().toDouble()
            totalPercent += (phonePercent/100)

            gymPercent = setGymPercent.text.toString().toDouble()
            totalPercent += (gymPercent/100)

            healthINSPercent = setHealthINSPercent.text.toString().toDouble()
            totalPercent += (healthINSPercent/100)

            setTotalPercent.setText(String.format("%.2f", totalPercent*100))


            if(totalPercent < 1) {//checks to make sure the user hasn't added up more than 100%
                val intent = Intent(this, CalculatedActivity()::class.java)
                intent.putExtra("utility", utilityPercent/100)
                intent.putExtra("entertain", entertainPercent/100)
                intent.putExtra("grocery", grocerPercent/100)
                intent.putExtra("home", homeINSPercent/100)
                intent.putExtra("wifi", wifiPercent/100)
                intent.putExtra("carPay", carPayPercent/100)
                intent.putExtra("carINS", carINSPercent/100)
                intent.putExtra("carMaint", carMaintPercent/100)
                intent.putExtra("phone", phonePercent/100)
                intent.putExtra("gym", gymPercent/100)
                intent.putExtra("health", healthINSPercent/100)
                intent.putExtra("Income", userIncome)
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext, "The percentages given are greater than 100% please make adjustments and try again",Toast.LENGTH_LONG).show() //Displays a toast if the user went over 100%
            }
        }
    }
}