package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;

/**
 * Created by Bimz on 24/02/2015.
 */
public class SulfarasUpdater implements ItemUpdater{
    @Override
    public void update(Item item) {
        //Does nothing as Sulfaras does not lose quality or sellIn duration
    }
}
