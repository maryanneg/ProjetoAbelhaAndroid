package com.example.projetoabelha.data

import com.example.projetoabelha.model.Enxamme

class EnxameMock {
    var listaEnxames = ArrayList<Enxamme>()
    init {
        for (i in 0..1){
            listaEnxames.add(Enxamme("Urucu","Venda","Nordestina","12/12/2012",1))
        }
    }
}