package rankhep.com.ddaal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rankhep.com.ddaal.adapter.MainPagerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var mAdapter: MainPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = MainPagerAdapter(supportFragmentManager)
        pager.adapter = mAdapter
    }
}
