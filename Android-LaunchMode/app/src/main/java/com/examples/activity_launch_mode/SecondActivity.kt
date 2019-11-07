package com.examples.activity_launch_mode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        back_button.setOnClickListener {
            onBackPressed()
        }

        forward_button.setOnClickListener {
            startActivity(Intent(this@SecondActivity, ThirdActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
        }
    }
}
