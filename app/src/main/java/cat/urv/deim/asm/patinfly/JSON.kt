package cat.urv.deim.asm.patinfly

import android.content.Context
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

class JSON {
    companion object{
    fun loadJSONFromAssets(context: Context): String? {
        val json: String?
        try {
            val  inputStream: InputStream = context.assets.open("scooters.json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun parseFromJson(context: Context){
        val name = ArrayList<String>()
        val battery = ArrayList<String>()
        var i=0
        val obj = JSONObject(loadJSONFromAssets(context))
        val array = obj.getJSONArray("scooters")
        while (array.length() < i){
            val scooterDetail = array.getJSONObject(i)
            i++;
            name.add(scooterDetail.getString("name"))
            battery.add(scooterDetail.getString("battery"))
        }
    }
    }
}