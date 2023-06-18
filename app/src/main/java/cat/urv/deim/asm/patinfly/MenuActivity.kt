package cat.urv.deim.asm.patinfly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment


class MenuActivity: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.setGraph(R.navigation.nav_graph)

        val email = intent.getStringExtra("email")

        val fragment = ProfileFragment()
        val args = Bundle()
        args.putString("email", email)
        fragment.arguments = args

        fragment.let {
            supportFragmentManager.beginTransaction()
                .commit()
        }
    }
}