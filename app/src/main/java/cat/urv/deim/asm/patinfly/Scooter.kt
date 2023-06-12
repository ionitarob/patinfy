package cat.urv.deim.asm.patinfly

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
@Entity
data class Scooter(
    @PrimaryKey val uuid: String,
    @ColumnInfo (name = "longitude") val longitude: String?,
    @ColumnInfo (name = "latitude") val latitude: String?,
    @ColumnInfo (name = "battery") val battery: Int?,
    @ColumnInfo (name = "meters_rec") val meters_rec: Int?,
    @ColumnInfo (name = "dataInc") val dataInc: Date?,
    @ColumnInfo (name = "dataMan") val dataMan: Date?,
    @ColumnInfo (name = "estate") val estate: String?,
    @ColumnInfo (name = "free") val free: Boolean?
    )