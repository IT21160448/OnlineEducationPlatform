package com.example.knowledgehub.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.knowledgehub.R
import com.example.knowledgehub.models.RecordingModel
import com.example.knowledgehub.models.StudentModel
import com.google.firebase.database.FirebaseDatabase

class RecordingDetails : AppCompatActivity() {

    private lateinit var tvRecId : TextView
    private lateinit var tvRecordingId : TextView
    private lateinit var tvRecordingName : TextView
    private lateinit var tvSubjectName : TextView
    private lateinit var tvGrade : TextView
    private lateinit var tvLesson : TextView
    private lateinit var tvDriveLink : TextView
    private lateinit var tvDescription : TextView

    private lateinit var updateRecording : Button
    private lateinit var deleteRecording : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recording_details)

        initView()
        setValuesToViews()

        updateRecording.setOnClickListener{
            openUpdateDialog(
                intent.getStringExtra("recId").toString(),
                intent.getStringExtra("recordingId").toString()
            )
        }

        deleteRecording.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("recId").toString()
            )
        }
    }

    private fun deleteRecord(
        id: String
    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("Recordings").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "Recording data deleted", Toast.LENGTH_LONG).show()
            val intent = Intent(this, AddNewRecording::class.java)
            finish()
            startActivity(intent)
        }
        mTask.addOnFailureListener { error ->
            Toast.makeText(this, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun initView() {

        tvRecId = findViewById(R.id.tvRecId)
        tvRecordingId = findViewById(R.id.tvRecodingId)
        tvRecordingName = findViewById(R.id.tvRecordingName)
        tvSubjectName = findViewById(R.id.tvSubjectName)
        tvGrade = findViewById(R.id.tvGrade)
        tvLesson = findViewById(R.id.tvLesson)
        tvDriveLink = findViewById(R.id.tvDriveLink)
        tvDescription = findViewById(R.id.tvDescription)

        updateRecording = findViewById(R.id.updateRecording)
        deleteRecording = findViewById(R.id.deleteRecording)
    }

    private fun setValuesToViews(){

        tvRecId.text = intent.getStringExtra("recId")
        tvRecordingId.text = intent.getStringExtra("recordingId")
        tvRecordingName.text = intent.getStringExtra("recordingName")
        tvSubjectName.text = intent.getStringExtra("subjectName")
        tvGrade.text = intent.getStringExtra("grade")
        tvLesson.text = intent.getStringExtra("lesson")
        tvDriveLink.text = intent.getStringExtra("driveLink")
        tvDescription.text = intent.getStringExtra("description")

    }

    private fun openUpdateDialog(       //Update
        recId : String,
        recordingId : String
    ){
        val rDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val rDialogView = inflater.inflate(R.layout.activity_update_recording_details, null)

        rDialog.setView(rDialogView)

        val etRecordingId2 = rDialogView.findViewById<EditText>(R.id.etRecordingId2)
        val etRecordingName2 = rDialogView.findViewById<EditText>(R.id.etRecordingName2)
        val etSubjectName2 = rDialogView.findViewById<EditText>(R.id.etSubjectName2)
        val etGrade2 = rDialogView.findViewById<EditText>(R.id.etGrade2)
        val etLesson2 = rDialogView.findViewById<EditText>(R.id.etLesson2)
        val etDriveLink2 = rDialogView.findViewById<EditText>(R.id.etDriveLink2)
        val etDescription2 = rDialogView.findViewById<EditText>(R.id.etDescription2)

        val updateRecording4 = rDialogView.findViewById<Button>(R.id.updateRecording4)

        etRecordingId2.setText(intent.getStringExtra("RecordingId").toString())
        etRecordingName2.setText(intent.getStringExtra("recordingName").toString())
        etSubjectName2.setText(intent.getStringExtra("subjectName").toString())
        etGrade2.setText(intent.getStringExtra("grade").toString())
        etLesson2.setText(intent.getStringExtra("lesson").toString())
        etDriveLink2.setText(intent.getStringExtra("driveLink").toString())
        etDescription2.setText(intent.getStringExtra("description").toString())

        rDialog.setTitle("Updating $recordingId Record")

        val alertDialog = rDialog.create()
        alertDialog.show()

        updateRecording4.setOnClickListener{
            updateRecordingData(
                recId,
                etRecordingId2.text.toString(),
                etRecordingName2.text.toString(),
                etSubjectName2.text.toString(),
                etGrade2.text.toString(),
                etLesson2.text.toString(),
                etDriveLink2.text.toString(),

            )

            Toast.makeText(applicationContext, "Recording Data Updated", Toast.LENGTH_LONG).show()

            //We are setting up our updated data to textViews
            tvRecordingId.text = etRecordingId2.text.toString()
            tvRecordingName.text = etRecordingName2.text.toString()
            tvSubjectName.text = etSubjectName2.text.toString()
            tvGrade.text = etGrade2.text.toString()
            tvLesson.text = etLesson2.text.toString()
            tvDriveLink.text = etDriveLink2.text.toString()
            tvDescription.text = etDescription2.text.toString()

            alertDialog.dismiss()
        }
    }

    private fun updateRecordingData(
        id: String,
        nameId: String,
        nameR: String,
        grades: String,
        lessons: String,
        link: String,
        descriptions: String,


    ) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Recordings").child(id)
        val studentInfo = RecordingModel(id, nameId, nameR, grades, lessons, link, descriptions)
        dbRef.setValue(studentInfo)
    }
}