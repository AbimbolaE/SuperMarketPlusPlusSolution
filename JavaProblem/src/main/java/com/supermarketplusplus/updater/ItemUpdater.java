package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;

/**
 * Created by Bimz on 24/02/2015.
 */
public interface ItemUpdater {

    int NO_QUALITY_LEFT = 0;

    void update(Item item);
}
