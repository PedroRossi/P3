package br.ufpe.cin.if710.p3.database

import androidx.room.TypeConverter
import java.util.*

class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromDate(value: Calendar): Long {
            return value.time.time
        }

        @TypeConverter
        @JvmStatic
        fun toDate(value: Long): Calendar {
            val cal = Calendar.getInstance()
            cal.time.time = value
            return cal
        }
    }
}