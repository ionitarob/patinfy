package cat.urv.deim.asm.patinfly

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.databinding.ActivityDetailScooterBinding

@SuppressLint("SetTextI18n")
class ScooterDetailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailScooterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailScooterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSetData()
    }

    private fun getSetData() {

        val name = intent.getStringExtra("name")
        val uuid = intent.getStringExtra("uuid")
        val battery = intent.getStringExtra("battery")
        val latitude = intent.getStringExtra("latitude")
        val longitude = intent.getStringExtra("longitude")
        val kmUse = intent.getStringExtra("km_use")
        val data = intent.getStringExtra("date")
        val onRent = intent.getStringExtra("onRent")
        val state = intent.getStringExtra("state")

        val textName = binding.textViewName
        val textUuid = binding.textViewUuid
        val textBatteryLevel = binding.textViewBatteryLevel
        val textLongitude = binding.textViewLongitude
        val textLatitude = binding.textViewLatitude
        val textKm = binding.textViewKmUse
        val textDate = binding.textViewDateLastMaintenance
        val textRent = binding.textViewOnRent
        val textState = binding.textViewState

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