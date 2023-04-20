package cat.urv.deim.asm.patinfly

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import cat.urv.deim.asm.patinfly.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity(), SignUpView, AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivitySignupBinding
    private val languages = arrayOf("English", "Spanish", "Catalan")
    private val presenter = SignUpPresenter(this, SignUpInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideProgress()

        binding.btnRegister.setOnClickListener {
            showProgress()
            if (verifyData()){
                presenter.onSuccess()
            }

        }

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        val languageSpinner = binding.nationalitySpinner

        with(languageSpinner)
        {

            adapter = arrayAdapter
            setSelection(0, false)
            onItemSelectedListener = this@SignUpActivity
            prompt = "Select your language"
            gravity = Gravity.END

        }

    }

    private fun verifyData(): Boolean{
        val firstName = binding.etFirstname.text.toString()
        val lastName = binding.etLastname.text.toString()
        val email = binding.etEmail.text.toString()
        val phone = binding.etPhoneNum.text.toString().toInt()
        val id = binding.etID.text.toString()
        val nationality = binding.nationalitySpinner.selectedItem
        val km = binding.etKm.text.toString().toInt()


        return presenter.verifyData(firstName, lastName, email, phone, id, nationality as Spinner, km)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected at the spinner")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showToast(message = "Spinner at Position:${position} and language: ${languages[position]}")
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

    override fun setFirstNameError() {
      binding.etFirstname.hint = "Error"
    }

    override fun setLastNameError() {
        binding.etFirstname.hint = "Error"
    }

    override fun setEmailError() {
        binding.etFirstname.hint = "Error"
    }

    override fun setPhoneError() {
        binding.etPhoneNum.hint = "Error"
    }

    override fun setIDError() {
        binding.etID.hint = "Error"
    }

    override fun setNationalityError() {
        showToast(message = "Error")
    }

    override fun setKm() {
        binding.etKm.hint = "Error"
    }

    override fun navigateToPassword() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
