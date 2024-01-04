package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class NewsEntity constructor(
    @PrimaryKey
    val URL: String,
    @ColumnInfo(name = "Title_column")
    val Title: String,
    @ColumnInfo(name = "description_column")
    val Description: String,
    @ColumnInfo(name = "FTFlag_column")
    val FTFlag: Boolean,
    @ColumnInfo(name = "favTeam_id_column")
    val favTeam_id: Int,
    @ColumnInfo(name = "MFlag_column")
    val MFlag: Boolean,
    @ColumnInfo(name = "Match_id_column")
    val Match_id: Int
)