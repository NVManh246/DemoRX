package com.example.nvmanh.demorx.data;

import com.example.nvmanh.demorx.data.model.Hero;

import java.util.List;

import io.reactivex.Observable;

public class HerosRepository implements HerosDataSource.HerosRemoteDataSource{

    private static HerosRepository sInstance;
    private HerosDataSource.HerosRemoteDataSource mRemoteDataSource;

    private HerosRepository(HerosDataSource.HerosRemoteDataSource remoteDataSource){
        mRemoteDataSource = remoteDataSource;
    }

    public static HerosRepository getInstance(
            HerosDataSource.HerosRemoteDataSource remoteDataSource){
        if(sInstance == null){
            sInstance = new HerosRepository(remoteDataSource);
        }
        return sInstance;
    }

    @Override
    public Observable<List<Hero>> getHeros() {
        return mRemoteDataSource.getHeros();
    }

    @Override
    public Observable<List<Hero>> searchHero(String key) {
        return mRemoteDataSource.searchHero(key);
    }
}
