package android.learning

import android.Manifest
import android.app.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
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
    // Allows us to have an alternative promise to a nullable, which we don't have to check for
    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // Notifications appear in top bar, great for info/sales, etc
        // Create notification channel
        createNotificationChannel()
        // Allow outside app to activate code
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        // Build the notification
        val notification = NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("Awesome notification")
                .setContentText("This is the context text")
                .setSmallIcon(R.drawable.ic_start)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent) // allow the notification to be clickable and lead to the app
                .build()

        val notificationManager = NotificationManagerCompat.from(this)

        btnShowNotification.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }

    fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT).apply {
                        // Change LED colour!
                        lightColor = Color.GREEN
                        enableLights(true)
            }
            // Default return type is any - must cast as NM
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
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