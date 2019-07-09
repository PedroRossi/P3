package br.ufpe.cin.if710.p3.database.models

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "meals")
@RequiresApi(Build.VERSION_CODES.O)
data class Meal(
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "date") val date: LocalDateTime,
    @ColumnInfo(name = "photo") val photo: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0

    fun getDayAndMonth() : String {
        return "" + date.dayOfMonth + "/" + (date.monthValue)
    }

    fun getHourAndMinute() : String {
        return "" + date.hour + ":" + date.minute
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