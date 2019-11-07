package com.examples.activity_launch_mode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.examples.activity_launch_mode.taskAffinity.TaskAffinityTestFirstActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        task_affinity_test_activity_button.setOnClickListener {
            startActivity(Intent(this, TaskAffinityTestFirstActivity::class.java))
        }

        back_button.setOnClickListener {
            onBackPressed()
        }

        forward_button.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, SecondActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            )
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("LOG_TAG---", "onNewIntent: ${this.javaClass.simpleName}")
    }
}
