package rankhep.com.dhlwn.utils


import android.graphics.Bitmap
import rankhep.com.ddaal.models.post.Post
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by choi on 2017. 7. 15..
 */

interface RetrofitInterface {
    @GET("/community/list/:page")
    fun getPostData(): Call<ArrayList<Post>>

    @POST("/community/post/add")
    @FormUrlEncoded
    fun addPost(@Field("post_title") post_title: String,
                @Field("post_content") post_content: String,
                @Field("post_hash_tag") post_hash_tag: ArrayList<String>,
                @Field("author_token") author_token: String,
                @Field("alba_latitude") alba_latitude: Double,
                @Field("alba_longitude") alba_longitude: Double,
                @Field("alba_time") alba_time: Double,
                @Field("alba_pay") alba_pay: Int,
                @Field("call") call: String,
                @Field("post_profile_image_url") post_profile_image_url: Bitmap): Call<String>

    @POST("/community/check/admin")
    @FormUrlEncoded
    fun getIsAdmin(@Field("token") token: String): Call<Boolean>

    @POST("/community/add/comment")
    @FormUrlEncoded
    fun addComment(@Field("post_token") post_token: String,
                   @Field("comment_user_token") comment_user_token: String,
                   @Field("comment_user_name") comment_user_name: String,
                   @Field("comment_text") comment_text: String,
                   @Field("comment_puff_amount") comment_puff_amount: String)
}