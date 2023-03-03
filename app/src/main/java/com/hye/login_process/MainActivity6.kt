package com.hye.login_process
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import com.hye.login_process.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {

    //전체 입력값이 빈값이 아님을 확인
    fun validation() {
        binding.btnNext.isEnabled = binding.genderSpinner.selectedItem.toString().isNotBlank()
                && binding.etName.text.toString().isNotEmpty()
                && binding.etBirthday.text.toString().isNotEmpty()
                && binding.etEmail.text.toString().isNotEmpty()

    }


    private lateinit var binding: ActivityMain6Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // 스피너 만들기
        //스피너에 들어갈 데이터
        val gender = arrayOf("남성", "여성")


        //어댑터 생성
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, gender
        )

        //어댑터 설정 cf. android.R은 시스템상 원래있는 리소스를 뜻한다고함
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //스피너에 어댑터 적용
        binding.genderSpinner.adapter = adapter


        binding.etName.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validation()

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        binding.etBirthday.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validation()

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        binding.etEmail.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validation()

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })



        //뒤로 버튼 동작
        binding.btnBack.setOnClickListener {
            val intent1 = Intent(this,MainActivity5::class.java)
            startActivity(intent1)
        }


        //다음 버튼 동작 - 전체 값이 모두 채워진 경우 다음페이지로
        binding.btnNext.setOnClickListener {
            val intent1 = Intent(this,MainActivity7::class.java)
            startActivity(intent1)
        }

    }
}