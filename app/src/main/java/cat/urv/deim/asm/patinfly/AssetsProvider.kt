package cat.urv.deim.asm.patinfly

import android.annotation.SuppressLint
import android.content.Context
import java.io.IOException

class AssetsProvider {
    companion object{
        @SuppressLint("DiscouragedApi")
        fun getJsonDataFromRawAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.getResources().openRawResource(
                    context.resources.getIdentifier("scooters.json",
                        "raw", context.packageName)).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}