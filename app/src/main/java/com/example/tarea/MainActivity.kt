package com.example.tarea

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    private var clicables = Array(10){false}
    private var turno: Boolean = true
    private var pos: Int = 0
    private var fin:Boolean = false

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)
        button4 = findViewById(R.id.btn4)
        button5 = findViewById(R.id.btn5)
        button6 = findViewById(R.id.btn6)
        button7 = findViewById(R.id.btn7)
        button8 = findViewById(R.id.btn8)
        button9 = findViewById(R.id.btn9)



        button1.setOnClickListener{
            clicables[1]=true
            if(turno) {
                button1.setBackgroundColor(0xFF00FF00.toInt())
                playerBTurn(randomizer())
            }
            else
                button1.setBackgroundColor(0xFFFF0000.toInt())
            turno = !turno
        }
        button2.setOnClickListener{
            clicables[2]=true
            if(turno) {
                button2.setBackgroundColor(0xFF00FF00.toInt())
                playerBTurn(randomizer())
            }
            else
                button2.setBackgroundColor(0xFFFF0000.toInt())
            turno = !turno
        }

        button3.setOnClickListener{
            clicables[3]=true
            if(turno) {

                button3.setBackgroundColor(0xFF00FF00.toInt())
                playerBTurn(randomizer())
            }
            else
                button3.setBackgroundColor(0xFFFF0000.toInt())
            turno = !turno
        }
        button4.setOnClickListener{
            clicables[4]=true
            if(turno) {

                button4.setBackgroundColor(0xFF00FF00.toInt())
                playerBTurn(randomizer())
            }
            else
                button4.setBackgroundColor(0xFFFF0000.toInt())
            turno = !turno
        }
        button5.setOnClickListener{
            clicables[5]=true
            if(turno) {
                button5.setBackgroundColor(0xFF00FF00.toInt())
                playerBTurn(randomizer())
            }
            else
                button5.setBackgroundColor(0xFFFF0000.toInt())
            turno = !turno
        }
        button6.setOnClickListener{
            clicables[6]=true
            if(turno) {
                button6.setBackgroundColor(0xFF00FF00.toInt())
                playerBTurn(randomizer())
            }
            else
                button6.setBackgroundColor(0xFFFF0000.toInt())
            turno = !turno
        }
        button7.setOnClickListener{
            clicables[7]=true
            if(turno) {

                button7.setBackgroundColor(0xFF00FF00.toInt())
                playerBTurn(randomizer())
            }
            else
                button7.setBackgroundColor(0xFFFF0000.toInt())
            turno = !turno
        }
        button8.setOnClickListener{
            clicables[8]=true
            if(turno) {
                button8.setBackgroundColor(0xFF00FF00.toInt())
                playerBTurn(randomizer())
            }
            else
                button8.setBackgroundColor(0xFFFF0000.toInt())
            turno = !turno
        }
        button9.setOnClickListener{
            clicables[9]=true
            if(turno) {
                button9.setBackgroundColor(0xFF00FF00.toInt())
                playerBTurn(randomizer())
            }
            else
                button9.setBackgroundColor(0xFFFF0000.toInt())
            turno = !turno
        }

    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        Log.d("AH", "${this.turno}")
    }

    override fun onResume() {
        super.onResume()

        Log.d("AH", "${this.turno}")

    }





    fun randomizer(): Int{
        var rnd = (1..9).random()
        while(clicables[rnd])
            rnd = (1..9).random()

        return rnd
    }

    fun playerBTurn(pos:Int){
            if(pos == 1)
                button1.callOnClick()
            if(pos == 2)
                button2.callOnClick()
            if(pos == 3)
                button3.callOnClick()
            if(pos == 4)
                button4.callOnClick()
            if(pos == 5)
                button5.callOnClick()
            if(pos == 6)
                button6.callOnClick()
            if(pos == 7)
                button7.callOnClick()
            if(pos == 8)
                button8.callOnClick()
            if(pos == 9)
                button9.callOnClick()

    }

    fun jugar(){

            if(!turno){
                playerBTurn(randomizer())
            }

    }





}
