package cat.urv.deim.asm.patinfly

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.databinding.ActivityPasswordBinding


class PasswordActivity : AppCompatActivity(), PasswordView {

    private val presenter = PasswordPresenter(this, PasswordInteractor())
    private lateinit var binding: ActivityPasswordBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideProgress()


        binding.btnSignUp.setOnClickListener{
            showProgress()
            if (verifyPassword() && passwordMatch()){
                savePassword()
                postDelayed(1000){
                    presenter.onSuccess()
                }
            }
            if (!passwordMatch()) {
                postDelayed(1000) {
                    showToast(message = "Passwords are different")
                    hideProgress()
                }
            }
        }
    }

    private fun savePassword(){

        val password = binding.etPassword.text.toString()

    }

    private fun passwordMatch(): Boolean{
        val password = binding.etPassword.text.toString()
        val passwordRepeat = binding.etPasswordRepeat.text.toString()

        return (password == passwordRepeat)
    }

    private fun verifyPassword(): Boolean{
        val password = binding.etPassword.text.toString()
        val passwordRepeat = binding.etPasswordRepeat.text.toString()
        return presenter.verifyPassword(password, passwordRepeat)
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

    override fun navigateToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

}