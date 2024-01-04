package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "match_table")
data class MatchEntity constructor(
    @PrimaryKey
    val match_id: Int,
    @ColumnInfo(name = "date_column")
    val date: String,
    @ColumnInfo(name = "time_column")
    val time: String,
    @ColumnInfo(name = "team1name_column")
    val team1name: String,
    @ColumnInfo(name = "team2name_column")
    val team2name: String,
    @ColumnInfo(name = "score_column")
    val score: String,
    @ColumnInfo(name = "referee_column")
    val referee: String,
    @ColumnInfo(name = "stadium_column")
    val stadium: String,
    @ColumnInfo(name = "team1sponsor_column")
    val team1sponsor: String,
    @ColumnInfo(name = "team2sponsor_column")
    val team2sponsor: String,
    @ColumnInfo(name = "team1coach_column")
    val team1coach: String,
    @ColumnInfo(name = "team2coach_column")
    val team2coach: String,
    @ColumnInfo(name = "stage_column")
    val stage: String
)