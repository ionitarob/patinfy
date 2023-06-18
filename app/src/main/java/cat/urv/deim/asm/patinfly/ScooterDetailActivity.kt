package cat.urv.deim.asm.patinfly

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("SetTextI18n")
class ScooterDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_scooter)
        getSetData()


    }

    private fun getSetData(){

        val name = intent.getStringExtra("name")
        val uuid = intent.getStringExtra("uuid")
        val battery = intent.getStringExtra("battery")
        val latitude = intent.getStringExtra("latitude")
        val longitude = intent.getStringExtra("longitude")
        val kmUse = intent.getStringExtra("km_use")
        val data = intent.getStringExtra("date")
        val onRent = intent.getStringExtra("onrent")
        val state = intent.getStringExtra("state")

        val textName = findViewById<TextView>(R.id.textViewName)
        val textUuid = findViewById<TextView>(R.id.textViewUuid)
        val textBatteryLevel = findViewById<TextView>(R.id.textViewBatteryLevel)
        val textLongitude = findViewById<TextView>(R.id.textViewLongitude)
        val textLatitude = findViewById<TextView>(R.id.textViewLatitude)
        val textKm = findViewById<TextView>(R.id.textViewKmUse)
        val textDate = findViewById<TextView>(R.id.textViewDateLastMaintenance)
        val textRent = findViewById<TextView>(R.id.textViewOnRent)
        val textState = findViewById<TextView>(R.id.textViewState)

        textName.text = "NAME: $name"
        textUuid.text = "UUID: $uuid"
        textBatteryLevel.text = "BATTERY: $battery"
        textLongitude.text = "LONGITUDE: $longitude"
        textLatitude.text = "LATITUDE: $latitude"
        textKm.text = "KM USE: $kmUse"
        textDate.text = "DATE OF LAST MAINTENANCE: $data"
        textRent.text = "ON RENT: $onRent"
        textState.text = "STATE: $state"
    }


}