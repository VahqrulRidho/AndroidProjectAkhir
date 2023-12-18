package com.example.projectapppembelajaran

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectapppembelajaran.api.ApiConfig
import com.example.projectapppembelajaran.model.ResponModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val register = findViewById<Button>(R.id.btn_kirim_register)

        register.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
            register()
        }


        val login = findViewById(R.id.halaman_login) as TextView

        login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun register() {
        val username = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val namaLengkap = findViewById<EditText>(R.id.namaLengkap)
        val nim = findViewById<EditText>(R.id.nim)
        val prodi = findViewById<EditText>(R.id.prodi)

        if (username.text.isEmpty()) {
            username.error = "Kolom Username tidak boleh kosong"
            username.requestFocus()
            return
        } else if (email.text.isEmpty()) {
            email.error = "Kolom Email tidak boleh kosong"
            email.requestFocus()
            return
        } else if (password.text.isEmpty()) {
            password.error = "Kolom Password tidak boleh kosong"
            password.requestFocus()
            return
        } else if (namaLengkap.text.isEmpty()) {
            namaLengkap.error = "Kolom Nama Lengkap tidak boleh kosong"
            namaLengkap.requestFocus()
            return
        } else if (nim.text.isEmpty()) {
            nim.error = "Kolom NIM tidak boleh kosong"
            nim.requestFocus()
            return
        } else if (prodi.text.isEmpty()) {
            prodi.error = "Kolom Program Studi tidak boleh kosong"
            prodi.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.register(username.text.toString(),email.text.toString(),password.text.toString(),namaLengkap.text.toString(),nim.text.toString(),prodi.text.toString()).enqueue(object :Callback<ResponModel>{
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val respon =response.body() !!

                if (respon.status == 200){
                    Toast.makeText(this@RegisterActivity, "Berhasil Membuat Akun, Silahkan Login", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }, 1000)

                }else {
                    Toast.makeText(this@RegisterActivity, "Gagal :" + respon.message, Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }

        } )

    }
}


