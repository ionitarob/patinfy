package cat.urv.deim.asm.patinfly

class UserRepository{
    private val userList = mutableListOf<User>()

    fun addUser(user: User){
        userList.add(user)
    }
    fun getLastUser(): User {
        return userList.last()
    }
}