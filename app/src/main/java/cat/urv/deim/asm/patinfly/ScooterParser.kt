package cat.urv.deim.asm.patinfly
import cat.urv.deim.asm.patinfly.ReadJSONAssets
import com.google.gson.Gson

class ScooterParser {
    companion object{
        fun parseFromJson() :Scooters{
            val gson: Gson = Gson()
            return gson.fromJson(ReadJSONAssets(), Scooters::class.java)
        }
    }
}