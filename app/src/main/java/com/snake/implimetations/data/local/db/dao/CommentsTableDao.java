package com.snake.implimetations.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.snake.implimetations.data.model.db.CommentsTable;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface CommentsTableDao {
    @Query("SELECT * FROM CommentsTable WHERE Image LIKE :image ")
    List<CommentsTable> findCommentByImage(String image);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CommentsTable commentsTable);

    @Query("DELETE FROM CommentsTable WHERE id LIKE :id")
    void deleteComment(int id);

//    @Delete
//    public void deleteComments(String value);

}
