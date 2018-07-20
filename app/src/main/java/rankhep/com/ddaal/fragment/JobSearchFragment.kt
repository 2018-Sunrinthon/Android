package rankhep.com.ddaal.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_job_search.view.*
import rankhep.com.ddaal.R
import rankhep.com.ddaal.WorkSpaceInfoActivity
import rankhep.com.ddaal.adapter.JobSearchAdapter
import java.util.*

class JobSearchFragment : Fragment(), JobSearchAdapter.OnItemClickListener {
    override fun onItemClickListener(v: View, position: Int) {
        var intent: Intent = Intent(context, WorkSpaceInfoActivity::class.java)
        startActivity(intent)
    }

    val LIST_HEIGHT = 132
    lateinit var mAdapter: JobSearchAdapter
    var items: ArrayList<String> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_job_search, null)
        items.run {
            add("xx")
            add("xx")
            add("xx")
            add("xx")
            add("xx")
            add("xx")
            add("xx")
            add("xx")
            add("xx")
        }
        view.run {
            job_list.run {
                layoutManager = LinearLayoutManager(context)
                val viewHeight = LIST_HEIGHT * items.size
                layoutParams.height = viewHeight
                mAdapter = JobSearchAdapter(items, this@JobSearchFragment)
                adapter = mAdapter
                isNestedScrollingEnabled = false

            }
        }
        return view
    }
}