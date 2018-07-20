package rankhep.com.ddaal.models.post

import java.io.Serializable

class PostPuffComment(var comment_user_token:String,
                      var comment_user_name:String,
                      var comment_time:String,
                      var comment_text:String,
                      var comment_puff_amount:String):Serializable {
}