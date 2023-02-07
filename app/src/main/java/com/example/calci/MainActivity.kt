package com.example.calci

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        creating variables for numbers.

        one.setOnClickListener { evaluateExpression("1",true) }
        two.setOnClickListener { evaluateExpression("2",true) }
        three.setOnClickListener { evaluateExpression("3",true) }
        four.setOnClickListener { evaluateExpression("4",true) }
        five.setOnClickListener { evaluateExpression("5",true) }
        six.setOnClickListener { evaluateExpression("6",true) }
        seven.setOnClickListener { evaluateExpression("7",true) }
        eight.setOnClickListener { evaluateExpression("8",true) }
        nine.setOnClickListener { evaluateExpression("9",true) }
        zero.setOnClickListener { evaluateExpression("0",true) }
        deci.setOnClickListener { evaluateExpression(".",true) }




//       creating variables for operators

        plus.setOnClickListener{evaluateExpression("+",false)}
        expo.setOnClickListener{evaluateExpression("^",false)}
        minus.setOnClickListener{evaluateExpression("-",false)}
        mul.setOnClickListener{evaluateExpression("*",false)}
        div.setOnClickListener{evaluateExpression("/",false)}
        percent.setOnClickListener{evaluateExpression("%",false)}

//        for clear button

        clear.setOnClickListener {
            fnum.text=""
            Result.text = ""
        }

//        for delete button
        del.setOnClickListener {
            val string = fnum.text.toString()
            if(string.isNotEmpty()){
                fnum.text = string.substring(0,string.length-1)

            }
            Result.text=""
        }

//        for equal button
        equal.setOnClickListener {
                val expression = ExpressionBuilder(fnum.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    Result.text=longResult.toString()
                else
                    Result.text=result.toString()
        }
    }

//    for evaluation expression
    fun evaluateExpression(string:String , clear:Boolean){
        if(Result.text.isNotEmpty()){
            fnum.text = ""
        }
        if(clear){
                Result.text=""
                fnum.append(string)
            }
        else{
        fnum.append(Result.text)
        fnum.append(string)
        Result.text=""
            }
        }


    }
