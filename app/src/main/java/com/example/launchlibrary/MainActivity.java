package com.example.launchlibrary;

import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.launchlibrary.home.HomeContract;
import com.example.launchlibrary.home.HomePresenter;
import com.example.launchlibrary.home.LaunchesAdapter;
import com.example.launchlibrary.model.Launch;
import com.example.launchlibrary.model.LaunchResponse;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.View {

    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private TextView displayDate;

    private final LaunchesAdapter launchesAdapter = new LaunchesAdapter();

    private final HomeContract.Presenter presenter = new HomePresenter(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.rvData);
        recyclerView.setAdapter(launchesAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);

        displayDate = findViewById(R.id.tvName);

        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog =
                        new DatePickerDialog(MainActivity.this, android.R.style.Theme_Black_NoTitleBar,
                                onDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("MainActivity", "onDateSet: " + year + "-" + month + "-" + dayOfMonth);
                month = month +1;

                String date = String.format("%d-%02d-%02d", year, month, dayOfMonth);
                displayDate.setText(date);
                presenter.loadListLaunches(date);
            }
        };
    }

    @Override
    public void showLaunches(List<Launch> launch) {
        launchesAdapter.setData(launch);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
