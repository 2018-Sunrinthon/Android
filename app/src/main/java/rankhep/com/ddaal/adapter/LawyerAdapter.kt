package rankhep.com.ddaal.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rankhep.com.ddaal.R

class LawyerAdapter(var items: ArrayList<String>) : RecyclerView.Adapter<LawyerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder = ViewHolder(LayoutInflater.from(p0?.context).inflate(R.layout.item_lawyer, p0, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder?, p1: Int){

    }

    class ViewHolder(v:View): RecyclerView.ViewHolder(v) {

    }
}