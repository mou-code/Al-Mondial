package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "group_table", primaryKeys = ["group_id_column"])
data class GroupEntity constructor(
    @ColumnInfo(name = "group_id_column")
    val Group_id: Int,
    @ColumnInfo(name = "team_id_column")
    val Team_id: Int,
    @ColumnInfo(name = "points_column")
    val Points: Int,
    @ColumnInfo(name = "games_column")
    val Games: Int,
    @ColumnInfo(name = "goalsfor_column")
    val GoalsFor: Int,
    @ColumnInfo(name = "goalsagainst_column")
    val GoalsAgainst: Int,
    @ColumnInfo(name = "goalsdiff_column")
    val GoalsDiff: Int,
    @ColumnInfo(name = "wins_column")
    val Wins: Int,
    @ColumnInfo(name = "lossess_column")
    val Losses: Int,
    @ColumnInfo(name = "draws_column")
    val Draws: Int

)