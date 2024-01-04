package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coach_table", primaryKeys = ["name_column"])
data class CoachEntity constructor(
    @ColumnInfo(name = "name_column")
    val Name: String,
    @ColumnInfo(name = "nationality_column")
    val Nationality: String,
    @ColumnInfo(name = "Age_column")
    val Age: Int
)