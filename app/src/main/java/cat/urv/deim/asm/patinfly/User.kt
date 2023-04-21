package cat.urv.deim.asm.patinfly

import java.io.Serializable

data class User(val firstName: String, val lastName: String, val email: String, var password: String?, val phone: Int?, val id: String, val nationality: String?, val km: Int): Serializable