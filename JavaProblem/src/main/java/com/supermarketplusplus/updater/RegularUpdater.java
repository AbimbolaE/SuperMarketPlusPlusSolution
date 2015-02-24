package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;

/**
 * Created by Bimz on 24/02/2015.
 */
public class RegularUpdater implements ItemUpdater {

    private int rate = 1;

    @Override
    public void update(Item item) {
        int updatedSellIn = item.getSellIn() - rate;
        item.setSellIn(updatedSellIn);

        if (item.getSellIn() <= 0) rate = 2;

        if (item.getQuality() > 0) {
            int updatedQuality = item.getQuality() - rate;
            item.setQuality(updatedQuality);
        }
    }
}
