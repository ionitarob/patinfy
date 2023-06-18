package cat.urv.deim.asm.patinfly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import cat.urv.deim.asm.patinfly.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var navController: NavController
    private lateinit var sharedViewModel: SharedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        navController = NavHostFragment.findNavController(this)


        binding.buttonScooters.setOnClickListener{
            navController.navigate(R.id.scootersListFragment)
        }

        binding.buttonProfile.setOnClickListener{
            sharedViewModel.setData("Dato del botón 1")
            navController.navigate(R.id.profileFragment)
        }



        return view
    }


}