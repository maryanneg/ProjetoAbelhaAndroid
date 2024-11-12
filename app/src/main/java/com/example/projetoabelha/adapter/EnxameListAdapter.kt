package com.example.projetoabelha.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoabelha.R
import com.example.projetoabelha.model.Enxamme

class EnxameListAdapter(val listaEnxames:ArrayList<Enxamme>) : RecyclerView.Adapter<EnxameListAdapter.EnxameViewHolder>(){
    class EnxameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView3)
        val textView1: TextView = itemView.findViewById(R.id.textEspecie)
        val textView2: TextView = itemView.findViewById(R.id.textOrigem)
        val textView3: TextView = itemView.findViewById(R.id.textDesc)
        val textView4: TextView = itemView.findViewById(R.id.textData)
        val textView5: TextView = itemView.findViewById(R.id.textId)
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
        holder.imageView.setImageResource(enxame.imageId)
        holder.textView1.setText(enxame.especie)
        holder.textView2.setText(enxame.origem)
        holder.textView3.setText(enxame.descricao)
        holder.textView4.setText(enxame.data)
        holder.textView5.setText(enxame.id)

    }
}