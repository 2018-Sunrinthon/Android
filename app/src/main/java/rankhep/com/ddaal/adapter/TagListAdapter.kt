package rankhep.com.ddaal.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import rankhep.com.ddaal.R
import rankhep.com.ddaal.models.post.PostHashTag

class TagListAdapter(var items: ArrayList<PostHashTag>) : RecyclerView.Adapter<TagListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_tag, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tag.text = items[position].hash_tag
    }


    override fun getItemCount(): Int = items.size


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tag = v.findViewById<TextView>(R.id.tag)
    }
}