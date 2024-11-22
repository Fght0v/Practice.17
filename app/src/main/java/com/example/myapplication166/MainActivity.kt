package com.example.myapplication166

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val themeSwitchButton = findViewById<Button>(R.id.button)

        themeSwitchButton.setOnClickListener {
            toggleTheme()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        updateMenuTheme(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_item -> {
                toggleTheme()
                return true
            }
            R.id.about_menu_item -> {

                val intent = Intent(this, AboutActivity::class.java)

                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun toggleTheme() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        recreate()
    }
    private fun updateMenuTheme(menu: Menu?) {
        if (menu != null) {
            val themeSwitchItem = menu.findItem(R.id.settings_menu_item)
            if (themeSwitchItem != null) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    themeSwitchItem.title = "Сменить на светлую"
                    themeSwitchItem.setIcon(R.drawable.ic_launcher_foreground)
                } else {
                    themeSwitchItem.title = "Сменить на тёмную"
                    themeSwitchItem.setIcon(R.drawable.ic_launcher_background)
                }
            }
        }
    }
}
