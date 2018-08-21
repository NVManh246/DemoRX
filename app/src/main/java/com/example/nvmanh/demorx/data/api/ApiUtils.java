package com.example.nvmanh.demorx.data.api;

public class ApiUtils {
    public static final String BASE_URL = "http://192.168.2.100/weblol/";

    public static ApiInterface getApi(){
        return ApiClient.getInstance(BASE_URL).create(ApiInterface.class);
    }
}
