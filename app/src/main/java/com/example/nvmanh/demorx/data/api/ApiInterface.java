package com.example.nvmanh.demorx.data.api;

import com.example.nvmanh.demorx.data.model.Hero;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("gethero.php")
    Observable<List<Hero>> getHeros();

    @GET("searchheros.php")
    Observable<List<Hero>> searchHero(@Query("key") String key);
}
