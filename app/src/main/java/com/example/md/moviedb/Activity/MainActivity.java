package com.example.md.moviedb.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.md.moviedb.Adapter.MovieAdapter;
import com.example.md.moviedb.Api.MovieApi;
import com.example.md.moviedb.Api.RetrofitClient;
import com.example.md.moviedb.Model.ArrayClass;
import com.example.md.moviedb.Model.Result;
import com.example.md.moviedb.R;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    MovieApi movieApi;
    RecyclerView recyclerView_movies;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    final  static String API_KEY = "d3108e724779f6bd4aa1f46d5464f8f5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init api
        movieApi = RetrofitClient.getClient().create(MovieApi.class);

        recyclerView_movies = findViewById(R.id.recyclerView);
        recyclerView_movies.setHasFixedSize(true);
        recyclerView_movies.setLayoutManager(new LinearLayoutManager(this));

        fetchData();



    }

    private void fetchData() {

        compositeDisposable.add(movieApi.getUpcomingMovies(API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
           .subscribe(new Consumer<ArrayClass>() {
               @Override
               public void accept(ArrayClass arrayClass) throws Exception {
                    List<Result> results  = arrayClass.getResults();
                    MovieAdapter adapter = new MovieAdapter(results,getApplicationContext());
                    recyclerView_movies.setAdapter(adapter);
               }
           }));
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
