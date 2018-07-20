package rankhep.com.ddaal.models.post

import java.io.Serializable

class PostData(var post_title: String,
               var post_content: String,
               var post_hash_tag: ArrayList<Map<String, String>>,
               var post_profile_image_url:String,
               var post_puff_comment:PostPuffComment):Serializable {
}