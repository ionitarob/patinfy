package cat.urv.deim.asm.patinfly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cat.urv.deim.asm.patinfly.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.INVISIBLE

        binding.btnRegister.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            startActivity(Intent(this, MainActivity::class.java))

        }
    }

}