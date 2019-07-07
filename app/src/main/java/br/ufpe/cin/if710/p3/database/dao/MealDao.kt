package br.ufpe.cin.if710.p3.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.ufpe.cin.if710.p3.database.models.Meal

@Dao
interface MealDao {
    @Query("SELECT * FROM meals")
    fun getAll(): LiveData<List<Meal>>

    @Insert
    fun insert(item: Meal)
}