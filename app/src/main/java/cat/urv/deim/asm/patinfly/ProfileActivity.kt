package cat.urv.deim.asm.patinfly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val newUser = intent.getSerializableExtra("newUser")

        Log.d("newUser", newUser.toString())




    }
}