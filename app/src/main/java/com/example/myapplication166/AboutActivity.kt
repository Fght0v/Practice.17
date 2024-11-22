package com.example.myapplication166

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val aboutTextView = findViewById<TextView>(R.id.textView)

        val aboutText = intent.getStringExtra("aboutText")

        if (aboutText != null) {
            aboutTextView.text = aboutText
        } else {
            aboutTextView.text = "Информация о программе:\n\n" +
                    "Это приложение позволяет изменять тему приложения.\n" +
                    "Вы также можете просмотреть информацию \"О программе\"."
        }
    }
    }
