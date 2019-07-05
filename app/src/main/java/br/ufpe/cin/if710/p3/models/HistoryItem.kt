package br.ufpe.cin.if710.p3.models

data class HistoryItem(override val title: String, override val description: String, val id: Int) : Item {

    override fun toString(): String {
        return this.title + '\n' + this.description
    }
}