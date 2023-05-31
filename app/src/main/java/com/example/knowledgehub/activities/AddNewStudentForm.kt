package com.example.knowledgehub.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.knowledgehub.R
import com.example.knowledgehub.models.StudentModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddNewStudentForm : AppCompatActivity() {

    private lateinit var etFName: EditText
    private lateinit var etLName: EditText
    private lateinit var etStu1: EditText
    private lateinit var etMail1: EditText
    private lateinit var etStudentPass: EditText
    private lateinit var addStudent: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_student_form)

        etFName = findViewById(R.id.etFName)
        etLName = findViewById(R.id.etLName)
        etStu1 = findViewById(R.id.etStu1)
        etMail1 = findViewById(R.id.etMail1)
        etStudentPass = findViewById(R.id.etStudentPass)

        addStudent = findViewById(R.id.addStudent)

        dbRef = FirebaseDatabase.getInstance().getReference("Students")

        addStudent.setOnClickListener {
            saveStudentData()
        }
    }

    private fun saveStudentData() {

        //getting values
        val firstName = etFName.text.toString()
        val lastName = etLName.text.toString()
        val studentId = etStu1.text.toString()
        val email1 = etMail1.text.toString()
        val studentPassword = etStudentPass.text.toString()

        if (firstName.isEmpty()) {
            etFName.error = "Please Enter First Name"
        }
        if (lastName.isEmpty()) {
            etLName.error = "Please Enter Last Name"
        }
        if (studentId.isEmpty()) {
            etStu1.error = "Please Enter Student ID"
        }
        if (email1.isEmpty()) {
            etMail1.error = "Please Enter Email"
        }
        if (studentPassword.isEmpty()) {
            etStudentPass.error = "Please Enter Password"
        }

        val stuId = dbRef.push().key!!

        val student = StudentModel(stuId, firstName, lastName, studentId, email1, studentPassword)

        dbRef.child(stuId).setValue(student)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                etFName.text.clear()
                etLName.text.clear()
                etStu1.text.clear()
                etMail1.text.clear()
                etStudentPass.text.clear()


            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
}