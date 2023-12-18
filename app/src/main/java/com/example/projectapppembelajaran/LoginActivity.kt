package com.example.projectapppembelajaran

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectapppembelajaran.api.ApiConfig
import com.example.projectapppembelajaran.model.ResponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val masuk = findViewById<Button>(R.id.btn_login_masuk)

        masuk.setOnClickListener{
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            login()
        }

        var register = findViewById(R.id.halaman_register) as TextView

        register.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun login() {
        val emailMasuk  = findViewById<EditText>(R.id.emailMasuk)
        val passwordMasuk  = findViewById<EditText>(R.id.passwordMasuk)

        if (emailMasuk.text.isEmpty()) {
            emailMasuk.error = "Email Wajib Di isi!"
            emailMasuk.requestFocus()
            return
        } else if (passwordMasuk.text.isEmpty()) {
            passwordMasuk.error = "Password Wajib Di isi!"
            passwordMasuk.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.login(emailMasuk.text.toString(),passwordMasuk.text.toString()).enqueue(object : Callback<ResponModel>{
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val respon =response.body() !!
                if (respon.status == 200){
                    Toast.makeText(this@LoginActivity, "Login Anda Berhasil, Welcome to Berada Aplikasi", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()  // Menutup aktivitas saat ini agar pengguna tidak dapat kembali ke halaman pendaftaran
                    }, 1000)

                }else {
                    Toast.makeText(this@LoginActivity, respon.message, Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }

        })


    }
}