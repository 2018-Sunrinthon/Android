package rankhep.com.ddaal.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rankhep.com.ddaal.R

class TagListAdapter : RecyclerView.Adapter<TagListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(p0?.context).inflate(R.layout.item_tag, p0, false))

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(p0: ViewHolder?, p1: Int) {
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }
}