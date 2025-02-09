package com.example.myapplication

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var valentineText: TextView
    private var noClickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link UI elements
        videoView = findViewById(R.id.videoView)
        yesButton = findViewById(R.id.yesButton)
        noButton = findViewById(R.id.noButton)
        valentineText = findViewById(R.id.valentineText)

        yesButton.setOnClickListener {
            playVideo(R.raw.kiss) // Play yes video
            valentineText.text = "I love you so much 💗💗"
            valentineText.setTextColor(Color.RED)
            valentineText.textSize = 35f // Increase text size
        }

        noButton.setOnClickListener {
            moveNoButton()
            noClickCount++
            if (noClickCount >= 2) {
                playVideo(R.raw.cateye) // Play second "No" video after 2 clicks
            } else {
                playVideo(R.raw.angry) // Play first "No" video
            }
        }
    }

    private fun playVideo(videoResId: Int) {
        val videoPath = "android.resource://$packageName/$videoResId"
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }

    private fun moveNoButton() {
        val randomX = Random.nextInt(100, 800) // Adjust the range based on screen size
        val randomY = Random.nextInt(100, 1500)

        noButton.x = randomX.toFloat()
        noButton.y = randomY.toFloat()
    }
}
