package cat.urv.deim.asm.patinfly
import android.content.Context
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

class ReadJSONAssets(context: Context) {
    companion object {
        fun getJsonDataFromRawAsset(context: Context): String? {
            var json: String? = null
            try {
                val  inputStream: InputStream = context.assets.open("scooters.json")
                json = inputStream.bufferedReader().use{it.readText()}
            } catch (ex: Exception) {
                ex.printStackTrace()
                return null
            }
            return json
        }
    }
}