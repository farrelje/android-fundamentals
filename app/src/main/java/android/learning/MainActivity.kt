package android.learning

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        btnRequestPermissions.setOnClickListener {
            requestPermissions()
        }
    }

    private fun hasWriteExternalStoragePermission() =
            ActivityCompat.
            checkSelfPermission(
                    this, Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForeGroundPermission() =
            ActivityCompat.
            checkSelfPermission(
                    this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

    // Might crash without a check for Android Q or not
    private fun hasLocationBackgroundPermission() =
            ActivityCompat.
            checkSelfPermission(
                    this, Manifest.permission.ACCESS_BACKGROUND_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissions() {
        var permissionsToRequest = mutableListOf<String>()
        if(!hasWriteExternalStoragePermission()) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if(!hasLocationForeGroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(!hasLocationBackgroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        // Activity context is important
        if(permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 0 && grantResults.isNotEmpty()) {
            for(i in grantResults.indices) {
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionsRequest", "${permissions[i]} granted.")
                }
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