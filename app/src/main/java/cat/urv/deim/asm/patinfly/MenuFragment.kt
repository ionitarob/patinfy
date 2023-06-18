package cat.urv.deim.asm.patinfly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import cat.urv.deim.asm.patinfly.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var navController: NavController
    private lateinit var sharedViewModel: SharedViewModel
    private var email: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        navController = NavHostFragment.findNavController(this)


        binding.buttonScooters.setOnClickListener{
            navController.navigate(R.id.scootersListFragment)
        }

        binding.buttonProfile.setOnClickListener{
            sharedViewModel.setData(email)
            navController.navigate(R.id.profileFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = sharedViewModel.getData().value
        email = data.toString()
    }


}