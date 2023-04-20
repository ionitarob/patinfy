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

class SignUpActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivitySignupBinding
    private val languages = arrayOf("English", "Español", "Catalan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.INVISIBLE

        binding.btnRegister.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            startActivity(Intent(this, LoginActivity::class.java))

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

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected at the spinner")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showToast(message = "Spinner at Position:${position} and language: ${languages[position]}")
    }

    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }
}
