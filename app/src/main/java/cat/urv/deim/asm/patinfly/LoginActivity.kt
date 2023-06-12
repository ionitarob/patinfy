package cat.urv.deim.asm.patinfly

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cat.urv.deim.asm.patinfly.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginView {

    private val presenter = LoginPresenter(this, LoginInteractor())
    private val user = User ("Alejandro", "Lin", "alex","1234", 688030, "X123456A", "Spain", 5688)

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        hideProgress()
        binding.btnSignup.setOnClickListener{
            showProgress()
            postDelayed(1000){
                presenter.onSignUp()
            }

        }

        binding.btnLogin.setOnClickListener{
            showProgress()
            if (verifyData() && validateData()){
                postDelayed(2000){
                    presenter.onSuccess()
                }
            }
            if (!validateData()) {
                postDelayed(1000){
                    showToast(message = "Credentials are wrong")
                    hideProgress()
                }
            }
        }
    }

    private fun verifyData(): Boolean{
        val email = binding.etEmail.text.toString()
        val password= binding.etPassword.text.toString()

        return presenter.verifyData(email, password)
    }

    private fun validateData(): Boolean{
        val email = binding.etEmail.text.toString()
        val password= binding.etPassword.text.toString()

        return (user.email == email && user.password == password)
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

    override fun navigateToScooterList() {
        val intent = Intent(this, ScootersListActivity::class.java).apply {
            putExtra("userList", user)
        }
        startActivity(intent)
    }
    override fun navigateToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

}
