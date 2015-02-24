package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;

/**
 * Created by Bimz on 24/02/2015.
 */
public class OrganicBananaUpdater implements ItemUpdater {
    private final int sellInRate = 1;
    private int qualityReductionRate = 2;

    @Override
    public void update(Item item) {
        int updatedSellIn = item.getSellIn() - sellInRate;
        item.setSellIn(updatedSellIn);

        if (item.getQuality() > 0) {
            int updatedQuality = item.getQuality() - qualityReductionRate;
            item.setQuality(updatedQuality);
        }
    }
}
