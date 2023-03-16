package com.example.firebaseuse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        val list: MutableList<listitem> = mutableListOf()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView2)
        recyclerView.adapter = Listadaptor(list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val firebaseDatabase = FirebaseDatabase.getInstance("https://fir-working-9c2ee-default-rtdb.asia-southeast1.firebasedatabase.app")
        firebaseDatabase.reference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
            list.clear()
                for(child in snapshot.children){
                    list.add(listitem(child.key.toString(),child.value.toString()))
                }
                (recyclerView.adapter as Listadaptor).notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
               println(error.message.toString())
            }

        }
        )

    }
}