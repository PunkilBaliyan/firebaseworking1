package com.example.firebaseuse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Listadaptor(val list: List<listitem>) : RecyclerView.Adapter<Listadaptor.ListviewHolder>() {
    class ListviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val keyTextView : TextView = itemView.findViewById(R.id.keytext)
        val valueTextView : TextView = itemView.findViewById(R.id.valuetext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListviewHolder {
      val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent ,false)
        return ListviewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: ListviewHolder, position: Int) {
       holder.keyTextView.text = list[position].keyText
       holder.valueTextView.text = list[position].valueText
    }
}