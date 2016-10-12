package com.oimtrust.weatheryahoo.data;

import org.json.JSONObject;

/**
 * Created by Oim on 10/12/2016.
 */

public class Channel implements JSONPopulator {
    private Units units;
    private Item item;

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public void populate(JSONObject data) {
        units   = new Units();
        units.populate(data.optJSONObject("units"));

        item    = new Item();
        item.populate(data.optJSONObject("item"));
    }
}
