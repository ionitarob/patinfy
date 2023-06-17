package cat.urv.deim.asm.patinfly

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository{
    suspend fun addUser(userDao: UserDao, user: User){
        return withContext(Dispatchers.IO){
          userDao.insert(user)
        }
    }

    suspend fun userExists(userDao: UserDao,userEmail: String, userPassword: String): Boolean{
        return withContext(Dispatchers.IO) {
            userDao.userExists(userEmail, userPassword)
        }
    }

    suspend fun getLastAddedUser(userDao: UserDao): User{
        return withContext(Dispatchers.IO) {
            userDao.getLastAddedUser()
        }
    }

    fun getUserByEmail(userDao: UserDao, userEmail: String): User{
            return userDao.getUserByEmail(userEmail)
    }

    suspend fun getAllUsers(userDao: UserDao): List<User>{
        return withContext(Dispatchers.IO) {
            userDao.getAllUsers()
        }
    }
}