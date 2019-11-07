package com.examples.activity_launch_mode.taskAffinity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.examples.activity_launch_mode.R
import kotlinx.android.synthetic.main.activity_task_affinity_test_third.*

class TaskAffinityTestThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_affinity_test_third)

        third_finish_activity.setOnClickListener {
            finish()
        }

        third_finish_affinity.setOnClickListener {
            finishAffinity()
        }
    }
}