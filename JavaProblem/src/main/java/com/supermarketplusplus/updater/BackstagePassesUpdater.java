package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;

/**
 * Created by Bimz on 24/02/2015.
 */
public class BackstagePassesUpdater implements ItemUpdater {
    private int sellInRate = 1;
    private int qualityChangeRate = 1;

    @Override
    public void update(Item item) {
        if (item.getSellIn() <= 10 && item.getSellIn() > 5) qualityChangeRate = 2;
        if (item.getSellIn() <= 5 && item.getSellIn() > 0) qualityChangeRate = 3;

        if (item.getQuality() < 50) {
            int updatedQuality = item.getQuality() + qualityChangeRate;
            item.setQuality(updatedQuality);
        }

        if (item.getSellIn() == 0) {
            item.setQuality(NO_QUALITY_LEFT);
        }

        int updatedSellIn = item.getSellIn() - sellInRate;
        item.setSellIn(updatedSellIn);
    }
}
