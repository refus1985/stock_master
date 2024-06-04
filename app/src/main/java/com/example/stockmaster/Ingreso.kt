package com.example.stockmaster

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton

class Ingreso : AppCompatActivity() {

    private lateinit var frameLayoutMenu: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        val btnMenu: ImageButton = findViewById(R.id.btnmenu)

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
}