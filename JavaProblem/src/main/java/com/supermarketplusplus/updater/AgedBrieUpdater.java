package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;

/**
 * Created by Bimz on 24/02/2015.
 */
public class AgedBrieUpdater implements ItemUpdater {

    private final int rate = 1;

    @Override
    public void update(Item item) {

        int sellIn = item.getSellIn() - rate;
        item.setSellIn(sellIn);

        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + rate);
        }
    }
}
