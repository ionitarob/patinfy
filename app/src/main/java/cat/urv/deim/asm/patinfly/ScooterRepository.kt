package cat.urv.deim.asm.patinfly

import android.content.Context

class ScooterRepository {
    companion object {
        fun activeScooterList(context: Context, fileName: String): List<Scooter> {
            val scooters: Scooters = ScooterRepository.activeScooters(context, fileName)
            return scooters.scooters
        }

        fun activeScooters(context: Context, fileName: String): Scooters {
            val scooters: Scooters
            val jsonResource: String? = ReadJSONAssets.getJsonDataFromAsset(context,fileName)
            jsonResource.let {
                scooters = ScooterParser.parseFromJson(jsonResource!!)
            }
            return scooters
        }

        fun activeScooters(): Scooters {
            val scooters: Scooters = Scooters()
            val uuidList: Array<String> = AppConfig.DEFAULT_SCOOTERS_ID_ARRAY
            var scooter: Scooter
            uuidList.forEach {
                scooter = Scooter(uuid = it, longitude = it, latitude = it, battery = it,
                                  meters_rec = it, dataInc = it, dataMan = it, estate = it, free = it)
                scooters.scooters.add(scooter)
            }
            return scooters
        }
    }
}