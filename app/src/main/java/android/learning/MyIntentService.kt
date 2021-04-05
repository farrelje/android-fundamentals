package android.learning

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class MyIntentService : JobIntentService() {
    // Allows us to run background tasks when app isn't running/maximised

    init{
        instance = this
    }
    // Singleton to manage stop and start
    companion object {
        private lateinit var instance: MyIntentService
        var isRunning: Boolean = false
        // Used for newer versions with JobIntentService
        fun enqueueWork(context: Context, intent: Intent) {
            // function from JobIntentService for stack management and threads
            enqueueWork(context, MyIntentService::class.java, 1, intent)
        }
        fun stopService() {
            Log.d("MyIntentService", "Stopping service")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleWork(intent: Intent) {
        onHandleIntent(intent)
    }

    // remove override and make onHandleIntent private.
    private fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while(isRunning) {
                Log.d("MyIntentService", "Service is running")
                Thread.sleep(1000)
            }
        } catch(e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

}