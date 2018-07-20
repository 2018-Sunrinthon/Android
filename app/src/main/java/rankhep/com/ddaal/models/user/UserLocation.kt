package rankhep.com.ddaal.models.user

import java.io.Serializable

class UserLocation(var user_latitude:Double,
                   var user_longitude:Double,
                   var user_hash_tag:ArrayList<Map<String,String>>):Serializable