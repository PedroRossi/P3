package br.ufpe.cin.if710.p3.database.models

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.util.*

@Entity(tableName = "meals")
data class Meal(
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "date") val date: Calendar,
    @ColumnInfo(name = "photo") val photo: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0

    fun getDayAndMonth() : String {
        return "" + date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1)
    }

    fun getHourAndMinute() : String {
        return "" + date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE)
    }

    fun getTitle() : String {
        return "Day " + getDayAndMonth() + " at " + getHourAndMinute()
    }

    fun getPhotoURI() : Uri {
        return Uri.parse(photo)
    }

    override fun toString(): String {
        return getTitle() + '\n' + this.description
    }
}