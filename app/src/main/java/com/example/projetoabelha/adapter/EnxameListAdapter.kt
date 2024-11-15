package com.example.projetoabelha.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoabelha.R
import Enxamme

class EnxameListAdapter(
    private val context: Context,
    private var enxames: MutableList<Enxamme>
) : RecyclerView.Adapter<EnxameListAdapter.EnxameViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EnxameViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return EnxameViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnxameListAdapter.EnxameViewHolder, position: Int) {
        val enxame = enxames[position]
        holder.bind(enxame)
    }

    override fun getItemCount(): Int = enxames.size

    inner class EnxameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvEspecie: TextView = itemView.findViewById(R.id.tvEspecie)
        private val tvOrigem: TextView = itemView.findViewById(R.id.tvOrigem)
        private val tvDescricao: TextView = itemView.findViewById(R.id.tvDescricao)
        private val tvData: TextView = itemView.findViewById(R.id.tvData)

        fun bind(enxames: Enxamme) {
            tvEspecie.text = enxames.especie
            tvOrigem.text = enxames.origem
            tvData.text = enxames.date
            tvDescricao.text = enxames.descricao

        }
    }
}