package cat.urv.deim.asm.patinfly

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import cat.urv.deim.asm.patinfly.databinding.ActivityViewpagerBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewpagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewpagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager : ViewPager2  = findViewById(R.id.viewPager)
        val fragments: ArrayList<Fragment> = arrayListOf(TutorialPage1(),TutorialPage2(),TutorialPage3())

        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

        binding.skipbutton.setOnClickListener{
            navigateToLogin()
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    binding.skipbutton.text = getString(R.string.button_text_finish)
                }
                else binding.skipbutton.text = getString(R.string.button_text_skip)
            }
        })
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
