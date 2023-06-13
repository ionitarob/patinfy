package cat.urv.deim.asm.patinfly
import android.content.Context
import cat.urv.deim.asm.patinfly.ReadJSONAssets.Companion.getJsonDataFromRawAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream

class ScooterParser {
    companion object{
        fun parseFromJson(context: Context,json: String): Scooter {
            val gson: Gson = Gson()
            return gson.fromJson(getJsonDataFromRawAsset(context), Scooter::class.java)
        }
    }
}