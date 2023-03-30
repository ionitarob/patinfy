package com.example.patinfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.patinfy.databinding.ActivityLoginBinding
import com.example.patinfy.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}