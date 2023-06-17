package cat.urv.deim.asm.patinfly
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE email = :userEmail")
    fun getUserByEmail(userEmail: String): User

    @Query("SELECT EXISTS(SELECT 1 FROM users WHERE email = :userEmail AND password = :userPassword)")
    fun userExists(userEmail: String, userPassword: String): Boolean

    @Query("SELECT * FROM users ORDER BY id DESC LIMIT 1")
    fun getLastAddedUser(): User


}