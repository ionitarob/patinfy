package cat.urv.deim.asm.patinfly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import cat.urv.deim.asm.patinfly.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        navController = NavHostFragment.findNavController(this)

        binding.buttonScooters.setOnClickListener{
            navController.navigate(R.id.scootersListFragment)
        }

        binding.buttonProfile.setOnClickListener{
            navController.navigate(R.id.profileFragment)
        }

        return view
    }
}