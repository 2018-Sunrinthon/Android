package rankhep.com.ddaal.models.post

import java.io.Serializable

class Post(var post_token:String,
          var author_data:AuthorData,
           var post_data:PostData,
           var alba_data:AlbaData):Serializable