package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stadium_table")
data class StadiumEntity constructor(
    @PrimaryKey
    val Stadium_Name: String,
    @ColumnInfo(name = "capacity_column")
    val Capacity: Int,
    @ColumnInfo(name = "location_column")
    val Location: String
)