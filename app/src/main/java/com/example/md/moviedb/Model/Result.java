package com.example.md.moviedb.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MD on 15-05-2018.
 */

public class Result {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param title
     * @param releaseDate
     * @param overview
     */
    public Result(String title, String overview, String releaseDate) {
        super();
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
