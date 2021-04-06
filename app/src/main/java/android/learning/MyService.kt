package android.learning

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

// Supports multithreading
class MyService : Service() {

    val TAG = "MyService"

    init{
        Log.d(TAG, "Service is running...")
    }
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG, dataString)
        }
//        Thread {
//            // do network calls or whatever
//        }.start()
        return START_STICKY // Won't recreate if has resources
    }
    // Cleanup function
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Service is being killed.")
    }


}