package com.example.knowledgehub.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.knowledgehub.R
import com.example.knowledgehub.models.RecordingModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddNewRecordingForm : AppCompatActivity() {

    private lateinit var etRecordingId : EditText
    private lateinit var etRecordingName: EditText
    private lateinit var etSubjectName: EditText
    private lateinit var etGrade: EditText
    private lateinit var etLesson: EditText
    private lateinit var etDriveLink: EditText
    private lateinit var etDescription: EditText
    private lateinit var addRecording4: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_recording_form)

        etRecordingId= findViewById(R.id.etRecordingID)
        etRecordingName = findViewById(R.id.etRecordingName)
        etSubjectName = findViewById(R.id.etSubjectName)
        etGrade = findViewById(R.id.etGrade)
        etLesson = findViewById(R.id.etLesson)
        etDriveLink = findViewById(R.id.etDriveLink)
        etDescription = findViewById(R.id.etDescription)


        addRecording4 = findViewById(R.id.addRecording4)

        dbRef = FirebaseDatabase.getInstance().getReference("Recordings")

        addRecording4.setOnClickListener {
            saveRecordingData()
        }
    }

    private fun saveRecordingData() {

        //getting values
        val recordingID = etRecordingId.text.toString()
        val recordingName = etRecordingName.text.toString()
        val subjectName = etSubjectName.text.toString()
        val grade = etGrade.text.toString()
        val lesson = etLesson.text.toString()
        val driveLink = etDriveLink.text.toString()
        val description = etDescription.text.toString()

        if (recordingID.isEmpty()) {
            etRecordingId.error = "Please Enter First Name"
        }
        if (recordingName.isEmpty()) {
            etRecordingName.error = "Please Enter Last Name"
        }
        if (subjectName.isEmpty()) {
            etSubjectName.error = "Please Enter Student ID"
        }
        if (grade.isEmpty()) {
            etGrade.error = "Please Enter Email"
        }
        if (lesson.isEmpty()) {
            etLesson.error = "Please Enter Password"
        }
        if (driveLink.isEmpty()) {
            etDriveLink.error = "Please Enter Student ID"
        }
        if (description.isEmpty()) {
            etDescription.error = "Please Enter Student ID"
        }

        val recId = dbRef.push().key!!

        val recording = RecordingModel(recId, recordingID, recordingName, subjectName, grade, lesson, driveLink, description)

        dbRef.child(recId).setValue(recording)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                etRecordingId.text.clear()
                etRecordingName.text.clear()
                etSubjectName.text.clear()
                etGrade.text.clear()
                etLesson.text.clear()
                etDriveLink.text.clear()
                etDescription.text.clear()


            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }
}