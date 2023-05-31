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
import com.example.knowledgehub.adapters.RecordingAdapter
import com.example.knowledgehub.models.RecordingModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AddNewRecording : AppCompatActivity() {

    private lateinit var addRecording3 : Button

    private lateinit var recordingRecyclerView: RecyclerView
    private lateinit var tvLoadingData2 : TextView
    private lateinit var recordingList : ArrayList<RecordingModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_recording)

        addRecording3 = findViewById(R.id.addRecording3)

        addRecording3.setOnClickListener{
            val intent = Intent(this, AddNewRecordingForm::class.java)
            startActivity(intent)
        }

        recordingRecyclerView = findViewById(R.id.rvRecording)
        recordingRecyclerView.layoutManager = LinearLayoutManager(this)
        recordingRecyclerView.setHasFixedSize(true)
        tvLoadingData2 = findViewById(R.id.tvLoadingData2)

        recordingList = arrayListOf<RecordingModel>()

        getRecordingData()
    }

    private fun getRecordingData() {
        recordingRecyclerView.visibility = View.GONE
        tvLoadingData2.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Recordings")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                recordingList.clear()
                if(snapshot.exists()){
                    for(recordingSnap in snapshot.children){
                        val recordingData = recordingSnap.getValue(RecordingModel::class.java)
                        recordingList.add(recordingData!!)
                    }
                    val rAdapter = RecordingAdapter(recordingList)
                    recordingRecyclerView.adapter = rAdapter

                    rAdapter.setOnItemClickListener(object : RecordingAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@AddNewRecording, RecordingDetails::class.java)

                            //Put Extra Data
                            intent.putExtra("recId", recordingList[position].recId)
                            intent.putExtra("recordingId", recordingList[position].recordingID)
                            intent.putExtra("recordingName", recordingList[position].recordingName)
                            intent.putExtra("subjectName", recordingList[position].subjectName)
                            intent.putExtra("grade", recordingList[position].grade)
                            intent.putExtra("lesson", recordingList[position].lesson)
                            intent.putExtra("driveLink", recordingList[position].driveLink)
                            intent.putExtra("description", recordingList[position].description)

                            startActivity(intent)
                        }

                    })

                    recordingRecyclerView.visibility = View.VISIBLE
                    tvLoadingData2.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}