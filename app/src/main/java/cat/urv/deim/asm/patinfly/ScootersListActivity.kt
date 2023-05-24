

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.patinfly.ScooterListAdapter
import cat.urv.deim.asm.patinfly.ScooterRepository
import cat.urv.deim.asm.patinfly.Scooters
import cat.urv.deim.asm.patinfly.databinding.ActivityScootersListBinding


class ScootersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScootersListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MVC
        //setContentView(R.layout.activity_main)

        //Binding MVVM o MVP
        binding = ActivityScootersListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    override fun onResume() {
        super.onResume()

        //val scooters:Scooters  = ScooterRepository.activeScooters()

        //Scooters from json file. To access to the file raw/scooters.json:
        val scooters: Scooters = ScooterRepository.activeScooters(this,
            AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE)

        // Increase performance when the size is static
        binding.scooterlist.setHasFixedSize(true)


        // Our RecyclerView is using the linear layout manager
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.scooterlist.setLayoutManager(layoutManager)

        val adapter: ScooterListAdapter = ScooterListAdapter(scooters)
        binding.scooterlist.adapter = adapter
    }
}
