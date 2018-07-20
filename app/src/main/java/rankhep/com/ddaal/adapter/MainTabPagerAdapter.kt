package rankhep.com.ddaal.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import rankhep.com.ddaal.fragment.JobSearchFragment
import rankhep.com.ddaal.fragment.LawyerFragment
import rankhep.com.ddaal.fragment.SettingFragment

class MainTabPagerAdapter(fm:FragmentManager): FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 ->{
                return JobSearchFragment()
            }
            1->{
                return LawyerFragment()
            }
            2->{
                return SettingFragment()
            }
        }
        return JobSearchFragment()
    }

    override fun getCount(): Int =3

}