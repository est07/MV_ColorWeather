package com.bench.eagle.mvp_colorweather.service;


import android.support.annotation.NonNull;

import com.bench.eagle.mvp_colorweather.service.api.CostantsApi;
import com.bench.eagle.mvp_colorweather.service.api.WeatherClient;
import com.bench.eagle.mvp_colorweather.utils.SharedPreferences;

import java.io.IOException;


import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ListWeatherService {



    public void getListWeather(@NonNull Observer<GetWeatherResponse> observer, String dataLocation){

        Observable.create((ObservableOnSubscribe<GetWeatherResponse>) observableEmitter -> {
            try {
                WeatherClient client = ServiceGenerator.createService(WeatherClient.class);
                Response<GetWeatherResponse> response = client.getWeather( dataLocation, CostantsApi.UNITS_SI).execute();
                observableEmitter.onNext(response.body());

            } catch (IOException ex) {
                observableEmitter.onError(ex);
            }
            observableEmitter.onComplete();
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}
