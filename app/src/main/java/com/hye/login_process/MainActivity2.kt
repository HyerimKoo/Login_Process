package com.hye.login_process

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.hye.login_process.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    //필수 값 버튼 체크 여부 확인 함수를 생성 >
    fun validation() {
        binding.btnNext.isEnabled = (binding.checkbox1.isChecked
                && binding.checkbox2.isChecked
                && binding.checkbox3.isChecked
                && binding.checkbox4.isChecked)


    }

    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //각문항(1~5번)별로 if T / else F 설정
        binding.checkbox1.setOnCheckedChangeListener { buttonView, isChecked ->
            validation()

        }

        binding.checkbox2.setOnCheckedChangeListener { buttonView, isChecked ->
            validation()

        }
        binding.checkbox3.setOnCheckedChangeListener { buttonView, isChecked ->
            validation()

        }

        binding.checkbox4.setOnCheckedChangeListener { buttonView, isChecked ->
            validation()

        }

        binding.checkbox5.setOnCheckedChangeListener { buttonView, isChecked ->
            validation()

        }


        //전체 동의(checkbox)는 if T(1-5전체동의) / else (1-5 전체 비동의) 근데 왜 ischecked 자꾸 빨간불이지?
        binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
            var checkbox = isChecked
            binding.checkbox1.isChecked = isChecked
            binding.checkbox2.isChecked = isChecked
            binding.checkbox3.isChecked = isChecked
            binding.checkbox4.isChecked = isChecked
            binding.checkbox5.isChecked = isChecked

            //이건 뷰바인딩 이전 형태
//            if (isChecked) {
//                binding.checkbox1.isChecked = true
//                binding.checkbox2.isChecked = true
//                binding.checkbox3.isChecked = true
//                binding.checkbox4.isChecked = true
//                binding.checkbox5.isChecked = true
//
//                }
//                else {
//                binding.checkbox1.isChecked = false
//                binding.checkbox2.isChecked = false
//                binding.checkbox3.isChecked = false
//                binding.checkbox4.isChecked = false
//                binding.checkbox5.isChecked = false
//                }

            //전체 동의가 되면 다음버튼 눌러서 다음 액티비티로 전환
            binding.btnNext.setOnClickListener {
                val intent1 = Intent(this, MainActivity3::class.java)
                startActivity(intent1)
            }
        }


    }
}
