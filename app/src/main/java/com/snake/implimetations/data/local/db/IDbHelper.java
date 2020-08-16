package com.snake.implimetations.data.local.db;

import com.snake.implimetations.data.model.db.CommentsTable;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface IDbHelper {

    Observable<Boolean> insertComment(CommentsTable commentsTable);

    Observable<List<CommentsTable>> getAllCommentsFromImage(String image);

    Observable<Boolean> delete(int id);

}
