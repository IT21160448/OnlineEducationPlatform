package com.example.knowledgehub.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.knowledgehub.R
import com.example.knowledgehub.models.StudentModel

class StudentAdapter(private val studentList: ArrayList<StudentModel>) : RecyclerView.Adapter<StudentAdapter.ViewHolder>(){

    private lateinit var sListener: onItemClickListener  //ClickListener

    interface onItemClickListener {             //ClickListener
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener) {        //ClickListener
        sListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_students, parent, false)
        return ViewHolder(itemView, sListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStudent = studentList[position]
        holder.tvStudentName.text = currentStudent.studentId
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val tvStudentName: TextView = itemView.findViewById(R.id.tvStudentName)

        init {          //ClickListener
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
        }
    }

