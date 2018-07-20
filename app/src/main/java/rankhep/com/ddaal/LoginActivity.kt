package rankhep.com.ddaal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import rankhep.com.dhlwn.utils.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sign_up_btn.setOnClickListener {
            var intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

        login_btn.setOnClickListener {

            var intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
            NetworkHelper.networkInstance.login(id.text.toString(), pwd.text.toString())
                    .enqueue(object : Callback<Map<String, String>> {
                        override fun onFailure(call: Call<Map<String, String>>?, t: Throwable?) {
                            Log.e("Error", t?.message)
                        }

                        override fun onResponse(call: Call<Map<String, String>>?, response: Response<Map<String, String>>?) {
//                            var intent = Intent(this@LoginActivity, MainActivity::class.java)
//                            startActivity(intent)
//                            finish()
                        }

                    })
        }
    }
}
