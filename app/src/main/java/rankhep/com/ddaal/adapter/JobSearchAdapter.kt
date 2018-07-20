package rankhep.com.ddaal.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import rankhep.com.ddaal.R
import rankhep.com.ddaal.models.post.Post
import rankhep.com.ddaal.models.post.PostHashTag

class JobSearchAdapter(var items: ArrayList<Post>, var listener: OnItemClickListener) : RecyclerView.Adapter<JobSearchAdapter.ViewHolder>() {
    lateinit var mTagListAdapter: TagListAdapter

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var tags = ArrayList<PostHashTag>()
        tags.addAll(items[position].post_data.post_hash_tag)
        mTagListAdapter = TagListAdapter(tags)
        holder?.run {
            tagList.run {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = mTagListAdapter
            }
            writer.text = items[position].author_data.author_name
            payment.text = items[position].alba_data.alba_pay
            description.text = items[position].post_data.post_content
            Picasso.get().load(items[position].post_data.post_profile_image_url).into(img)
            name.text = items[position].post_data.post_title
            itemView.setOnClickListener { listener.onItemClickListener(it, position, items[position]) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_job, parent, false))


    interface OnItemClickListener {
        fun onItemClickListener(v: View, position: Int, post: Post)
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tagList = v.findViewById<RecyclerView>(R.id.tag_list)
        var img = v.findViewById<ImageView>(R.id.image)
        var name = v.findViewById<TextView>(R.id.work_space_name)
        var description = v.findViewById<TextView>(R.id.work_space_description)
        var payment = v.findViewById<TextView>(R.id.payment_variable_text)
        var writer = v.findViewById<TextView>(R.id.writer_variable_text)
    }

    override fun getItemCount(): Int = items.size
}