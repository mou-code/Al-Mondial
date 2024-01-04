package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_table")
data class PlayerEntity constructor(
    @PrimaryKey
    val Player_id: Int,
    @ColumnInfo(name = "name_column")
    val Name: String,
    @ColumnInfo(name = "age_column")
    val Age: String,
    @ColumnInfo(name = "nationality_column")
    val Nationality: String,
    @ColumnInfo(name = "goalsscored_column")
    val GoalsScored: Int,
    @ColumnInfo(name = "red-cards_column")
    val RedCards: Int,
    @ColumnInfo(name = "yellowcards_column")
    val YellowCards: Int,
    @ColumnInfo(name = "position_column")
    val Position: String,

)