package com.examples.activity_launch_mode.taskAffinity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.examples.activity_launch_mode.R
import kotlinx.android.synthetic.main.activity_task_affinity_test_second.*

class TaskAffinityTestSecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_affinity_test_second)

        second_affinity_finish_activity.setOnClickListener {
            finish()
        }

        second_affinity_finish_affinity.setOnClickListener {
            finishAffinity()
        }

        second_to_third_affinity_activity_button.setOnClickListener {
            startActivity(Intent(this, TaskAffinityTestThirdActivity::class.java))
        }

        second_to_first_no_affinity_activity_button.setOnClickListener {
            startActivity(Intent(this, TaskAffinityTestNoAffinityFirstActivity::class.java))
        }
    }
}