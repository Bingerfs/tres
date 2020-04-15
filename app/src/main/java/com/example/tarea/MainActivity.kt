package com.example.tarea

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


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
    private var turn: Int = 1
    private var pos: Int = 0

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



        init()
        button1.setOnClickListener{
            onClick(it, 1)
        }
        button2.setOnClickListener{
            onClick(it, 2)
        }

        button3.setOnClickListener{
            onClick(it, 3)
        }
        button4.setOnClickListener{
            onClick(it, 4)
        }
        button5.setOnClickListener{
            onClick(it, 5)
        }
        button6.setOnClickListener{
            onClick(it, 6)
        }
        button7.setOnClickListener{
            onClick(it, 7)
        }
        button8.setOnClickListener{
            onClick(it, 8)
        }
        button9.setOnClickListener{
            onClick(it, 9)
        }

    }

    fun init(){
        for(i in 1..9)
        {
            var button = switch(i)
                button!!.setBackgroundColor(0xFF0000FF.toInt())
            button!!.isClickable=true
            pos=0
            turn=1
            turno=true
        }
    }

    fun onClick(button: View, pos:Int){
        Log.d("Uh", "$turn")
        button.isClickable = false
        turn++
        if(turno) {
            button.setBackgroundColor(0xFFFF0000.toInt())

            if(turn >= 5)
                isEnd(pos)
            turno = !turno
            playerBTurn(randomizer())
        }
        else
            button.setBackgroundColor(0xFF00FF00.toInt())
    }

    private val listener =
        View.OnClickListener {

            clicables[3]=true
            if(turno){
                button3.setBackgroundColor(0xFF00FF00.toInt())
                turno = !turno
            }
            else
                button3.setBackgroundColor(0xFFFF0000.toInt())
        }



    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        Log.d("AH", "${this.turno}")
    }

    override fun onResume() {
        super.onResume()

        Log.d("AH", "${this.turno}")

    }


    fun isEnd(pos: Int){
        var msg = ""
        if(turno)
            msg= "Gano jugador rojo"
        else
            msg= "Gano jugador verde"
        checkDraw()
        checkHorizontal(pos, msg)
        checkVertical(pos, msg)
        checkDiagonal(pos, msg)
    }




    fun checkHorizontal(pos:Int, msg:String){
        if(pos == 1 || pos == 4 || pos == 7)
        {
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos+1)!!.background as ColorDrawable
            var c = switch(pos+2)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color )
            {
                showWinner(msg)
                Log.d("Uh", "Gano")
            }

            Log.d("Uh", "${a.color} y ${b.color}")
        }
        else if( pos == 2 || pos == 5 || pos == 8){
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos-1)!!.background as ColorDrawable
            var c = switch(pos+1)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
                {showWinner(msg)
                    Log.d("Uh", "Gano")
                }
        }
        else if( pos == 3 || pos == 6 || pos == 9){
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos-1)!!.background as ColorDrawable
            var c = switch(pos-2)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
                {showWinner(msg)
                    Log.d("Uh", "Gano")
                }
        }
    }
    fun checkVertical(pos:Int, msg:String){
        if(pos == 1 || pos == 2 || pos == 3)
        {
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos+3)!!.background as ColorDrawable
            var c = switch(pos+6)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color )
            {
                showWinner(msg)
                Log.d("Uh", "Gano")
            }

            Log.d("Uh", "${a.color} y ${b.color}")
        }
        else if( pos == 4 || pos == 5 || pos == 6){
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos-3)!!.background as ColorDrawable
            var c = switch(pos+3)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
            {showWinner(msg)
                Log.d("Uh", "Gano")
            }
        }
        else if( pos == 7 || pos == 8 || pos == 9){
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos-3)!!.background as ColorDrawable
            var c = switch(pos-6)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
            {showWinner(msg)
                Log.d("Uh", "Gano")
            }
        }
    }

    fun checkDiagonal(pos:Int, msg:String){
        if(pos == 1){
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos+4)!!.background as ColorDrawable
            var c = switch(pos+8)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
            {showWinner(msg)
                Log.d("Uh", "Gano")
            }
        }
        else if(pos == 5){
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos+4)!!.background as ColorDrawable
            var c = switch(pos-4)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
            {showWinner(msg)
                Log.d("Uh", "Gano")
            }
            a = switch(pos)!!.background as ColorDrawable
            b  = switch(pos+2)!!.background as ColorDrawable
            c = switch(pos-2)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
            {showWinner(msg)
                Log.d("Uh", "Gano")
            }


        }
        else if(pos == 3){
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos+2)!!.background as ColorDrawable
            var c = switch(pos+4)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
            {showWinner(msg)
                Log.d("Uh", "Gano")
            }
        }
        else if(pos == 7){
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos-2)!!.background as ColorDrawable
            var c = switch(pos-4)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
            {showWinner(msg)
                Log.d("Uh", "Gano")
            }
        }
        else if(pos == 9){
            var a = switch(pos)!!.background as ColorDrawable
            var b  = switch(pos-4)!!.background as ColorDrawable
            var c = switch(pos-8)!!.background as ColorDrawable
            if(a.color == b.color &&  a.color == c.color)
            {showWinner(msg)
                Log.d("Uh", "Gano")
            }
        }
    }

    fun checkDraw(){
        if( turn == 9)
            showWinner("Empate")
    }



    fun showWinner(msg:String) {
        val builder = AlertDialog.Builder(this) // Builder needs a context
        builder.setTitle(msg)
        builder.setMessage("Gracias por participar")
        builder.setPositiveButton("Reiniciar"){dialog, which ->
            init()
        }
        builder.show()

    }



    fun randomizer(): Int{
        var rnd = (1..9).random()
        if(turn < 9) {
            while (!switch(rnd)!!.isClickable)
                rnd = (1..9).random()
        }else
            rnd = 0

        return rnd
    }

    fun playerBTurn(pos:Int){

        val a = switch(pos)
        if(a !== null)
        {a.callOnClick()
        a.isClickable = false
            if (turn>=5)
        isEnd(pos)
            turno = !turno}


    }

    fun switch(pos: Int): Button? {
        var but: Button? = null
        if(pos == 1)
            but= button1
        if(pos == 2)
            but= button2
        if(pos == 3)
            but= button3
        if(pos == 4)
            but= button4
        if(pos == 5)
            but= button5
        if(pos == 6)
            but= button6
        if(pos == 7)
            but= button7
        if(pos == 8)
            but= button8
        if(pos == 9)
            but= button9
        return but
    }

    fun jugar(){

            if(!turno){
                playerBTurn(randomizer())
            }

    }





}
