package com.example.projetoabelha.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.projetoabelha.database.models.Users

@Dao
interface UserDao {
    @Insert
    suspend fun insert(users: Users)
    @Query("SELECT COUNT(uid) FROM users")
    suspend fun getTotalItems():Long

}