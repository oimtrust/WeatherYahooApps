package com.oimtrust.weatheryahoo.data;

import org.json.JSONObject;

/**
 * Created by Oim on 10/12/2016.
 */

public class Item implements JSONPopulator {
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
        condition   = new Condition();
        condition.populate(data.optJSONObject("condition"));
    }
}
