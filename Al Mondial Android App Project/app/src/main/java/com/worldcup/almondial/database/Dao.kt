package com.worldcup.almondial.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.worldcup.almondial.database.entities.MatchEntity
import retrofit2.http.GET

@Dao
interface Dao {

    //get all matches
    //insert all matches
    //get recent matches
    //get fav team matches




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMatches(matches: List<MatchEntity>)

    @Query("SELECT * FROM match_table ORDER BY match_id DESC")
    fun getMatches(): List<MatchEntity>


//    @Query("SELECT * FROM coach_table ")
//    fun insertMatches(): Flow<List<AsteroidDatabaseEntity>>
//
//    @Query("SELECT * FROM asteroid_database_table WHERE closeApproachDate_column >= :startdate ORDER BY closeApproachDate_column DESC")
//    fun getWeekAsteroids(startdate: String): LiveData<List<AsteroidDatabaseEntity>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAll(matches: List<MatchEntity>)
//
//    @Query(" DELETE FROM asteroid_database_table WHERE closeApproachDate_column < :currentDayFormatted ")
//    fun DeleteOldAsteroids(currentDayFormatted: String)
//
//    @Query("SELECT * FROM asteroid_database_table WHERE closeApproachDate_column == :currentDayFormatted")
//    fun getTodaysAsteroids(currentDayFormatted: String): LiveData<List<AsteroidDatabaseEntity>>

}
