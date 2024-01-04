package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticket_table")
data class TicketEntity constructor(
    @PrimaryKey
    val Ticket_id: Int,
    @ColumnInfo(name = "cost_column")
    val cost: String,
    @ColumnInfo(name = "match_id_column")
    val Match_id: Int,
    @ColumnInfo(name = "user_id_column")
    val User_id: String
)