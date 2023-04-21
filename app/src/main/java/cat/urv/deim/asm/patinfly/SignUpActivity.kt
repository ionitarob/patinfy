package cat.urv.deim.asm.patinfly

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import cat.urv.deim.asm.patinfly.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity(), SignUpView, AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivitySignupBinding
    private val languages = arrayOf("English", "Spanish", "Catalan")
    private val presenter = SignUpPresenter(this, SignUpInteractor())
    private val userList = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideProgress()
        setKm()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        val languageSpinner = binding.nationalitySpinner
        with(languageSpinner)
        {
            adapter = arrayAdapter
            setSelection(0, true)
            onItemSelectedListener = this@SignUpActivity
            prompt = "Select your language"
            gravity = Gravity.END

        }

        binding.btnRegister.setOnClickListener {
            showProgress()
            if (verifyData()){
                addUser()
                presenter.onSuccess()
            }
        }

    }

    private fun verifyData(): Boolean{
        val firstName = binding.etFirstname.text.toString()
        val lastName = binding.etLastname.text.toString()
        val email = binding.etEmail.text.toString()
        val phone= binding.etPhoneNum.text.toString().toIntOrNull()
        val id = binding.etID.text.toString()
        val nationality = binding.nationalitySpinner.selectedItem.toString()

        return presenter.verifyData(firstName, lastName, email, phone, id, nationality)
    }

    private fun addUser(){
        val firstName = binding.etFirstname.text.toString()
        val lastName = binding.etLastname.text.toString()
        val email = binding.etEmail.text.toString()
        val phone= binding.etPhoneNum.text.toString().toIntOrNull()
        val id = binding.etID.text.toString()
        val nationality = binding.nationalitySpinner.selectedItem.toString()

        val newUser = User (firstName, lastName, email, password = null,  phone, id ,nationality,0)
        userList.addUser(newUser)

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected at the spinner")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showToast(message = "${languages[position]} selected")
    }

    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.INVISIBLE
    }
    override fun emptyTextError() {
        showToast(message = "There are empty fields")
    }
    private fun setKm(){
        binding.etKm.isEnabled = false
        binding.etKm.setText("0")
    }
    override fun navigateToPassword() {
        val newUser = userList.getLastUser()

        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("userList", newUser)
        startActivity(intent)

    }
}
