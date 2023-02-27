package com.hye.login_process

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import com.hye.login_process.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    //private var country: String? = null
    private var phone: String? = null


    //번호 & 인증번호 값이 빈값이 아님을 확인

    /**
     * Validation
     *함수에 대한 설명, 기능,
     * @param str 인자값에 대한 설명을 적을 수 있다아
     */
    fun validation(str:String) {
        binding.btnNext.isEnabled = binding.etPhone.text.toString().isNotEmpty()
                && binding.etPassword.text.toString().isNotEmpty() && passwordRegex(str)


    }

    //비밀번호 8글자 이상, 영어 대소문자, 숫자 포함
    fun passwordRegex(etPassword: String): Boolean {
        return etPassword.matches("^[A-Za-z0-9]{8,20}\$".toRegex())
    }


    //화면4에서 넘긴 값 받아오기 intent
    fun getExtra(){

        if (intent.hasExtra("전화번호")) {
            phone = intent.getStringExtra("전화번호")

        }
        else {
            Toast.makeText(this, "전달된 이름이 없습니다", Toast.LENGTH_SHORT).show()
        }
    }


    //전달 받은 값 보여주기
    fun show() {
        binding.etPhone.setText(phone)

    }


    private lateinit var binding: ActivityMain5Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtra()
        show()


        binding.etPassword.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validation(s.toString())

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })





        //뒤로 버튼 동작
        binding.btnBack.setOnClickListener {
            val intent1 = Intent(this,MainActivity4::class.java)
            startActivity(intent1)
        }

        //다음 버튼 동작 - 두 값이 모두 채워진 경우 다음페이지로
        binding.btnNext.setOnClickListener {
            val intent1 = Intent(this,MainActivity6::class.java)
            startActivity(intent1)
        }

    }

}