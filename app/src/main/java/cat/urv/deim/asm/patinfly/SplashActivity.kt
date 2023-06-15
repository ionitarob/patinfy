package cat.urv.deim.asm.patinfly

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import cat.urv.deim.asm.patinfly.databinding.ActivitySplashBinding


/*Integrants: Alejandro Lin Xu
              Robert-Alejandro Ionita
        Grup: ASM26*/

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(), SplashView {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var db: UserDB
    private val presenter = SplashPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(applicationContext, UserDB::class.java, "userDB")
            .build()
        presenter.onSuccess()
    }

    override fun navigateToTutorial() {
        startActivity(Intent(this, TutorialActivity::class.java))
    }


}