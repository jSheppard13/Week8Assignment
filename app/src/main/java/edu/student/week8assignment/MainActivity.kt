package edu.student.week8assignment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.getSystemService
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val et1 = findViewById<EditText>(R.id.txtNum1)
        val et2 = findViewById<EditText>(R.id.txtNum2)
        val btngo = findViewById<Button>(R.id.btnPage2)
        val txtsend = et1.text.toString().toInt() % et2.text.toString().toInt()

        btngo.setOnClickListener(View.OnClickListener {

            //Intent is used to send data between activities
            val intent = Intent(this, Main2Activity::class.java)
            //putExtra sets value to name SendStuff (Could be called whatever you want
            intent.putExtra("SendStuff",txtsend.toString())
            //Go to second activity
            startActivity(intent)

        })

        //Fire hidekeyboard when user taps outside any text object
        //Place below code right before last right bracket in function onCreate
        //findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
        //    hideKeyboard()
        //    false

        //}

    }
    //function to hide keyboard goes right before the last right bracket of Class MainActivity
    //should auto import android.content.Context
    //should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }
}
