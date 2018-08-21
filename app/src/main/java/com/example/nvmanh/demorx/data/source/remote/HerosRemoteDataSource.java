package com.example.nvmanh.demorx.data.source.remote;

import com.example.nvmanh.demorx.data.HerosDataSource;
import com.example.nvmanh.demorx.data.api.ApiClient;
import com.example.nvmanh.demorx.data.api.ApiInterface;
import com.example.nvmanh.demorx.data.model.Hero;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HerosRemoteDataSource implements HerosDataSource.HerosRemoteDataSource {

    private static HerosRemoteDataSource sInstance;
    private ApiInterface mApi;

    private HerosRemoteDataSource(ApiInterface api){
        mApi = api;
    }

    public static HerosRemoteDataSource getInstance(ApiInterface api){
        if(sInstance == null){
            sInstance = new HerosRemoteDataSource(api);
        }
        return sInstance;
    }

    @Override
    public Observable<List<Hero>> getHeros() {
        return mApi.getHeros();
    }

    @Override
    public Observable<List<Hero>> searchHero(String key) {
        return mApi.searchHero(key);
    }
}
