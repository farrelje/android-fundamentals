package android.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {
    // startup entry of Android app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf(5, 3, 6, 7, 9, 1)
        sortList(list)
        Log.d("MainActivity", "Hello, this is our first log message")
        println(list)
    }

    private fun sortList(list: List<Int>) {
        for(i in list.indices) {
            for(j in 0..list.size - 2) {
                if(list[j] > list[j+1]) {
                    Collections.swap(list, j, j+1)
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        println("Paused")
    }

    override fun onRestart() {
        super.onRestart()
        println("Restarted")
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