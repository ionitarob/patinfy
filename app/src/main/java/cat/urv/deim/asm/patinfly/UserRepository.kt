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

    suspend fun getUserByEmail(userDao: UserDao, userEmail: String): User{
        return withContext(Dispatchers.IO) {
            userDao.getUserByEmail(userEmail)
        }
    }

    suspend fun getAllUsers(userDao: UserDao): List<User>{
        return withContext(Dispatchers.IO) {
            userDao.getAllUsers()
        }
    }

    suspend fun setUserPassword(userDao: UserDao, user: User,userPassword: String){
        return withContext(Dispatchers.IO) {
            userDao.setUserPassword(user, userPassword)
        }
    }
}