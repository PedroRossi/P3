package br.ufpe.cin.if710.p3.utils

import android.content.Context
import androidx.room.Room
import br.ufpe.cin.if710.p3.database.AppDatabase

class DB {

    var appDatabase : AppDatabase? = null

    companion object {
        @Volatile private var INSTANCE: DB? = null
        fun getInstance(context: Context): DB {
            return INSTANCE?: synchronized(this){
                var ret = DB()
                ret.appDatabase = Room.databaseBuilder(context,AppDatabase::class.java, "healthier_life")
                    .build()
                ret.also {
                    INSTANCE = it
                }
            }
        }
    }
}