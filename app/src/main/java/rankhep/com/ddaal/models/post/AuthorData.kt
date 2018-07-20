package rankhep.com.ddaal.models.post

import java.io.Serializable

class AuthorData(var author_name:String,
                 var author_id:String,
                 var author_token:String,
                 var author_admin:Boolean,
                 var author_call:String):Serializable
