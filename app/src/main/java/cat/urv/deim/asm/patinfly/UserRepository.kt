package cat.urv.deim.asm.patinfly

class UserRepository{
    private val userList = mutableListOf<User>()

    fun addUser(userDao: UserDao, user: User){
        return userDao.insert(user)
    }
    fun getLastUser(): User {
        return userList.last()
    }
    fun getUserByID (userDao: UserDao, id: String): User {
        return userDao.getUserByID(id)
    }
}