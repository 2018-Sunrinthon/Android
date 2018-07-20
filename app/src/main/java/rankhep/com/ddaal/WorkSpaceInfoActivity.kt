package rankhep.com.ddaal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_work_space_info.*
import rankhep.com.ddaal.adapter.CommentListAdapter
import rankhep.com.ddaal.adapter.TagListAdapter
import rankhep.com.ddaal.models.post.Post
import rankhep.com.ddaal.models.post.PostPuffComment

class WorkSpaceInfoActivity : AppCompatActivity() {
    var post: Post? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_space_info)

        post = intent.getSerializableExtra("post") as Post

        if (post != null) {
            Picasso.get().load("" + post?.post_data?.post_profile_image_url).into(img)
            work_space_name.text = post?.post_data?.post_title
            work_space_description.text = post?.post_data?.post_content
            tag_list.adapter = TagListAdapter(post?.post_data?.post_hash_tag!!)
            writer_and_number.text = post?.author_data?.author_call
            payment.text = post?.alba_data?.alba_pay
            location.text = post?.alba_data?.alba_location?.location
            var comment = ArrayList<PostPuffComment>()
            comment.add(post?.post_data?.post_puff_comment!!)
            comment_list.adapter = CommentListAdapter(comment)
        }

    }
}
