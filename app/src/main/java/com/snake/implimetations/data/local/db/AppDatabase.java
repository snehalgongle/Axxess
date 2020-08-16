package com.snake.implimetations.data.local.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.snake.implimetations.data.local.db.dao.CommentsTableDao;
import com.snake.implimetations.data.model.db.CommentsTable;


@Database(entities = {CommentsTable.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract CommentsTableDao commentsTableDao();


}

