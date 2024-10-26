package com.example.projetoabelha

class Enchames(var especie:String,var origem:String,var descricao:String,var data:String,var imageId:Int) {

    override fun toString(): String {
        return "Enchames \n" +
                "Especie: $especie - Origem: $origem\nDescricao: $descricao\nData($data)"
    }
}