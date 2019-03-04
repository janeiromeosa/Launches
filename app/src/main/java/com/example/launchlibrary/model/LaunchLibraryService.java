package com.example.launchlibrary.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LaunchLibraryService {

    @GET(Constants.LAUNCH_ENDPOINT)
    Call<List<LaunchResponse>> getLaunchList(@Path("date") String date);

}
