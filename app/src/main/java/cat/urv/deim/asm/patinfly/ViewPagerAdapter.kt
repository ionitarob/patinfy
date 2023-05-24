package cat.urv.deim.asm.patinfly

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val fragments: ArrayList<Fragment>, activity: AppCompatActivity): FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}