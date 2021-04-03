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

        val addContactDialog = AlertDialog.Builder(this)
                .setTitle("Add Contact")
                .setMessage("Do you want to add person to your contacts list?")
                .setIcon(R.drawable.ic_add_contact)
                .setPositiveButton("Yes") {
                    // Don't need parameters
                    _, _ ->
                    Toast.makeText(this,"You added the person the contacts.", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") {
                    // Don't need parameters
                    _, _ ->
                    Toast.makeText(this,"You didn't add the person the contacts.", Toast.LENGTH_SHORT).show()
                }.create()

        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First item", "Second item", "Third item")
        val singleChoiceDialog = AlertDialog.Builder(this)
                .setTitle("Please choose an option")
                .setSingleChoiceItems(options, 0) {
                    dialogInterface, i ->
                    Toast.makeText(this,"You clicked on ${options[i]}.", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Accept") {
                    // Don't need parameters
                    _, _ ->
                    Toast.makeText(this,"You accepted the single choice.", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Decline") {
                    // Don't need parameters
                    _, _ ->
                    Toast.makeText(this,"You didn't accept.", Toast.LENGTH_SHORT).show()
                }.create()

        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
                .setTitle("Please choose an option")
                .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) {
                    _, i, isChecked ->
                    if(isChecked) {
                        Toast.makeText(this,"You checked ${options[i]}.", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(this,"You unchecked ${options[i]}.", Toast.LENGTH_SHORT).show()
                    }

                }
                .setPositiveButton("Accept") {
                    // Don't need parameters
                    _, _ ->
                    Toast.makeText(this,"You accepted the multichoice dialog.", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Decline") {
                    // Don't need parameters
                    _, _ ->
                    Toast.makeText(this,"You didn't accept the multichoice dialog.", Toast.LENGTH_SHORT).show()
                }.create()

        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
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