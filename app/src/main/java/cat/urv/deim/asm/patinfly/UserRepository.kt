package cat.urv.deim.asm.patinfly

import android.widget.EditText

class UserRepository{
    private val userList = mutableListOf<User>()

    fun addUser(user: User){
        userList.add(user)
    }

    fun updateUser(userEmail: EditText, userUpdate: User){
        val aux = userList.indexOfFirst {
            it.email.equals(userEmail)
        }
        if (aux != -1) {
            userList[aux] = userUpdate
        }
    }
    fun getLastUser(): User {
        return userList.last()
    }

    fun getLastByEmail(email: String): User? {
        return userList.find { it.email == email }
    }
}