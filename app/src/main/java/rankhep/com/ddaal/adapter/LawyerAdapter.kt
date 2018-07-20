package rankhep.com.ddaal.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rankhep.com.ddaal.R

class LawyerAdapter(var items: ArrayList<String>) : RecyclerView.Adapter<LawyerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_lawyer, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }
}