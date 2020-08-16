package com.snake.implimetations.data.local.db;


import android.content.Context;
import android.util.Log;

import com.snake.implimetations.data.local.db.dao.CommentsTableDao;
import com.snake.implimetations.data.model.db.CommentsTable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;


@Singleton
public class AppDbHelper implements IDbHelper {

    private final AppDatabase mAppDatabase;

    private Context context;

    public final static char[] passphrase = {'a', 'b', 'c', 'd', 'e', 'f'};

    private String TAG = AppDbHelper.class.getSimpleName();

    private CommentsTableDao commentsTableDao;

    @Inject
    public AppDbHelper(AppDatabase appDatabase, Context context) {
        this.mAppDatabase = appDatabase;
        this.context = context;
        //encryptDB();
    }

    @Override
    public Observable insertComment(CommentsTable commentsTable) {
        return Observable.fromCallable(() -> {
            Log.d(TAG, "insertComment: "+commentsTable.comment);
            mAppDatabase.commentsTableDao().insert(commentsTable);
            return true;
        });
    }

    @Override
    public Observable getAllCommentsFromImage(String image) {
        return Observable.fromCallable(() -> mAppDatabase.commentsTableDao().findCommentByImage(image));
    }

    @Override
    public Observable<Boolean> delete( int id) {
        return Observable.fromCallable(() -> {
            mAppDatabase.commentsTableDao().deleteComment( id);
            return true;
        });
    }


}
