package cat.urv.deim.asm.patinfly

import android.content.Context

class ScooterRepository {
    companion object {
        fun activeScooterList(context: Context, resource: String): List<Scooter> {
            val scooters: Scooters = activeScooters(context, resource)
            return scooters.scooters
        }

        fun activeScooters(context: Context, resource: String): Scooters {
            val scooters: Scooters
            val jsonResource: String? = AssetsProvider.getJsonDataFromRawAsset(context, resource)
            jsonResource.let {
                scooters = ScooterParser.parseFromJson(jsonResource!!)
            }
            return scooters
        }

        fun activeScooters(): Scooters {
            val scooters = Scooters()
            val uuidList = arrayOf<String>()
            var scooter: Scooter
            uuidList.forEach {
                scooter = Scooter(uuid = it, name = it, longitude = it, latitude = it, battery_level = it.toDouble(), km_use = it.toDouble(),
                    date_last_maintenance = it, state = it, on_rent = it.toBoolean())
                scooters.scooters.add(scooter)
            }

            return scooters
        }

    }
}