package com.oimtrust.weatheryahoo;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oimtrust.weatheryahoo.data.Channel;
import com.oimtrust.weatheryahoo.data.Item;
import com.oimtrust.weatheryahoo.service.WeatherServiceCallback;
import com.oimtrust.weatheryahoo.service.YahooWeatherService;

public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView iconWeatherImageView;
    private TextView temperatureTextview;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconWeatherImageView    = (ImageView) findViewById(R.id.imgView_iconWeather);
        temperatureTextview     = (TextView) findViewById(R.id.textView_temperature);
        conditionTextView       = (TextView) findViewById(R.id.textView_condition);
        locationTextView        = (TextView) findViewById(R.id.textView_location);

        service = new YahooWeatherService(this);
        dialog  = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Malang, Indonesia");
    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();

        int resourceId    = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable    = getResources().getDrawable(resourceId);
        iconWeatherImageView.setImageDrawable(weatherIconDrawable);

        temperatureTextview.setText(item.getCondition().getTemperature() + "\u00B0" + channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(service.getLocation());

    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
