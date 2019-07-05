package br.ufpe.cin.if710.p3.models

data class InsightItem(override val title: String, override val description: String) : Item {

    override fun toString(): String {
        return this.title + '\n' + this.description
    }
}