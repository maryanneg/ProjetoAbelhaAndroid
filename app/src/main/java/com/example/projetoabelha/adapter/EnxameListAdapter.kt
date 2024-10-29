package com.example.projetoabelha.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoabelha.R
import com.example.projetoabelha.model.Enxamme

class EnxameListAdapter(val listaEnxames:ArrayList<Enxamme>) : RecyclerView.Adapter<EnxameListAdapter.EnxameViewHolder>(){
    class EnxameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnxameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return EnxameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaEnxames.size
    }

    override fun onBindViewHolder(holder: EnxameViewHolder, position: Int) {
        val enxame = listaEnxames[position]
        holder.textView.setText(enxame.especie)
    }
}