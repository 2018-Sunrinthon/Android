package rankhep.com.dhlwn.utils


import android.graphics.Bitmap
import okhttp3.MultipartBody
import rankhep.com.ddaal.models.post.Post
import rankhep.com.ddaal.models.user.LoginData
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by choi on 2017. 7. 15..
 */

interface RetrofitInterface {
    @GET("/community/list/:page")
    fun getPostData(): Call<ArrayList<Post>>

    @Multipart
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
                @Part("post_profile_image_url") post_profile_image_url: MultipartBody.Part): Call<String>

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


    @POST("/auth/register")
    @FormUrlEncoded
    fun register(@Field("id") id: String,
                 @Field("password") password: String,
                 @Field("name") name: String,
                 @Field("age") age: String,
                 @Field("admin") admin: Boolean): Call<Map<String, String>>

    @POST("/auth/login")
    @FormUrlEncoded
    fun login(@Field("id") id: String,
              @Field("password") password: String): Call<LoginData>

    @POST("/auth/login/auto")
    @FormUrlEncoded
    fun autoLogin(@Field("token") token: String): Call<Map<String, String>>

    @POST("/ocr/upload")
    @Multipart
    fun getOcr(@Part name: MultipartBody.Part): Call<String>
}