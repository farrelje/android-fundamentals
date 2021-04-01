package android.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.edittext.*
import kotlinx.android.synthetic.main.imageview.*
import kotlinx.android.synthetic.main.radio_checkbox.*
import kotlinx.android.synthetic.main.textview.*
import kotlinx.android.synthetic.main.toasts.*
import java.util.*

class MainActivity : AppCompatActivity() {
    // startup entry of Android app
    // CTRL + ALT + L to auto-format code
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnApply.setOnClickListener {
            val name: String = etName.text.toString()
            val age: Int = etAge.text.toString().toInt()
            val country: String = etCountry.text.toString()
            val person = Person(name, age, country)
            Intent(this, SecondActivity::class.java).also {
                // Use these conventions to pass data
                it.putExtra("EXTRA_PERSON", person)
                startActivity(it)
            }
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