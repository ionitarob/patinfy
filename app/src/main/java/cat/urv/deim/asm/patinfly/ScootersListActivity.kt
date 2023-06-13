package cat.urv.deim.asm.patinfly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.databinding.ActivityScootersListBinding

class ScootersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScootersListBinding
    val name = ArrayList<String>()
    val battery = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScootersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text: ArrayList<String> = arrayListOf(name, battery)

        val view: RecyclerView = findViewById(R.id.scooterView)
        val adapter = ScooterRecyclerViewAdapter(text)
        view.adapter = adapter
        JSON.loadJSONFromAssets(applicationContext)
        JSON.parseFromJson(applicationContext)
    }
}