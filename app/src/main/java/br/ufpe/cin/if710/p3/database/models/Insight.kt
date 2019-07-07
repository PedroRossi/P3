package br.ufpe.cin.if710.p3.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "insights")
data class Insight(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") override val title: String,
    @ColumnInfo(name = "description") override val description: String
) : Item {
    override fun toString(): String {
        return this.title + '\n' + this.description
    }
}