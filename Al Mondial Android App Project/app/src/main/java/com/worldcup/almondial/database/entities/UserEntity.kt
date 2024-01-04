package com.worldcup.almondial.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity constructor(
    @PrimaryKey
    val Username: Int,
    @ColumnInfo(name = "password_column")
    val password: String,
    @ColumnInfo(name = "wallet_column")
    val Wallet: Int,
    @ColumnInfo(name = "favteam_id_column")
    val favTeam_id: String,
    @ColumnInfo(name = "name_column")
    val Name: String
)
//get all users and check if the user logged in and save his data in a companian object