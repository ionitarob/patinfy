package cat.urv.deim.asm.patinfly

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import cat.urv.deim.asm.patinfly.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(), LoginView {

    private val presenter = LoginPresenter(this, LoginInteractor())
    private val userRep = UserRepository()

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        lifecycleScope.launch {
            val db = DB.getInstance(applicationContext)
            val userDao = db.userDao()
            Log.d("users", userRep.getAllUsers(userDao).toString())
        }
        setContentView(binding.root)
        hideProgress()
        binding.btnSignup.setOnClickListener{
            showProgress()
            postDelayed(1000){
                presenter.onSignUp()
            }
        }

        binding.btnLogin.setOnClickListener {
            showProgress()
            if (verifyData()) {
                val email = binding.etEmail.text.toString()
                val password = binding.etPassword.text.toString()
                lifecycleScope.launch {
                    val db = DB.getInstance(applicationContext)
                    val userDao = db.userDao()
                    val exists = userRep.userExists(userDao, email, password)

                    if (exists) {
                        postDelayed(2000) {
                            showToast(message = "Login Successful")
                            presenter.onSuccess()
                        }
                    }
                    else {
                        postDelayed(1000) {
                            showToast(message = "Credentials are wrong")
                            hideProgress()
                        }
                    }
                }
            } else {
                postDelayed(1000) {
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

    override fun navigateToMenu() {
        val intent = Intent(this, MenuActivity::class.java).apply {
            putExtra("userEmail", binding.etEmail.text.toString())
        }
        startActivity(intent)
    }
    override fun navigateToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

}
