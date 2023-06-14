package cat.urv.deim.asm.patinfly
import com.google.gson.Gson

class ScooterParser {
    companion object{
        fun parseFromJson(json: String):Scooters{
            val gson = Gson()

            var scooters: Scooters
            json.let {
                scooters = gson.fromJson(json, Scooters::class.java)
            }
            return scooters
        }
    }
}