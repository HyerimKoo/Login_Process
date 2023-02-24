package com.hye.login_process

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.hye.login_process.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {

    private lateinit var tv: TextView
    private var country: String? = null
    private var phone: String? = null

    private lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.countrySpinner
        binding.etPhone
//        val spinnerCountry = findViewById<EditText>(R.id.countrySpinner)
//        val editPhone = findViewById<EditText>(R.id.phoneNum)

        //페이지 넘어왔을때 이전에 스피너와 전화번호 정보(editText값) 값 가져오기
        binding.countrySpinner.onItemSelectedListener.toString()
        binding.etPhone

//        getEditTextObject()
//        {
//            phone = (EditText)findViewById(R.id.editText_number);
//        }
        binding.etPhone.text.toString()
        //값 보여주기
        fun showcountryphone() {
            if(!TextUtils.isEmpty(this.country) && !TextUtils.isEmpty(this.phone)){
                tv.text = "id : $country, pw : $phone"
            }
        }


        //인증 완료 버튼 클릭 시
        binding.btnNext.setOnClickListener {

        }

    }


    }
