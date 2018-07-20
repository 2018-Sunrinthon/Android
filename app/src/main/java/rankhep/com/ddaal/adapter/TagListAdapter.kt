package rankhep.com.ddaal.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rankhep.com.ddaal.R

class TagListAdapter : RecyclerView.Adapter<TagListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_tag, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }


    override fun getItemCount(): Int = 3


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }
}