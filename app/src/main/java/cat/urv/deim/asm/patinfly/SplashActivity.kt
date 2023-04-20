package cat.urv.deim.asm.patinfly

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cat.urv.deim.asm.patinfly.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(), SplashView {

    private lateinit var binding: ActivitySplashBinding
    private val presenter = SplashPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.onSuccess()
    }

    override fun navigateToTutorial() {
        startActivity(Intent(this, LoginActivity::class.java))
    }


}