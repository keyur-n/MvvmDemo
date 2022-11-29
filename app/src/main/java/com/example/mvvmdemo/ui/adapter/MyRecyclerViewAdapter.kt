package com.example.mvvmdemo.ui.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.ui.adapter.MyRecyclerViewAdapter.DataObjectHolder
import android.widget.TextView
import com.example.mvvmdemo.ui.adapter.MyRecyclerViewAdapter
import com.example.mvvmdemo.R
import com.example.mvvmdemo.ui.adapter.MyRecyclerViewAdapter.MyClickListener
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.mvvmdemo.model.Entry
import java.util.ArrayList

class MyRecyclerViewAdapter(private val mDataset: ArrayList<Entry>) :
    RecyclerView.Adapter<DataObjectHolder>() {
    private var myClickListener: MyClickListener? = null

    inner class DataObjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var label: TextView
        var dateTime: TextView
        override fun onClick(v: View) {
            myClickListener!!.onItemClick(adapterPosition, v)
        }

        init {
            label = itemView.findViewById<View>(R.id.textView) as TextView
            dateTime = itemView.findViewById<View>(R.id.textView2) as TextView
            Log.i(LOG_TAG, "Adding Listener")
            itemView.setOnClickListener(this)
        }
    }

    fun setOnItemClickListener(myClickListener: MyClickListener) {
        this.myClickListener = myClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataObjectHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return DataObjectHolder(view)
    }

    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {
        holder.label.text = mDataset[position].category
        holder.dateTime.text = mDataset[position].description
    }

    fun addItem(dataObj: Entry, index: Int) {
        mDataset.add(dataObj)
        notifyItemInserted(index)
    }

    fun deleteItem(index: Int) {
        mDataset.removeAt(index)
        notifyItemRemoved(index)
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    interface MyClickListener {
        fun onItemClick(position: Int, v: View?)
    }

    companion object {
        private const val LOG_TAG = "MyRecyclerViewAdapter"

    }
}