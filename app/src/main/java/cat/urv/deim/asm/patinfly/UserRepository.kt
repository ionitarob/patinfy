package cat.urv.deim.asm.patinfly

import androidx.room.Query

class UserRepository{
    fun addUser(userDao: UserDao, user: User){
        return userDao.insert(user)
    }
    fun getUserByID (userDao: UserDao, id: String): User {
        return userDao.getUserByID(id)
    }

    fun getUserByEmail(userDao: UserDao, userEmail: String): Boolean{
        return userDao.getUserByEmail(userEmail)
    }

    fun getUserByPw(userDao: UserDao, userPw: String): Boolean{
        return userDao.getUserByPw(userPw)
    }
}