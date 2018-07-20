package rankhep.com.ddaal.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_law.view.*
import rankhep.com.ddaal.R
import rankhep.com.ddaal.adapter.LawyerAdapter

class LawyerFragment : Fragment() {
    lateinit var mAdapter:LawyerAdapter
    var items : ArrayList<String> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_law, null)
        view.run{
            items.add("")
            items.add("")
            items.add("")
            items.add("")
            items.add("")
            mAdapter = LawyerAdapter(items)
            lawyer_list.layoutManager = LinearLayoutManager(context)
            lawyer_list.adapter = mAdapter

        }
        return view
    }
}