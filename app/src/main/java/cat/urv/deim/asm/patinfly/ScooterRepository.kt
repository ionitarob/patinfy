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
            val scootersList: MutableList<Scooter> = mutableListOf(
                Scooter(uuid = "uuid1", name = null, longitude = null, latitude = null, battery = null, meters_rec = null, dataInc = null, dataMan = null, estate = null, free = null),
            )
            var scooter: Scooter
            scootersList.forEach {
                scooters.scooters.add(scootersList)
            }
            return scooters
        }
    }
}