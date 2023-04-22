package cat.urv.deim.asm.patinfly

import java.io.Serializable

data class User(var firstName: String, var lastName: String, var email: String, var password: String?, var phone: Int?, var id: String, var nationality: String?, var km: Int?): Serializable