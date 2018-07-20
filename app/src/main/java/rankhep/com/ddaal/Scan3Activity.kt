package rankhep.com.ddaal

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_scan3.*

class Scan3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan3)

        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
        }

        fab.setOnClickListener {
            startActivity(Intent(this@Scan3Activity, Scan4Activity::class.java))
        }


        insuranceText1.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG //취소선 만들기
        insuranceText2.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        insuranceText3.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        insuranceText4.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

//        insuranceText1.paintFlags = 0//취소선 지우기
//        insuranceText2.paintFlags = 0
//        insuranceText3.paintFlags = 0
//        insuranceText4.paintFlags = 0
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}