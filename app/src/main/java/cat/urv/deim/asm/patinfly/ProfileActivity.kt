package cat.urv.deim.asm.patinfly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cat.urv.deim.asm.patinfly.databinding.ActivityProfileBinding


class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadSetData()


    }
    private fun loadSetData(){

        val name = binding.etFirstname
        val last = binding.etLastname
        val iD = binding.etID
        val phoneNum = binding.etPhoneNum
        val kil = binding.etKm
        val mail = binding.etEmail
        val nation = binding.etNationality

        val user = intent.getSerializableExtra("userList") as? User
        val firstName = user?.firstName
        Log.d("name", firstName.toString())
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

        name.isEnabled = false
        last.isEnabled = false
        iD.isEnabled = false
        phoneNum.isEnabled = false
        kil.isEnabled = false
        mail.isEnabled = false
        nation.isEnabled = false
    }
}