package com.example.knowledgehub.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.knowledgehub.R
import com.example.knowledgehub.models.StudentModel
import com.google.firebase.database.FirebaseDatabase

class StudentDetails : AppCompatActivity() {

    private lateinit var tvStuId: TextView          //ClickListener
    private lateinit var tvFirstName: TextView
    private lateinit var tvLastName: TextView
    private lateinit var tvStudentId: TextView
    private lateinit var tvEmail: TextView

    private lateinit var updateStudent: Button
    private lateinit var deleteStudent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        initView()      //ClickListener
        setValuesToViews()

        updateStudent.setOnClickListener{
            openUpdateDialog(
                intent.getStringExtra("stuId").toString(),
                intent.getStringExtra("firstName").toString()
            )
        }

        deleteStudent.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("stuId").toString()
            )
        }

    }

    private fun deleteRecord(
        id: String
    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("Students").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "Student data deleted", Toast.LENGTH_LONG).show()
            val intent = Intent(this, AddNewStudent::class.java)
            finish()
            startActivity(intent)
        }
            mTask.addOnFailureListener { error ->
            Toast.makeText(this, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun initView(){

        tvStuId = findViewById(R.id.tvStuId)
        tvFirstName = findViewById(R.id.tvFirstName)
        tvLastName = findViewById(R.id.tvLastName)
        tvStudentId = findViewById(R.id.tvStudentId)
        tvEmail = findViewById(R.id.tvEmail)

        updateStudent = findViewById(R.id.updateStudent)
        deleteStudent = findViewById(R.id.deleteStudent)
    }

    private fun setValuesToViews() {

        tvStuId.text = intent.getStringExtra("stuId")
        tvFirstName.text = intent.getStringExtra("firstName")
        tvLastName.text = intent.getStringExtra("lastName")
        tvStudentId.text = intent.getStringExtra("studentID")
        tvEmail.text = intent.getStringExtra("email1")
    }


    private fun openUpdateDialog(       //Update
        stuId : String,
        firstName : String

    ){
        val sDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val sDialogView = inflater.inflate(R.layout.activity_update_student_details, null)

        sDialog.setView(sDialogView)

        val etFName2 = sDialogView.findViewById<EditText>(R.id.etFName2)
        val etLName2 = sDialogView.findViewById<EditText>(R.id.etLName2)
        val etStudent2 = sDialogView.findViewById<EditText>(R.id.etStudent2)
        val etEmail2 = sDialogView.findViewById<EditText>(R.id.etEmail2)

        val updateStudent2 = sDialogView.findViewById<Button>(R.id.updateStudent2)

        etFName2.setText(intent.getStringExtra("firstName").toString())
        etLName2.setText(intent.getStringExtra("lastName").toString())
        etStudent2.setText(intent.getStringExtra("studentID").toString())
        etEmail2.setText(intent.getStringExtra("email1").toString())

        sDialog.setTitle("Updating $firstName Record")

        val alertDialog = sDialog.create()
        alertDialog.show()

        updateStudent2.setOnClickListener{
            updateStudentData(
                stuId,
                etFName2.text.toString(),
                etLName2.text.toString(),
                etStudent2.text.toString(),
                etEmail2.text.toString()
            )
            Toast.makeText(applicationContext, "Student Data Updated", Toast.LENGTH_LONG).show()

            //We are setting updated data to our TextViews
            tvFirstName.text = etFName2.text.toString()
            tvLastName.text = etLName2.text.toString()
            tvEmail.text = etEmail2.text.toString()

            alertDialog.dismiss()
        }


    }

    private fun updateStudentData(
        id: String,
        nameF: String,
        nameL: String,
        student: String,
        mail: String

    ) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Students").child(id)
        val studentInfo = StudentModel(id, nameF, nameL,student, mail)
        dbRef.setValue(studentInfo)
    }
}