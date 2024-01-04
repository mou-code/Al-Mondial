package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team_table")
data class TeamEntity constructor(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "Name_column")
    val Name: String,
    @ColumnInfo(name = "Group_id_column")
    val Group_id: Int,
    @ColumnInfo(name = "Sponser_Name_column")
    val Sponser_Name: String,
    @ColumnInfo(name = "Coach_Name_column")
    val Coach_Name: String
)