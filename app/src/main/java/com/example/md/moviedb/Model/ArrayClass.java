package com.example.md.moviedb.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MD on 15-05-2018.
 */

public class ArrayClass {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ArrayClass() {
    }

    /**
     *
     * @param results
     */
    public ArrayClass(List<Result> results) {
        super();
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
