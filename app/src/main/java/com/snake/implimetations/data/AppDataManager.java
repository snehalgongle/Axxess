package com.snake.implimetations.data;


import android.content.Context;

import com.google.gson.Gson;
import com.snake.implimetations.data.local.db.IDbHelper;
import com.snake.implimetations.data.local.preference.IPreferencesHelper;
import com.snake.implimetations.data.model.api.Base;
import com.snake.implimetations.data.model.api_request.DataRequest;
import com.snake.implimetations.data.model.db.CommentsTable;
import com.snake.implimetations.data.remote.ApiHeader;
import com.snake.implimetations.data.remote.ApiHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.internal.operators.observable.ObservableFromCallable;

@Singleton
public class AppDataManager implements DataManager {

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final IDbHelper mDbHelper;

    private final Gson mGson;

    private final IPreferencesHelper mPreferencesHelper;

    private String TAG = AppDataManager.class.getSimpleName();

    @Inject
    AppDataManager(Context context, IDbHelper dbHelper, IPreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }

    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }

    @Override
    public void setUserName(String userName) {
        mPreferencesHelper.setUserName(userName);
    }

//    @Override
//    public Single<List<User>> getUserApiCall(DataRequest request) {
//        return mApiHelper.getUserApiCall(request);
//    }
//
//    @Override
//    public Single<UserProfile> getUserProfilerApiCall(UserProfileRequest request) {
//        return mApiHelper.getUserProfilerApiCall(request);
//    }
//
//    @Override
//    public Single<List<User>> getUserFollowerApiCall(UserFollowerRequest request) {
//        return mApiHelper.getUserFollowerApiCall(request);
//    }

    @Override
    public Single<Base> getDataApiCall(DataRequest request) {
        return mApiHelper.getDataApiCall(request);
    }

    @Override
    public Observable insertComment(CommentsTable commentsTable) {
        return mDbHelper.insertComment(commentsTable);
    }

    @Override
    public Observable getAllCommentsFromImage(String image) {
        return mDbHelper.getAllCommentsFromImage(image);
    }

    @Override
    public Observable<Boolean> delete( int id) {
        return mDbHelper.delete(id);
    }

    @Override
    public ApiHeader getApiHeader() {
        return null;
    }
}
