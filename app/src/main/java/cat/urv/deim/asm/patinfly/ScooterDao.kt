package cat.urv.deim.asm.patinfly

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScooterDao {
    @Insert
    fun insertAll(vararg scooters: Scooter)

    @Query("SELECT * FROM Scooter")
    fun getAllScooters(): Scooters
}