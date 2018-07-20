package rankhep.com.ddaal.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import rankhep.com.ddaal.R
import rankhep.com.ddaal.models.post.PostPuffComment

class CommentListAdapter(var items: ArrayList<PostPuffComment>) : RecyclerView.Adapter<CommentListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            comment.text = items[position].comment_text
            name.text = items[position].comment_user_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_comment, null))

    override fun getItemCount(): Int = items.size

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var name = v.findViewById<TextView>(R.id.name)
        var comment = v.findViewById<TextView>(R.id.comment)
        var img = v.findViewById<CircleImageView>(R.id.profile)
    }
}