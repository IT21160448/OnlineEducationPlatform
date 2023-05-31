package com.example.knowledgehub.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.knowledgehub.R
import com.example.knowledgehub.adapters.StudentAdapter
import com.example.knowledgehub.models.StudentModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AddNewStudent : AppCompatActivity() {

    private lateinit var addStudent2 : Button

    private lateinit var studentRecyclerView: RecyclerView
    private lateinit var tvLoadingData : TextView
    private lateinit var studentList : ArrayList<StudentModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_student)

        addStudent2 = findViewById(R.id.addStudent2)

        addStudent2.setOnClickListener{
            val intent = Intent(this, AddNewStudentForm::class.java)
            startActivity(intent)
        }

        studentRecyclerView = findViewById(R.id.rvStudent)
        studentRecyclerView.layoutManager = LinearLayoutManager(this)
        studentRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        studentList = arrayListOf<StudentModel>()

        getStudentData()
    }

    private fun getStudentData(){

        studentRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Students")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                studentList.clear()
                if(snapshot.exists()){
                    for(studentSnap in snapshot.children){
                        val studentData = studentSnap.getValue(StudentModel::class.java)
                        studentList.add(studentData!!)
                    }
                    val sAdapter = StudentAdapter(studentList)
                    studentRecyclerView.adapter = sAdapter

                    sAdapter.setOnItemClickListener(object : StudentAdapter.onItemClickListener{        //ClickListener
                        override fun onItemClick(position: Int) {

                            val intent = Intent(this@AddNewStudent, StudentDetails::class.java) //ClickListener

                            //Put Extra Data
                            intent.putExtra("stuId", studentList[position].stuId)
                            intent.putExtra("firstName", studentList[position].firstName)
                            intent.putExtra("lastName", studentList[position].lastName)
                            intent.putExtra("studentID", studentList[position].studentId)
                            intent.putExtra("email1", studentList[position].email1)

                            startActivity(intent)
                        }

                    })

                    studentRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility =View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}