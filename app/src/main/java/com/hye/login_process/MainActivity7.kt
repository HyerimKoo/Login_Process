package com.hye.login_process

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.hye.login_process.databinding.ActivityMain7Binding
import timber.log.Timber

class MainActivity7 : AppCompatActivity() {

    private lateinit var binding: ActivityMain7Binding

    fun showdialog() {
        //다이얼로그를 생성하기 위해 Builder 클래스 생성자 이용
        val builder = AlertDialog.Builder(this)
//        binding.etPhone
//        binding.countrySpinner

        builder.setTitle("종료하시겠습니까?")
            .setMessage("입력 종료시 현재까지 입력한 모든 내용이 저장되지 않고 사라집니다.")
            .setNegativeButton(
                "유지"
            ) { dialog, id ->
                dialog.dismiss()
            }
            .setPositiveButton("종료",
                DialogInterface.OnClickListener { dialog, id ->
                    //확인 클릭시 수행 할 내용!

                    val intent = Intent(this, MainActivity::class.java)

                    startActivity(intent)

                })


        // 다이얼로그를 띄워주기
        builder.show()

    }




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}