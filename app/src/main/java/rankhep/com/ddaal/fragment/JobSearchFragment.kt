package rankhep.com.ddaal.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_job_search.view.*
import rankhep.com.ddaal.R
import rankhep.com.ddaal.WorkSpaceInfoActivity
import rankhep.com.ddaal.adapter.JobSearchAdapter
import rankhep.com.ddaal.models.post.Post
import rankhep.com.dhlwn.utils.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class JobSearchFragment : Fragment(), JobSearchAdapter.OnItemClickListener {
    val LIST_HEIGHT = 132
    lateinit var mAdapter: JobSearchAdapter
    var items: ArrayList<Post> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_job_search, null)
        items.clear()
        NetworkHelper.networkInstance.getPostData().enqueue(object : Callback<ArrayList<Post>> {
            override fun onFailure(call: Call<ArrayList<Post>>?, t: Throwable?) {
                Log.e("Error", t?.message)
            }

            override fun onResponse(call: Call<ArrayList<Post>>?, response: Response<ArrayList<Post>>?) {
                if (response?.code() != null && response.code() == 200) {
                    if (response?.body() != null && response.body()?.size!! > 0)
                        items.addAll(response.body()!!)
                }
            }

        })
        mAdapter = JobSearchAdapter(items, this)
        view.run {
            job_list.run {
                layoutManager = LinearLayoutManager(context)
                val viewHeight = LIST_HEIGHT * items.size
                layoutParams.height = viewHeight
                mAdapter = JobSearchAdapter(items, this@JobSearchFragment)
                adapter = mAdapter
                isNestedScrollingEnabled = false

            }
        }
        return view
    }

    override fun onItemClickListener(v: View, position: Int, post: Post?) {
        var intent: Intent = Intent(context, WorkSpaceInfoActivity::class.java)
        intent.putExtra("post", post)
        startActivity(intent)
    }

}