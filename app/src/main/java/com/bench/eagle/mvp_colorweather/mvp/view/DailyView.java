package com.bench.eagle.mvp_colorweather.mvp.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.adapters.DailyWeatherAdapter;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;
import com.bench.eagle.mvp_colorweather.ui.ActivityView;
import com.bench.eagle.mvp_colorweather.ui.DailyWeatherActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyView extends ActivityView<DailyWeatherActivity> {

    @BindView(R.id.dailyRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.dailyNoDataTextView)
    TextView noDataTextView;

    private DailyWeatherAdapter adapter;

    public DailyView(DailyWeatherActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setDailyWeatherItems(ArrayList<DataWeatherResponse> daily, String timeZone){

        adapter = new DailyWeatherAdapter(getContext(),daily,timeZone);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void hideNoDataText() {
        noDataTextView.setVisibility(View.GONE);
    }


    public void showNoDataText() {
        noDataTextView.setVisibility(View.VISIBLE);
    }


}
