package cat.urv.deim.asm.patinfly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.patinfly.databinding.ActivityScootersListBinding


class ScootersListFragment : AppCompatActivity() {

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
        val scooters:Scooters  = ScooterRepository.activeScooters(this,
            "scooters")

        // Increase performance when the size is static
        binding.scooterView.setHasFixedSize(true)


        // Our RecyclerView is using the linear layout manager
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.scooterView.layoutManager = layoutManager

        val adapter = ScooterRecyclerViewAdapter(scooters)
        binding.scooterView.adapter = adapter
    }
}