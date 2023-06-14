package cat.urv.deim.asm.patinfly

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Scooter(
    @PrimaryKey val uuid: String?,
    @ColumnInfo val name: String?,
    @ColumnInfo val longitude: String?,
    @ColumnInfo val latitude: String?,
    @ColumnInfo val battery_level: Double?,
    @ColumnInfo val km_use: Double?,
    @ColumnInfo val date_last_maintenance: String?,
    @ColumnInfo val state: String?,
    @ColumnInfo val on_rent: Boolean?
)