package cat.urv.deim.asm.patinfly

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "users")
data class User(var firstName: String,
                var lastName: String,
                var email: String,
                var password: String?,
                var phone: Int?,
                @PrimaryKey var id: String,
                var nationality: String?,
                var km: Int?)