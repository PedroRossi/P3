package br.ufpe.cin.if710.p3.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.ufpe.cin.if710.p3.database.models.Insight

@Dao
interface InsightDao {
    @Query("SELECT * FROM insights")
    fun getAll(): LiveData<List<Insight>>

    @Insert
    fun insert(item: Insight)
}