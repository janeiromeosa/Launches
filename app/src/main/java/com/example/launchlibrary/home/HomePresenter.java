package com.example.launchlibrary.home;

import com.example.launchlibrary.model.DataSource;
import com.example.launchlibrary.model.Launch;
import com.example.launchlibrary.model.LaunchResponse;
import com.example.launchlibrary.model.RemoteDataSource;

import java.util.List;

        public class HomePresenter implements HomeContract.Presenter, DataSource.DataListener {

    private final HomeContract.View view;
    private final DataSource dataSource;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        dataSource = new RemoteDataSource(this);
    }


    @Override
    public void onSuccess(LaunchResponse launchResponse) {
        view.showLaunches(launchResponse.getLaunches());
    }

    @Override
    public void onFailure(Throwable throwable) {
        view.showError(throwable.getMessage());
    }

    @Override
    public void loadListLaunches(String date) {
        final DataSource dataSource = new RemoteDataSource(this);
        if(date.isEmpty()){
            view.showError("Click the text view my GUY");
            return;
        }else{
            dataSource.getLaunchfromDate(date);
        }
    }
}
