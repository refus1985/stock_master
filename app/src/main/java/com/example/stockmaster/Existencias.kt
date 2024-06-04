package com.example.stockmaster

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.MotionEvent
import android.view.View
import android.widget.*
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class Existencias : AppCompatActivity() {

    private lateinit var frameLayoutMenu: FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_existencias)

        frameLayoutMenu = findViewById(R.id.myFrameLayoutMenu)

        val btnAcercade: Button = findViewById(R.id.acercade)

        val btnMenu: ImageButton = findViewById(R.id.btnmenu)

        val btnScan: Button = findViewById(R.id.scan)

        val sku: EditText = findViewById(R.id.sku)
        sku.isFocusable = false
        sku.isFocusableInTouchMode = false
        sku.isClickable = false
        val descripcion: EditText = findViewById(R.id.descripcion)
        descripcion.isFocusable = false
        descripcion.isFocusableInTouchMode = false
        descripcion.isClickable = false
        val categ: EditText = findViewById(R.id.categoria)
        categ.isFocusable = false
        categ.isFocusableInTouchMode = false
        categ.isClickable = false
        val prov: EditText = findViewById(R.id.proveedor)
        prov.isFocusable = false
        prov.isFocusableInTouchMode = false
        prov.isClickable = false
        val pzas: EditText = findViewById(R.id.pzas)
        pzas.isFocusable = false
        pzas.isFocusableInTouchMode = false
        pzas.isClickable = false
        val stock: EditText = findViewById(R.id.stock)
        stock.isFocusable = false
        stock.isFocusableInTouchMode = false
        stock.isClickable = false

        btnAcercade.setOnClickListener {

        }

        val btnRegistro: Button = findViewById(R.id.nuevo)
        btnRegistro.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }

        btnScan.setOnClickListener {
            val integrator = IntentIntegrator(this)
            integrator.setPrompt("Escanear un código de barras")
            integrator.initiateScan()
        }

        btnMenu.setOnClickListener {
            frameLayoutMenu.visibility = View.VISIBLE
            btnMenu.visibility = View.INVISIBLE
        }

        findViewById<View>(R.id.root_layout).setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                if (frameLayoutMenu.visibility == View.VISIBLE) {
                    val rect = Rect()
                    frameLayoutMenu.getGlobalVisibleRect(rect)
                    if (!rect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                        frameLayoutMenu.visibility = View.GONE
                        btnMenu.visibility = View.VISIBLE
                        v.performClick()
                    }
                }
            }
            false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result:IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if(result.contents == null){
            Toast.makeText(this,"Proceso Cancelado",Toast.LENGTH_SHORT).show()
        }else{
            val sku: EditText = findViewById(R.id.sku)
            sku.text = Editable.Factory.getInstance().newEditable(result.contents)


            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}