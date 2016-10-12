package com.oimtrust.weatheryahoo.service;

import com.oimtrust.weatheryahoo.data.Channel;

/**
 * Created by Oim on 10/12/2016.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
