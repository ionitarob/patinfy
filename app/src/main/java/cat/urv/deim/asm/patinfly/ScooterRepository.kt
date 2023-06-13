package cat.urv.deim.asm.patinfly

import android.content.Context

class ScooterRepository {
    companion object {
        fun activeScooterList(context: Context): List<Scooter> {
            val scooters: Scooters = ScooterRepository.activeScooters(context)
            return scooters.scooters
        }

        fun activeScooters(context: Context): Scooters {
            val scooters: Scooters
            val jsonResource: String? = ReadJSONAssets.getJsonDataFromAsset(context)
            jsonResource.let {
                scooters = ScooterParser.parseFromJson("name")
            }
            return scooters
        }

        fun activeScooters(): Scooters {
            val scooters: Scooters = Scooters()
            var scooter: Scooter = Scooter(uuid = "uuid1", name = null, longitude = null, latitude = null, battery = null, meters_rec = null, dataInc = null, dataMan = null, estate = null, free = null)
            val scootersList: MutableList<Scooter> = mutableListOf<scooter>
            scooter.forEach{
                scooters.scooters.add(scooter)
            }
            return scooters
        }
    }
}