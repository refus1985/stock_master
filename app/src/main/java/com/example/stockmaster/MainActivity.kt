package com.example.stockmaster

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout


class MainActivity : AppCompatActivity() {

    private lateinit var frameLayout1: FrameLayout
    private lateinit var frameLayout2: FrameLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayout1 = findViewById(R.id.myFrameLayout1)
        frameLayout2 = findViewById(R.id.myFrameLayout2)

        val btnIniciar: Button = findViewById(R.id.botonIniciar)
        val btnIngresar: Button = findViewById(R.id.botonIngresar)

        btnIniciar.setOnClickListener {
            frameLayout2.visibility = View.VISIBLE
            frameLayout1.visibility = View.INVISIBLE
        }
        btnIngresar.setOnClickListener {
            val intent = Intent(this, Existencias::class.java)
            startActivity(intent)
        }
    }


}