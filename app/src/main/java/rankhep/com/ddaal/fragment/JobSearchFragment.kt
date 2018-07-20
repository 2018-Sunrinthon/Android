package rankhep.com.ddaal.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_job_search.view.*
import rankhep.com.ddaal.R
import rankhep.com.ddaal.adapter.JobSearchAdapter

class JobSearchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_job_search, null)
        view.run{
            job_list.layoutManager = LinearLayoutManager(context)
            job_list.adapter = JobSearchAdapter()
        }
        return view
    }
}