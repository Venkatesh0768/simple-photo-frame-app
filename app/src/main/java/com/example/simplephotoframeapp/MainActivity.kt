package com.example.simplephotoframeapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image : ImageView
    var name = arrayOf("f1" , "f2" ,"f3" ,"f4")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnNext = findViewById<ImageButton>(R.id.btnnext)
        val btnPrev = findViewById<ImageButton>(R.id.btnprev)
        val text =   findViewById<TextView>(R.id.tvimage)

        btnPrev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f
            text.text= name[currentImage]

            currentImage = (4+ currentImage-1)%4
            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f


        }


        btnNext.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f
            text.text= name[currentImage]

            currentImage = (4+ currentImage+1)%4
            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f

        }


    }
}