package rankhep.com.ddaal.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rankhep.com.ddaal.R

class JobSearchAdapter(var items: ArrayList<String>, var listener: OnItemClickListener) : RecyclerView.Adapter<JobSearchAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mTagListAdapter = TagListAdapter()

        holder?.run {
            tagList.run {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = mTagListAdapter
            }
            itemView.setOnClickListener { listener.onItemClickListener(it, position) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_job, parent, false))


    interface OnItemClickListener {
        fun onItemClickListener(v: View, position: Int)
    }

    lateinit var mTagListAdapter: TagListAdapter

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tagList = v.findViewById<RecyclerView>(R.id.tag_list)
    }

    override fun getItemCount(): Int = items.size
}