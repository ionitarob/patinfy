package cat.urv.deim.asm.patinfly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import cat.urv.deim.asm.patinfly.databinding.FragmentProfileBinding
import kotlinx.coroutines.launch


class ProfileFragment : Fragment(){

    private lateinit var binding: FragmentProfileBinding
    private val userRep = UserRepository()
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var userEmail: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val data = sharedViewModel.getData().value
        userEmail = data.toString()

        hideProgress()
        hideProgress2()
        loadSetData()

        binding.btnEditProfile.setOnClickListener{
            showProgress()
            postDelayed(1000){
                binding.Profile.visibility = View.GONE
                binding.ProfileEditable.visibility = View.VISIBLE
                hideProgress()
            }
        }
        binding.btnUpdateProfile.setOnClickListener{
            showProgress2()
            postDelayed(1000){
                binding.ProfileEditable.visibility = View.GONE
                binding.Profile.visibility = View.VISIBLE
                hideProgress2()
                loadSetDataEdit()

            }

        }
        return binding.root
    }

    private fun loadSetData(){
        lifecycleScope.launch {
            val db = DB.getInstance(requireContext())
            val userDao = db.userDao()
            val user = userRep.getUserByEmail(userDao,userEmail)

            val name = binding.etFirstname
            val last = binding.etLastname
            val iD = binding.etID
            val phoneNum = binding.etPhoneNum
            val password = binding.etPassword
            val kil = binding.etKm
            val mail = binding.etEmail
            val nation = binding.etNationality

            val nameEdit = binding.etFirstnameEditable
            val lastEdit = binding.etLastnameEditable
            val iDEdit = binding.etIDEditable
            val passwordEdit = binding.etPasswordEditable
            val phoneNumEdit = binding.etPhoneNumEditable
            val kilEdit = binding.etKmEditable
            val mailEdit = binding.etEmailEditable
            val nationEdit = binding.etNationalityEditable

            val firstName = user.firstName
            val lastName = user.lastName
            val email = user.email
            val pass = user.password
            val phone = user.phone
            val id = user.id
            val nationality = user.nationality
            val km = user.km

            name.setText(firstName)
            last.setText(lastName)
            iD.setText(id)
            phoneNum.setText(phone.toString())
            password.setText(pass)
            mail.setText(email)
            nation.setText(nationality)
            kil.setText(km.toString())

            nameEdit.setText(firstName)
            lastEdit.setText(lastName)
            iDEdit.setText(id)
            passwordEdit.setText(pass)
            phoneNumEdit.setText(phone.toString())
            mailEdit.setText(email)
            nationEdit.setText(nationality)
            kilEdit.setText(km.toString())

            name.isEnabled = false
            last.isEnabled = false
            iD.isEnabled = false
            password.isEnabled = false
            phoneNum.isEnabled = false
            kil.isEnabled = false
            mail.isEnabled = false
            mailEdit.isEnabled = false
            nation.isEnabled = false
        }
    }

    private fun loadSetDataEdit(){
        lifecycleScope.launch {
            val db = DB.getInstance(requireContext())
            val userDao = db.userDao()
            val user = userRep.getUserByEmail(userDao, userEmail)
            user.apply {
                firstName = binding.etFirstnameEditable.text.toString()
                lastName = binding.etLastnameEditable.text.toString()
                id = binding.etIDEditable.text.toString()
                password = binding.etPasswordEditable.text.toString()
                phone = binding.etPhoneNumEditable.text.toString().toIntOrNull()
                km = binding.etKmEditable.text.toString().toIntOrNull()
                email = binding.etEmailEditable.text.toString()
                nationality = binding.etNationalityEditable.text.toString()
            }
            userRep.updateUser(userDao,user.firstName, user.lastName, user.id, user.email, user.password.toString(), user.phone, user.nationality.toString(), user.km, userEmail)
            loadSetData()
        }

    }

    private fun showProgress2() {
        binding.progressBar2.visibility = View.VISIBLE
    }

    private fun hideProgress2() {
        binding.progressBar2.visibility = View.INVISIBLE
    }

    private fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        binding.progressBar.visibility = View.INVISIBLE
    }
}