package com.example.projectapppembelajaran

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actifvty_welcome)

        val login = findViewById<Button>(R.id.btn_login)

        login.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val register = findViewById<Button>(R.id.btn_menu_register)

        register.setOnClickListener{
            val inten = Intent(this, RegisterActivity::class.java)
            startActivity(inten)
        }
    }
}