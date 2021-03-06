package com.oimtrust.weatheryahoo.data;

import org.json.JSONObject;

/**
 * Created by Oim on 10/12/2016.
 */

public class Units implements JSONPopulator {
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");
    }
}
