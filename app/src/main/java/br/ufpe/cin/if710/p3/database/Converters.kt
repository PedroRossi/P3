package br.ufpe.cin.if710.p3.database

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.Instant

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromDate(value: LocalDateTime): Long {
            return value.toEpochSecond(ZoneOffset.UTC)
        }

        @TypeConverter
        @JvmStatic
        fun toDate(value: Long): LocalDateTime {
            return LocalDateTime.ofEpochSecond(value, 0, ZoneOffset.UTC)
        }
    }
}