package rankhep.com.ddaal.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import rankhep.com.ddaal.fragment.JobSearchFragment

class MainTabPagerAdapter(fm:FragmentManager): FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment = JobSearchFragment()

    override fun getCount(): Int =1

}