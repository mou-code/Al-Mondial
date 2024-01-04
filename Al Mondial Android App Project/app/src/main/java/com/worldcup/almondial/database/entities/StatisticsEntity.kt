package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "statistics_table", primaryKeys = ["stat_name_column"])
data class StatisticsEntity constructor(
    @ColumnInfo(name = "stat_name_column")
    val stat_name: String,
    @ColumnInfo(name = "element1name_column")
    val element1name: String,
    @ColumnInfo(name = "element2name_column")
    val element2name: String,
    @ColumnInfo(name = "element3name_column")
    val element3name: String,
    @ColumnInfo(name = "element1number_column")
    val element1number: Int,
    @ColumnInfo(name = "element2number_column")
    val element2number: Int,
    @ColumnInfo(name = "element3number_column")
    val element3number: Int
)