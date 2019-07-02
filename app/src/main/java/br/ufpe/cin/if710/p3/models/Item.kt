package br.ufpe.cin.if710.p3.models

data class Item (val title: String, val description: String) {
    override fun toString(): String {
        return this.title + '\n' + this.description
    }
}