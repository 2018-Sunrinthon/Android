package rankhep.com.ddaal.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import rankhep.com.ddaal.R
import rankhep.com.ddaal.Scan4Activity
import rankhep.com.ddaal.adapter.MainTabPagerAdapter

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = LayoutInflater.from(context).inflate(R.layout.fragment_main, null)
        v.main_pager.adapter = MainTabPagerAdapter(fragmentManager!!)
        v.main_pager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tabChange(v, position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
        v.job_search_tab.setOnClickListener {
            tabChange(v, 0)
        }
        v.law_tab.setOnClickListener {
            tabChange(v, 1)
        }
        v.setting_tab.setOnClickListener {
            tabChange(v, 2)
        }
        v.fab.setOnClickListener{
            var intent = Intent(context, Scan4Activity::class.java)
            startActivity(intent)
        }
        return v
    }


    private fun tabChange(v: View, position: Int) {
        v.job_search_img.run {
            setColorFilter(context?.getColor(if (position == 0) R.color.colorPrimary else R.color.unSelectedColor)!!)
        }
        v.job_search_text.setTextColor(context?.getColor(if (position == 0) R.color.colorPrimary else R.color.unSelectedColor)!!)
        v.law_text.setTextColor(context?.getColor(if (position == 1) R.color.colorPrimary else R.color.unSelectedColor)!!)
        v.setting_text.setTextColor(context?.getColor(if (position == 2) R.color.colorPrimary else R.color.unSelectedColor)!!)
        v.law_img.run {
            setColorFilter(context?.getColor(if (position == 1) R.color.colorPrimary else R.color.unSelectedColor)!!)
        }
        v.setting_img.run {
            setColorFilter(context?.getColor(if (position == 2) R.color.colorPrimary else R.color.unSelectedColor)!!)
        }
        v.main_pager.currentItem = position
    }
}
