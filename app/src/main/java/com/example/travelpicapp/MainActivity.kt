package com.example.travelpicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    lateinit var image: ImageView
    var places = arrayOf("Munnar", "Thanjavur", "Udumalpet", "Valparai", "Madurai")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNxt)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tvName)

        next.setOnClickListener {
            // get nxt image
            var idCurrentImageString = "pic$currentImage"

            // get integer address associated each view (image)
            var idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            //increment currentImage and show nxt image and set alpha to 1
            currentImage = (5 + currentImage + 1) % 5
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]


        }

        prev.setOnClickListener {
            //get prev image
            var idCurrentImageString = "pic$currentImage"

            // get integer address associated each design
            var idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            //increment currentImage and show nxt image and set alpha to 1
            currentImage = (5 + currentImage - 1) % 5
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]

        }
    }
}