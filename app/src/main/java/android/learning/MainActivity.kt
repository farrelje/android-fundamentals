package android.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.edittext.*
import kotlinx.android.synthetic.main.textview.*
import java.util.*

class MainActivity : AppCompatActivity() {
    // startup entry of Android app
    // CTRL + ALT + L to auto-format code
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edittext)
        // Old Java
        //val btnApply = findViewById<Button>(R.id.btnSubmit)
        btnAdd.setOnClickListener {
            var firstNum: Int?
            var secondNumber: Int?
            try {
                firstNum = etNum1.text.toString().toInt()
                secondNumber =  etNum2.text.toString().toInt()
                val result = firstNum + secondNumber
                tvResult.text = result.toString()
            } catch (e: NumberFormatException) {
                Log.d("MainActivity","$e - Please use valid numbers only")
            }
            // string can go to editable, but not other way around
        }


    }

    // Lifecycle methods:
    // onCreate()
    // onStart()
    // onResume()
    // --> activity is running
    // onPause() --> onResume(); onPause() is guaranteed to be called and should be used
    // to save data
    // onStop() --> onRestart() / onDestroy()
}