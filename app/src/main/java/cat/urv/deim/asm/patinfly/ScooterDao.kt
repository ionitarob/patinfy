package cat.urv.deim.asm.patinfly

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ScooterDao {
    @Query("SELECT * FROM scooter")
    fun getAllScooters() : List<Scooter>
}