package cat.urv.deim.asm.patinfly
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

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
    @Query("UPDATE users SET firstName = :firstName, lastName = :lastName, id = :id, email = :email, password = :password, phone = :phone, nationality = :nationality, km = :km WHERE email = :userEmail")
    fun updateUser(firstName: String, lastName: String, id: String, email: String, password: String, phone: Int?, nationality: String, km: Int?, userEmail: String)
    @Query("SELECT EXISTS(SELECT 1 FROM users WHERE email = :userEmail)")
    fun userExist(userEmail: String): Boolean
}