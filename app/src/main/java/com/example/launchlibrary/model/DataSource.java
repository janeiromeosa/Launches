package com.example.launchlibrary.model;


import java.util.List;

public interface DataSource {
    void getLaunchfromDate(String date);

    interface DataListener {
        void onSuccess(LaunchResponse launchResponse);
        void onFailure(Throwable throwable);
    }
}
