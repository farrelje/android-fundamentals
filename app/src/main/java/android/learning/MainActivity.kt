package android.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.edittext.*
import kotlinx.android.synthetic.main.imageview.*
import kotlinx.android.synthetic.main.radio_checkbox.*
import kotlinx.android.synthetic.main.textview.*
import java.util.*

class MainActivity : AppCompatActivity() {
    // startup entry of Android app
    // CTRL + ALT + L to auto-format code
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_checkbox)

        btnOrder.setOnClickListener {
            val checkedMeatId = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatId)
            val cheese = cbCheese.isChecked
            val onions = cbOnions.isChecked
            val salad = cbSalad.isChecked
            val orderString = "You ordered a burger with:\n" +
                    "${meat.text}," +
                    (if(cheese) "cheese " else "") +
                    (if(onions) "onions " else "") +
                    (if(salad) "salad " else "")
            tvOrder.text = orderString
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