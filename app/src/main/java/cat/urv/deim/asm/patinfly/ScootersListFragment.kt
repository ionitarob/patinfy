package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.patinfly.databinding.FragmentScootersListBinding

class ScootersListFragment : Fragment() {

    private lateinit var binding: FragmentScootersListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentScootersListBinding.inflate(inflater, container, false)
        val view = binding.root

        val scooters: Scooters = ScooterRepository.activeScooters(requireContext(), "scooters")

        binding.scooterView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.scooterView.layoutManager = layoutManager

        val adapter = ScooterRecyclerViewAdapter(scooters)
        binding.scooterView.adapter = adapter

        adapter.itemClick = {
            startActivity(Intent(context, ScooterDetailActivity::class.java))
        }
        return view
    }

}