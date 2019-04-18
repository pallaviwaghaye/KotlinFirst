package com.webakruti.kotlinfirst

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.webakruti.kotlinfirst.R.id.textView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAlert = findViewById<Button>(R.id.buttonAlert)
        buttonAlert.setOnClickListener(this)
        val buttonRecyclerView = findViewById<Button>(R.id.buttonRecyclerView)
        buttonRecyclerView.setOnClickListener(this)

        val buttonRetrofit = findViewById<Button>(R.id.buttonRetrofit)
        buttonRetrofit.setOnClickListener(this)
        /*val textView = findViewById<TextView>(R.id.textView)
        textView.setText("string").toString()
        val textViewValue = textView.text*/


        //val hello = "hello"
        //val textView1: TextView = findViewById(R.id.textView) as TextView
        /*val textView = findViewById<TextView>(R.id.textView)
        textView.setOnClickListener {
            textView.text = getString(R.string.app_name)
        }*/
    }


    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.buttonAlert -> {
                val builder = AlertDialog.Builder(this)
                //set title for alert dialog
                builder.setTitle("Testing....!!")
                //set message for alert dialog
                builder.setMessage("Are you sure ?")
                builder.setIcon(android.R.drawable.ic_dialog_alert)

                //performing positive action
                builder.setPositiveButton("Yes"){dialogInterface, which ->
                    Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_LONG).show()
                }
                //performing cancel action
                builder.setNeutralButton("Cancel"){dialogInterface , which ->
                    Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
                }
                //performing negative action
                builder.setNegativeButton("No"){dialogInterface, which ->
                    Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
                }
                // Create the AlertDialog
                val alertDialog: AlertDialog = builder.create()
                // Set other dialog properties
                alertDialog.setCancelable(false)
                alertDialog.show()
            }

            R.id.buttonRecyclerView -> {

                val intent = Intent(this, RecyclerViewActivity::class.java)
                startActivity(intent)

            }

            R.id.buttonRetrofit -> {
                val intent1 = Intent(this, RetrofitActivity::class.java)
                startActivity(intent1)
            }

        }
    }


    fun toastMe(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }


    fun countMe (view: View) {
        // Get the text view
        val showCountTextView = findViewById<TextView>(R.id.textView)

        // Get the value of the text view.
        val countString = showCountTextView.text.toString()

        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++

        // Display the new value in the text view.
        showCountTextView.text = count.toString();
    }
    fun randomMe (view: View) {
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)

        // Get the current value of the text view.
        val countString = textView.text.toString()

        // Convert the count to an int
        val count = Integer.parseInt(countString)

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

        // Start the new activity.
        startActivity(randomIntent)
    }

}
