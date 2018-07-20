package rankhep.com.ddaal.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import rankhep.com.ddaal.R
import rankhep.com.ddaal.adapter.MainTabPagerAdapter
import rankhep.com.ddaal.utils.BlurTransformation

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = LayoutInflater.from(context).inflate(R.layout.fragment_main, null)
        v.main_pager.adapter = MainTabPagerAdapter(fragmentManager!!)
        return v
    }
}