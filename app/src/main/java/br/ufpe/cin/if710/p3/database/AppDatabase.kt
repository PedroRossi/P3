package br.ufpe.cin.if710.p3.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.ufpe.cin.if710.p3.database.dao.InsightDao
import br.ufpe.cin.if710.p3.database.dao.MealDao
import br.ufpe.cin.if710.p3.database.models.Insight
import br.ufpe.cin.if710.p3.database.models.Meal

@Database(entities = [Meal::class, Insight::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
    abstract fun insightDao(): InsightDao
}