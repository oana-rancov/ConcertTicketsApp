package com.example.concerttickets.register;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * FROM Users WHERE email=(:email) AND password=(:password)")
    UserEntity login(String email, String password);
}
