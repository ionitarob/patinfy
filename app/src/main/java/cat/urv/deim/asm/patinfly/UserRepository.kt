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

    suspend fun userExist(userDao: UserDao,userEmail: String): Boolean{
        return withContext(Dispatchers.IO) {
            userDao.userExist(userEmail)
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

    suspend fun setUserPassword(userDao: UserDao, userEmail: String, userPassword: String){
        return withContext(Dispatchers.IO) {
            userDao.setUserPassword(userEmail, userPassword)
        }
    }

    suspend fun updateUser(userDao: UserDao, firstName: String, lastName: String, id: String, email: String, password: String, phone: Int?, nationality: String, km: Int?, userEmail: String) {
        return withContext(Dispatchers.IO){
        userDao.updateUser(firstName, lastName, id, email, password, phone, nationality, km, userEmail)
        }
    }

    suspend fun deleteUser(userDao: UserDao, user: User){
        return withContext(Dispatchers.IO){
            userDao.deleteUser(user)
        }
    }

    suspend fun deleteAllUsers(userDao: UserDao){
        return withContext(Dispatchers.IO){
            userDao.deleteAllUsers()
        }
    }
}