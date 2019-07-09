package br.ufpe.cin.if710.p3.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "insights")
data class Insight(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0

    override fun toString(): String {
        return this.title + '\n' + this.description
    }
}