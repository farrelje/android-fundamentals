package android.learning

import java.io.Serializable

data class Person(
       val name: String,
       val age: Int,
       val country: String
): Serializable

// Need to implement serializable to transfer between views and networks