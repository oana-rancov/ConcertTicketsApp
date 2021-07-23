package com.example.concerttickets.register;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String MY_DATABASE = "user";
    private static UserDatabase userDatabase;

    public abstract UserDao userDao();

    public static UserDatabase getUserDatabase(Context context){
        if(userDatabase == null){
            userDatabase = Room.databaseBuilder(context,
                    UserDatabase.class,
                    MY_DATABASE)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDatabase;
    }



}
