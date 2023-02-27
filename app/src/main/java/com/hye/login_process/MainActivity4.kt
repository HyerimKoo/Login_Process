package com.hye.login_process

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.hye.login_process.databinding.ActivityMain4Binding
import timber.log.Timber

class MainActivity4 : AppCompatActivity() {

//    const val country

    //클래스에 변수 선언
    //val value :String? = null

    // value = intent.getStringExtra("keystring")

    private var country: String? = null
    private var phone: String? = null

    private lateinit var binding: ActivityMain4Binding

    //스피너 & 번호, 인증번호 값이 빈값이 아님을 확인

    /**
     * validation 함수 : 빈 값인지 아닌지 확인
     */
    fun validation() {
        binding.btnNext.isEnabled = binding.etcountry.text.toString().isNotBlank()
                && binding.etPhone.text.toString().isNotEmpty()
                && binding.etCertiNum.text.toString().isNotEmpty()

    }



    //화면3에서 넘긴 값 받아오기 intent
    fun getExtra(){

        if (intent.hasExtra("국가입력") && intent.hasExtra("전화번호")) {
            country = intent.getStringExtra("국가입력")
            phone = intent.getStringExtra("전화번호")

        }
        else {
            Toast.makeText(this, "전달된 이름이 없습니다", Toast.LENGTH_SHORT).show()
        }
    }


    //값 보여주기
    fun show() {
        binding.etcountry.setText(country)
        binding.etPhone.setText(phone)

    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtra()
        show()


        //인증번호
        binding.etCertiNum.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validation()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }
        )





        //인증 완료 버튼 클릭 시 > 화면 넘기기
        binding.btnNext.setOnClickListener {
            val intent = Intent(this,MainActivity5::class.java)

            intent.putExtra("전화번호", binding.etPhone.text.toString())
            Timber.d(binding.etPhone.text.toString())

            startActivity(intent)
        }

    }


}
