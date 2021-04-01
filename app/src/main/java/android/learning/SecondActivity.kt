package android.learning

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.io.Serializable

class SecondActivity : AppCompatActivity() {
    // New activities must be registered in the manifest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val person: Serializable = intent.getSerializableExtra("EXTRA_PERSON") as Person
        val personString: String = person.toString()
        tvPerson.text = personString
    }
}