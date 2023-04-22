package cat.urv.deim.asm.patinfly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cat.urv.deim.asm.patinfly.databinding.ActivityProfileBinding


@Suppress("DEPRECATION")
class ProfileActivity : AppCompatActivity(), ProfileView {

    private lateinit var binding: ActivityProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideProgress()
        loadSetData()
        binding.btnEditProfile.setOnClickListener{
            loadSetData()
            showProgress()
            postDelayed(1000){
                binding.Profile.visibility = View.GONE
                hideProgress()
                binding.ProfileEditable.visibility = View.VISIBLE
            }
        }
        binding.btnUpdateProfile.setOnClickListener{
            postDelayed(1000){
                binding.Profile.visibility = View.VISIBLE
                binding.ProfileEditable.visibility = View.GONE
                loadSetDataEdit()
                loadSetData()
            }
        }
    }

    private fun loadSetData(){
        val user = intent.getSerializableExtra("userList") as? User

        val name = binding.etFirstname
        val last = binding.etLastname
        val iD = binding.etID
        val phoneNum = binding.etPhoneNum
        val kil = binding.etKm
        val mail = binding.etEmail
        val nation = binding.etNationality

        val nameEdit = binding.etFirstnameEditable
        val lastEdit = binding.etLastnameEditable
        val iDEdit = binding.etIDEditable
        val phoneNumEdit = binding.etPhoneNumEditable
        val kilEdit = binding.etKmEditable
        val mailEdit = binding.etEmailEditable
        val nationEdit = binding.etNationalityEditable

        val firstName = user?.firstName
        val lastName = user?.lastName
        val email = user?.email
        val phone = user?.phone
        val id = user?.id
        val nationality = user?.nationality
        val km = user?.km

        name.setText(firstName)
        last.setText(lastName)
        iD.setText(id)
        phoneNum.setText(phone.toString())
        mail.setText(email)
        nation.setText(nationality)
        kil.setText(km.toString())

        nameEdit.setText(firstName)
        lastEdit.setText(lastName)
        iDEdit.setText(id)
        phoneNumEdit.setText(phone.toString())
        mailEdit.setText(email)
        nationEdit.setText(nationality)
        kilEdit.setText(km.toString())

        name.isEnabled = false
        last.isEnabled = false
        iD.isEnabled = false
        phoneNum.isEnabled = false
        kil.isEnabled = false
        mail.isEnabled = false
        nation.isEnabled = false
    }

    private fun loadSetDataEdit(){
        val user = intent.getSerializableExtra("userList") as? User
        val name = binding.etFirstnameEditable.text.toString()
        val last = binding.etLastnameEditable.text.toString()
        val iD = binding.etIDEditable.text.toString()
        val phoneNum = binding.etPhoneNumEditable.text.toString().toIntOrNull()
        val kil = binding.etKmEditable.text.toString().toIntOrNull()
        val mail = binding.etEmailEditable.text.toString()
        val nation = binding.etNationalityEditable.text.toString()


        user?.firstName = name
        user?.lastName = last
        user?.email = mail
        user?.phone = phoneNum
        user?.id = iD
        user?.nationality = nation
        user?.km = kil

    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun navigateToEditProfile() {
        binding.progressBar.visibility = View.INVISIBLE
    }

}