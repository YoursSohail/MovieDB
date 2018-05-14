package com.example.md.moviedb.Api;

import com.example.md.moviedb.Model.ArrayClass;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MD on 15-05-2018.
 */

public interface MovieApi {

    @GET("movie/upcoming")
    Observable<ArrayClass> getUpcomingMovies(@Query("api_key") String apiKey);
}
