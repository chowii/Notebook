package com.examples.activity_launch_mode.taskAffinity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.examples.activity_launch_mode.R
import kotlinx.android.synthetic.main.activity_task_affinity_first.*

class TaskAffinityTestFirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_affinity_first)

        first_affinity_to_finish_activity_button.setOnClickListener {
            finish()
        }
        
        first_affinity_finish_affinity_button.setOnClickListener {
            finishAffinity()
        }

        first_affinity_to_second_affinity_activity_button.setOnClickListener {
            startActivity(Intent(this, TaskAffinityTestSecondActivity::class.java))
        }
    }
}