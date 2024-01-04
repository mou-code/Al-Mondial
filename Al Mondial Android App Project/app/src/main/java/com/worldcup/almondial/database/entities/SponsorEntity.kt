package com.worldcup.almondial.database.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sponsor_table")
data class SponsorEntity constructor(
    @PrimaryKey
    val Sponsor_Name: String
)