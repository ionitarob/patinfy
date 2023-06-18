package cat.urv.deim.asm.patinfly

//noinspection SuspiciousImport
import android.R
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import cat.urv.deim.asm.patinfly.databinding.ActivitySignupBinding
import kotlinx.coroutines.launch


class SignUpActivity : AppCompatActivity(), SignUpView, AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivitySignupBinding
    private val languages = arrayOf("English", "Spanish", "Catalan")
    private val presenter = SignUpPresenter(this, SignUpInteractor())
    private val userRep = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideProgress()
        setKm()

        val arrayAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, languages)
        val languageSpinner = binding.nationalitySpinner
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        with(languageSpinner)
         {
            adapter = arrayAdapter
            onItemSelectedListener = this@SignUpActivity
            gravity = Gravity.END
        }

        binding.btnCreatePass.setOnClickListener {
            val firstName = binding.etFirstname.text.toString()
            val lastName = binding.etLastname.text.toString()
            val email = binding.etEmail.text.toString()
            val phone= binding.etPhoneNum.text.toString().toIntOrNull()
            val id = binding.etID.text.toString()
            val nationality = binding.nationalitySpinner.selectedItem.toString()


            if (verifyData()){
                lifecycleScope.launch {
                    val db = DB.getInstance(applicationContext)
                    val userDao = db.userDao()
                    val exists = userRep.userExist(userDao,email)
                    if (!exists){
                        showProgress()
                        val newUser = User (firstName, lastName, email, null,  phone, id ,nationality,0)
                        userRep.addUser(userDao, newUser)
                        postDelayed(1000) {
                            presenter.onSuccess()
                        }
                    }
                    else{
                        showProgress()
                        postDelayed(2000) {
                            showToast(message = "The user already exists")
                        }
                        hideProgress()

                    }
                }
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


    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected at the spinner")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val parentElement = parent!!.getChildAt(0)
        (parentElement as TextView).setTextColor(Color.parseColor("#FFFFFF"))
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
        val intent = Intent(this, PasswordActivity::class.java).apply {
            putExtra("email", binding.etEmail.text.toString())
        }
        startActivity(intent)

    }
}
