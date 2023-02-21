package com.hye.login_process

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hye.login_process.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnBlue.setOnClickListener {
            val intent1 = Intent(this,MainActivity2::class.java)
            startActivity(intent1)
        }

        binding.btnKakao.setOnClickListener {
            Toast.makeText(this, "KAKAO", Toast.LENGTH_SHORT).show()
        }

        binding.btnNaver.setOnClickListener {
            Toast.makeText(this, "NAVER", Toast.LENGTH_SHORT).show()
        }
        binding.btnApple.setOnClickListener {
            Toast.makeText(this, "APPLE", Toast.LENGTH_SHORT).show()
        }


    }
}