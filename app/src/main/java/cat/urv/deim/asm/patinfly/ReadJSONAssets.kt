package cat.urv.deim.asm.patinfly
import android.content.Context
import java.io.IOException

class ReadJSONAssets(Context: Any?, s: String) {
    companion object{
        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.getResources().openRawResource(
                    context.resources.getIdentifier(fileName,
                        "raw", context.packageName)).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}