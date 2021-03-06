package com.example.applicationworkapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationworkapi.model.Person
import com.example.applicationworkapi.model.Phone

class PersonAdapter(
    private val context:Context,
    private val personList:List<Person>
    ):RecyclerView.Adapter<PersonViewHolder>() {

    lateinit var recyclerPhones:RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder  =   PersonViewHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.person_card_item,parent,false))

    override fun getItemCount(): Int = personList.size


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person: Person = personList[position]
        holder.firstName.text = person.firstName
        holder.lastname.text = person.lastName

        val adapter = PhoneAdapter(context, person.phones)
        recyclerPhones = holder.phones
        recyclerPhones.layoutManager = LinearLayoutManager(context)
        recyclerPhones.adapter =  adapter
      }
}

class PersonViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    val firstName : TextView  = itemView.findViewById(R.id.person_first_name)
    val lastname:TextView =  itemView .findViewById(R.id.person_last_name)
    val phones:RecyclerView = itemView.findViewById(R.id.recycler_view_person_phones)
}