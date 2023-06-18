package cat.urv.deim.asm.patinfly
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)
    @Delete
    fun deleteUser(user: User)
    @Query("DELETE FROM users")
    fun deleteAllUsers()

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE email = :userEmail")
    fun getUserByEmail(userEmail: String): User

    @Query("SELECT EXISTS(SELECT 1 FROM users WHERE email = :userEmail AND password = :userPassword)")
    fun userExists(userEmail: String, userPassword: String): Boolean

    @Query("SELECT * FROM users ORDER BY id DESC LIMIT 1")
    fun getLastAddedUser(): User

    @Query("UPDATE users SET password = :userPassword WHERE email = :userEmail")
    fun setUserPassword(userEmail: String, userPassword: String)
    @Update
    fun updateUserData(user: User)
}