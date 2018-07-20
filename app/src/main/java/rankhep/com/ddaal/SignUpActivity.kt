package rankhep.com.ddaal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sign_up.*
import rankhep.com.dhlwn.utils.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        back_btn.setOnClickListener {
            finish()
        }

        success_btn.setOnClickListener {
            if (name_text.text.toString() != "" && age_text.text.toString() != "" && pwd_text.text.toString() != ""
                    && pwd_check_text.text.toString() != "" && id_text.text.toString() != "") {
                NetworkHelper.networkInstance.register(id_text.text.toString(), pwd_text.text.toString(), name_text.text.toString(), age_text.text.toString(), is_admin_switch.isChecked)
                        .enqueue(object : Callback<Map<String, String>> {
                            override fun onFailure(call: Call<Map<String, String>>?, t: Throwable?) {
                                Log.e("Error", t?.message)
                            }

                            override fun onResponse(call: Call<Map<String, String>>?, response: Response<Map<String, String>>?) {
                                finish()
                            }

                        })
            }
        }
    }
}
