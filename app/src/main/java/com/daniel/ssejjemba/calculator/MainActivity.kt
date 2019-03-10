package com.daniel.ssejjemba.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun btnNumberEvent(view: View){
        val buSelected = view as Button
        var buClickValue:String = etResults.text.toString()
        if(isNewOperation==true){
            etResults.setText("")
        }
        isNewOperation = false

        when(buSelected.id){
            R.id.bu0 -> {
                if(buClickValue != "0")buClickValue += "0"
            }
            R.id.bu1 -> buClickValue += "1"
            R.id.bu2 -> buClickValue += "2"
            R.id.bu3 -> buClickValue += "3"
            R.id.bu4 -> buClickValue += "4"
            R.id.bu5 -> buClickValue += "5"
            R.id.bu6 -> buClickValue += "6"
            R.id.bu7 -> buClickValue += "7"
            R.id.bu8 -> buClickValue += "8"
            R.id.bu9 -> buClickValue += "9"
            R.id.buDot -> {
                if(!(buClickValue.contains('.')))
                    buClickValue += "."
            }
            R.id.buSign -> {
                when {
                    buClickValue.startsWith("-") -> buClickValue.replaceFirst("-","+")
                    buClickValue.startsWith("+") -> buClickValue.replaceFirst("+","-")
                    else -> buClickValue = "-$buClickValue"
                }
            }
        }

        etResults.setText(buClickValue)


    }

    var op = "*"
    var oldNumber = ""
    var isNewOperation = true

    protected fun btnOperationEvent(view:View){
        val buSelected = view as Button

        when(buSelected.id){
            R.id.buMultiply -> op = "*"
            R.id.buSubtract -> op = "-"
            R.id.buDivide -> op = "/"
            R.id.buAdd -> op = "+"
            R.id.buPercent -> op = "%"
        }

        oldNumber = etResults.text.toString()
        isNewOperation = true
    }
}
