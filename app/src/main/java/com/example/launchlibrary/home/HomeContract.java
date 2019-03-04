package com.example.launchlibrary.home;


import com.example.launchlibrary.model.Launch;
import com.example.launchlibrary.model.LaunchResponse;

import java.util.List;

public interface HomeContract {
    interface Presenter { //core functionality of the app
        void loadListLaunches(String date);
    }

    interface View{
        void showLaunches(List<Launch> launch);
        void showError(String message);

    }
}
