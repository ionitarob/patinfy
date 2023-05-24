package cat.urv.deim.asm.patinfly
import com.google.gson.Gson
import java.io.File

class ScooterParser {
    companion object{
        fun parseFromJson( json: String):Scooters{
            val gson = Gson()
            val jsonString = File("scooters.json").readText()
            val scooters: Scooters = gson.fromJson(jsonString, Scooters::class.java)

        }
    }
}