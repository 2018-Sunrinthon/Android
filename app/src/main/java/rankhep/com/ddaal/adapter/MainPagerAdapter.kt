package rankhep.com.ddaal.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.eka.applicatio.CameraFragment
import rankhep.com.ddaal.fragment.MainFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return CameraFragment()
            }
        }
        return MainFragment()
    }

    override fun getCount(): Int = 2

}