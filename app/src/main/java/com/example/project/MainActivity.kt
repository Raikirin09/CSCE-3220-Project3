package com.example.project

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// Replace with your actual package name
class MainActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
    }

    fun onRedButtonClick(view: View?) {
        imageView!!.setImageResource(R.drawable.red_image) // Change to the appropriate red image resource
    }

    fun onGreenButtonClick(view: View?) {
        imageView!!.setImageResource(R.drawable.green_image) // Change to the appropriate green image resource
    }

    fun onBlueButtonClick(view: View?) {
        imageView!!.setImageResource(R.drawable.blue_image) // Change to the appropriate blue image resource
    }
}
