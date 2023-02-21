package com.hye.login_process

import android.R.layout.simple_list_item_1
import android.R.layout.simple_spinner_dropdown_item
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.hye.login_process.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    //private var countrySpinner: String? = null

    fun validation() {
        binding.btnNext.isEnabled = binding.countrySpinner.selectedItem.toString()
            .isNotEmpty() && binding.etPhone.text.toString().isNotEmpty()

    }


    fun showdialog() {
        //다이얼로그를 생성하기 위해 Builder 클래스 생성자 이용
        val builder = AlertDialog.Builder(this)


        builder.setTitle("//여기로 전화번호 받을거임")
            .setMessage("해당 전화번호로 인증번호를 전송합니다.")
            .setNegativeButton(
                "취소"
            ) { dialog, id ->
                dialog.dismiss()
            }
            .setPositiveButton("확인",
                DialogInterface.OnClickListener { dialog, id ->
                    //확인 클릭시 수행 할 내용인데!
                    val intent1 = Intent(this, MainActivity4::class.java)
                    startActivity(intent1)

                })

        // 다이얼로그를 띄워주기
        builder.show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //1) 스피너 만들기
        //스피너에 들어갈 데이터
        val country = arrayOf("대한민국", "일본", "중국", "미국")

        //스피너 객체 생성
        //binding.countrySpinner
        //val countrySpinner: Spinner = findViewById(R.id.countrySpinner)

        //어댑터 생성
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            simple_list_item_1, country
        )

        //어댑터 설정
        adapter.setDropDownViewResource(simple_spinner_dropdown_item)

        //스피너에 어댑터 적용
        binding.countrySpinner.adapter = adapter
        //countrySpinner.adapter = adapter

        //2) edittext(etPhone) 값 가져오기 인데 값을 다이얼로그에 가져와야함. 근데 다이얼로그가 여기에 생성되는 것이 맞는지?
        binding.etPhone.text.toString()
        //binding.etPhone.addTextChangedListener()

        //EditText 값 있을때만 버튼 활성화
        binding.etPhone.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("test","$p0")
                validation()

            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        binding.btnNext.setOnClickListener {
            //페이지

            //정보 넘김
        }


    }

}



