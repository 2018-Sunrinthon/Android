package rankhep.com.ddaal.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import rankhep.com.ddaal.fragment.MainFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return MainFragment()
    }

    override fun getCount(): Int = 2

}