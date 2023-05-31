package com.example.knowledgehub.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.knowledgehub.R
import com.example.knowledgehub.models.RecordingModel

class RecordingAdapter (private val recordingList: ArrayList<RecordingModel>) : RecyclerView.Adapter<RecordingAdapter.ViewHolder>() {

    private lateinit var rListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
        rListener = clickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView1 = LayoutInflater.from(parent.context).inflate(R.layout.list_item_recording, parent, false)
        return ViewHolder(itemView1, rListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRecording = recordingList[position]
        holder.tvRecordingName.text = currentRecording.recordingID
    }

    override fun getItemCount(): Int {
        return recordingList.size
    }

    class ViewHolder(itemView1: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView1) {

        val tvRecordingName: TextView = itemView1.findViewById(R.id.tvRecordingName)

        init{
            itemView1.setOnClickListener{
                clickListener.onItemClick(adapterPosition)
            }
        }
    }
}