package android.learning

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
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
        // Spinners are basically dropdowns
        val customList = listOf("First", "Second", "Third", "Fourth")
        val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        spMonths.adapter = adapter
        // onitemselected needs an anonymous object first to create a listener
        spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(
                        this@MainActivity,
                        "You selected ${parent?.getItemAtPosition(position).toString()}",
                        Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

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