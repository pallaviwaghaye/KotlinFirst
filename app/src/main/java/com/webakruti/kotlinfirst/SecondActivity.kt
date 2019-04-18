package com.webakruti.kotlinfirst

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack) as ImageView
        imageViewBack.setOnClickListener {
            val intent1 = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(intent1)
            finish()
        }

        showRandomNumber()
    }

    @SuppressLint("WrongViewCast")
    fun showRandomNumber() {
        // Get the count from the intent extras
        val count = intent.getIntExtra(TOTAL_COUNT, 0)

        // Generate the random number
        val random = Random()
        var randomInt = 0
        // Add one because the bound is exclusive
        if (count > 0) {
            // Add one because the bound is exclusive
            randomInt = random.nextInt(count + 1)
        }

        // Display the random number.
        findViewById<TextView>(R.id.textViewRandomCount).text = Integer.toString(randomInt)

        // Substitute the max value into the string resource
        // for the heading, and update the heading
      //  findViewById<TextView>(R.id.textview_label).text = getString(R.string.random_heading, count)
    }
}
