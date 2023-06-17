package cat.urv.deim.asm.patinfly

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @ColumnInfo var firstName: String,
    @ColumnInfo var lastName: String,
    @ColumnInfo var email: String,
    @ColumnInfo var password: String?,
    @ColumnInfo var phone: Int?,
    @PrimaryKey var id: String,
    @ColumnInfo var nationality: String?,
    @ColumnInfo var km: Int?)