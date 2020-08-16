package com.snake.implimetations.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.snake.implimetations.data.model.api.Base;
import com.snake.implimetations.data.model.api_request.DataRequest;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public Single<Base> getDataApiCall(DataRequest request) {
        return Rx2AndroidNetworking.get(ApiEndPoint.BASE_URL)
                .addHeaders("Authorization","Client-ID 137cda6b5008a7c")
                .addQueryParameter("q",request.getSearchObject())
                .build()
                .getObjectSingle(Base.class);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }
}
