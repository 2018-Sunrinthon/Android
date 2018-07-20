package rankhep.com.ddaal.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rankhep.com.ddaal.R

class JobSearchAdapter : RecyclerView.Adapter<JobSearchAdapter.ViewHolder>() {

    lateinit var mTagListAdapter: TagListAdapter
    override fun onBindViewHolder(holder: ViewHolder?, p1: Int) {
        mTagListAdapter = TagListAdapter()

        holder?.run {
            tagList.run {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = mTagListAdapter
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(p0?.context).inflate(R.layout.item_job, p0, false))

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tagList = v.findViewById<RecyclerView>(R.id.tag_list)
    }

    override fun getItemCount(): Int = 3
}