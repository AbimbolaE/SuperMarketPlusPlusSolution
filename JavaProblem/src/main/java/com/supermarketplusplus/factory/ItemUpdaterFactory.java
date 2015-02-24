package com.supermarketplusplus.factory;

import com.supermarketplusplus.updater.*;

/**
 * Created by Bimz on 24/02/2015.
 */
public class ItemUpdaterFactory {

    public ItemUpdater getUpdater(String itemName) {
        ItemUpdater itemUpdater = new RegularUpdater();

        if (itemName.toLowerCase().equals("aged brie")){
            itemUpdater = new AgedBrieUpdater();
        } else if(itemName.toLowerCase().equals("organic banana")) {
            itemUpdater = new OrganicBananaUpdater();
        } else if(itemName.toLowerCase().equals("sulfuras")) {
            itemUpdater = new SulfarasUpdater();
        } else if(itemName.toLowerCase().equals("backstage passes")) {
            itemUpdater = new BackstagePassesUpdater();
        }

        return itemUpdater;
    }

}
