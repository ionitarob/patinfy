package cat.urv.deim.asm.patinfly

import android.widget.Spinner

data class User(val firstName: String, val lastName: String, val email: String, var password: String, val phone: Int, val id: String, val nationality: Spinner, val km: Int)