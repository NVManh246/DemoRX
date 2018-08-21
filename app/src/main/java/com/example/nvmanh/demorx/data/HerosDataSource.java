package com.example.nvmanh.demorx.data;

import com.example.nvmanh.demorx.data.model.Hero;

import java.util.List;

import io.reactivex.Observable;

public interface HerosDataSource {

    interface HerosRemoteDataSource {
        Observable<List<Hero>> getHeros();
        Observable<List<Hero>> searchHero(String key);
    }
}
