package com.snake.implimetations.data.model.api_request;

public class DataRequest {


    private String searchObject;

    public DataRequest(String searchObject) {
        this.searchObject = searchObject;
    }

    public String getSearchObject() {
        return searchObject;
    }

    public void setSearchObject(String searchObject) {
        this.searchObject = searchObject;
    }
}
