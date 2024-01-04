package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "punishment_table", primaryKeys = ["match_id_column","player_id_column","type_column","min_column"])
data class PunishmentEntity constructor(
    @ColumnInfo(name = "match_id_column")
    val Match_id: Int,
    @ColumnInfo(name = "player_id_column")
    val Player_id: Int,
    @ColumnInfo(name = "type_column")
    val Type: Boolean,
    @ColumnInfo(name = "min_column")
    val Min: String,
)