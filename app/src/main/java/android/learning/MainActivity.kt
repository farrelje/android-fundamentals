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
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
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

        val images = listOf(
            R.drawable.hugh,
            R.drawable.jonny,
            R.drawable.sid,
            R.drawable.spencer
        )

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) {
            tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        tabLayout.addOnTabSelectedListener( object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Re-selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Unselected ${tab?.text}", Toast.LENGTH_SHORT).show()

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }
        })
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