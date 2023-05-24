package cat.tomasgis.examples.recyclerviewexample.repositories

import android.content.Context
import cat.tomasgis.examples.recyclerviewexample.base.AppConfig
import cat.tomasgis.examples.recyclerviewexample.model.Scooter
import cat.urv.deim.asm.patinfly.ScooterParser
import cat.tomasgis.examples.recyclerviewexample.model.Scooters

class ScooterRepository {
    companion object {

        fun activeScooterList(context: Context, resource: String): List<Scooter> {
            val scooters: Scooters = ScooterRepository.activeScooters(context, resource)
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

        fun activeScooters(context: Context): Scooters {
            val resource: String = AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE
            return ScooterRepository.activeScooters(context, resource)
        }

        fun activeScooters(): Scooters {
            val scooters: Scooters = Scooters()
            val uuidList: Array<String> =AppConfig.DEFAULT_SCOOTERS_ID_ARRAY
            var scooter: Scooter
            uuidList.forEach {
                scooter = Scooter(uuid = it, name = it)
                scooters.scooters.add(scooter)
            }

            return scooters
        }
    }
}