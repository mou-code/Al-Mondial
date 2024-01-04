package com.worldcup.almondial.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.worldcup.almondial.database.entities.*

/**
 * The Room Database for the asteroid_database_table
 */
@Database(entities = [CoachEntity::class,
                     GoalEntity::class,
                     GroupEntity::class,
                     MatchEntity::class,
                     NewsEntity::class,
                     PlayerEntity::class,
                     PunishmentEntity::class,
                     RefereeEntity::class,
                     SponsorEntity::class,
                     StadiumEntity::class,
                     TeamEntity::class,
                     TicketEntity::class,
                     StatisticsEntity::class,
                     UserEntity::class], version = 1)
abstract class RoomDatabase : RoomDatabase() {
    abstract val dao: Dao
}

private lateinit var INSTANCE: RoomDatabase

fun getDatabase(context: Context): RoomDatabase {
    synchronized(RoomDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                RoomDatabase::class.java,
                "almondial"
            ).build()
        }
    }
    return INSTANCE
}

