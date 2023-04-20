package cat.urv.deim.asm.patinfly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cat.urv.deim.asm.patinfly.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginView {

    private val presenter = LoginPresenter(this, LoginInteractor())

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
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun setUserError() {
        binding.etEmail.setText("fefe")
    }

    override fun setPasswordError() {
        TODO("Not yet implemented")
    }

    override fun navigateToProfile() {
        TODO("Not yet implemented")
    }
    override fun navigateToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

}
