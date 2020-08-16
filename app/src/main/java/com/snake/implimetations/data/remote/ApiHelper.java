
package com.snake.implimetations.data.remote;


import com.snake.implimetations.data.model.api.Base;
import com.snake.implimetations.data.model.api_request.DataRequest;

import io.reactivex.Single;


public interface ApiHelper {

    Single<Base> getDataApiCall(DataRequest request);

    ApiHeader getApiHeader();
}
