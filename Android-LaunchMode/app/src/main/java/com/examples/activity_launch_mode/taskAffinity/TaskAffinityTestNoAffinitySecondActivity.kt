package com.examples.activity_launch_mode.taskAffinity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.examples.activity_launch_mode.R
import kotlinx.android.synthetic.main.activity_task_affinity_test_no_second_affinity.*

class TaskAffinityTestNoAffinitySecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_affinity_test_no_second_affinity)

        second_no_affinity_finish_affinity_button.setOnClickListener {
            finishAffinity()
        }

        second_no_affinity_finish_activity_button.setOnClickListener {
            finish()
        }

        to_third_affinity_activity_button.setOnClickListener {
            startActivity(Intent(this, TaskAffinityTestThirdActivity::class.java))
        }
    }
}