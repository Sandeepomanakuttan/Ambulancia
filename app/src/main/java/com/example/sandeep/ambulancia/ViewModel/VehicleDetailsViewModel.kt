package com.example.sandeep.ambulancia.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sandeep.ambulancia.view.registraction.Driver.ProfileImage
import com.example.sandeep.ambulancia.model.registraction.DriversData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class VehicleDetailsViewModel : ViewModel() {

    private val database= Firebase.database
    private val driverRef=database.getReference("Drivers")
    val vehicleRef=database.getReference("Vehicle")
    private val profileRef=database.getReference("Request")
    private var key = MutableLiveData<String>()
    var vehicleStatusList = MutableLiveData<ArrayList<ProfileImage>>()
    var list =ArrayList<ProfileImage>()

    fun addDriver(data: DriversData) {

        key.value=driverRef.push().key
        driverRef.child(key.toString()).setValue(data).addOnSuccessListener {
            Log.d("Status....","success")
        }.addOnFailureListener {
            Log.d("Status....","failer")
        }
    }

    fun addDetail(fildName: String, image: String, status: String) {


        val pData= ProfileImage(key.toString(),fildName,image,status)

        profileRef.child(pData.fileldName.toString()).setValue(pData)
    }

    fun retriveData(status: String){

        profileRef.child(key.toString()).orderByChild("status").equalTo(status).addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for (singleSnap in snapshot.children){
                        val data = singleSnap.getValue(ProfileImage::class.java)
                        list.add(data!!)
                }
                vehicleStatusList.value=list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}