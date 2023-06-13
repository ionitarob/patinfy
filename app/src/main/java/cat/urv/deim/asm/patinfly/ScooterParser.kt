package cat.urv.deim.asm.patinfly
import cat.urv.deim.asm.patinfly.ReadJSONAssets
import com.google.gson.Gson
import android.content.Context
import android.content.ContextWrapper
import com.google.gson.reflect.TypeToken

class ScooterParser {
    companion object{
        fun parseFromJson() :Scooters{

            val jsonString = ReadJSONAssets.getJsonDataFromAsset(applicationContext, "scooters.json")
            val gson: Gson = Gson()
            val listScooter = object : String<List<Scooter>>() {}.type
            return gson.fromJson(ReadJSONAssets(jsonString, listScooter))
        }
    }
}