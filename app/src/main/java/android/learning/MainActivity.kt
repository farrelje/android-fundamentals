package android.learning

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
        setContentView(R.layout.toasts)

        btnShowToast.setOnClickListener {
            // activity (this) or app context doesn't matter for toast
            // but consider using application context otherwise to prevent memory leaks
            // Standard toast
            //Toast.makeText(applicationContext, "Hi, I'm a toast!", Toast.LENGTH_LONG).show()
            Toast(this).apply {
                duration = Toast.LENGTH_LONG
                // render custom toast
                view = layoutInflater.inflate(R.layout.custom_toast, cToast)
                show()
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