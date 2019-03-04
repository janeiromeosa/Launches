package com.example.launchlibrary.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.launchlibrary.R;
import com.example.launchlibrary.model.Launch;
import com.example.launchlibrary.model.LaunchResponse;

import java.util.ArrayList;
import java.util.List;

public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.ViewHolder> {

    private final List<LaunchResponse> results = new ArrayList<>();


    public void setData(List<LaunchResponse> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        LaunchResponse launchResponse = results.get(position);

        launchResponse.tvName.setText(launchResponse.getLaunches());





    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        static TextView tvName;
        static TextView tvList;


       // final TextView mContentView;

        ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv); //this is where the list is going.
           // mContentView = view.findViewById(R.id.content);

        }
    }
    public interface OnItemSelectedListener{
      //  void onItemSelected(Result result);
    }
}

