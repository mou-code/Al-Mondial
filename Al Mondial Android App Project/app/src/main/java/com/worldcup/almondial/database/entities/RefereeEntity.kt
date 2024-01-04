package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "referee_table")
data class RefereeEntity constructor(
    @PrimaryKey
    val Referee_id: Int,
    @ColumnInfo(name = "name_column")
    val Name: String
)