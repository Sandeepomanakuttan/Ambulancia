package com.example.sandeep.ambulancia.view.registraction.Driver

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sandeep.ambulancia.R


class RegRecyclerview(private val requireContext: Context, private val it: ArrayList<ProfileImage>?,val listener : Image) : RecyclerView.Adapter<RegRecyclerview.VehicleViewHolder>() {

   inner class VehicleViewHolder(item: View) : RecyclerView.ViewHolder(item){

       val docName=item.findViewById(R.id.txt_docName) as TextView
       val txtStatus=item.findViewById(R.id.txtStatus) as TextView
       val imgNav = item.findViewById(R.id.imgNav) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.registraction_item,parent,false)

        return VehicleViewHolder(root)

    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val value=it!![position]
        holder.docName.text= value.fileldName
        holder.txtStatus.text = value.status

        holder.imgNav.setOnClickListener { _ ->

            if (value.status=="Get started"){
                when (value.fileldName) {
                    "Profile Image" -> {

                       listener.openGalary(value)

                    }
                    "Driving License" -> {


                    }
                    "Rc Book" -> {


                    }
                    "Insurance" -> {


                    }

                    "Road Tax" -> {


                    }
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return it!!.size
    }


    interface Image{

        fun openGalary(data : ProfileImage)
    }




}
