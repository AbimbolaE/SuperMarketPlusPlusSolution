package com.supermarketplusplus.factory;

import com.supermarketplusplus.model.Item;
import com.supermarketplusplus.updater.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Bimz on 24/02/2015.
 */
public class ItemUpdaterFactoryTest {

    private ItemUpdaterFactory itemUpdaterFactory;

    @Before
    public void setUp() {
        itemUpdaterFactory = new ItemUpdaterFactory();
    }

    @Test
    public void should_return_a_regular_updater_when_the_item_name_is_not_aged_brie_or_sulfaras_or_a_backstage_pass_or_an_organic_banana() {
        //Given
        Item item = new Item("Chocolate", 0, 0);

        //When
        ItemUpdater updater = itemUpdaterFactory.getUpdater(item.getName());

        //Then
        assertThat(updater, is(instanceOf(RegularUpdater.class)));
    }

    @Test
    public void should_return_a_aged_brie_updater_when_the_item_name_is_aged_brie() {
        //Given
        Item item = new Item("Aged Brie", 0, 0);

        //When
        ItemUpdater updater = itemUpdaterFactory.getUpdater(item.getName());

        //Then
        assertThat(updater, is(instanceOf(AgedBrieUpdater.class)));
    }

    @Test
    public void should_return_a_organic_banana_updater_when_the_item_name_is_organic_banana() {
        //Given
        Item item = new Item("Organic Banana", 0, 0);

        //When
        ItemUpdater updater = itemUpdaterFactory.getUpdater(item.getName());

        //Then
        assertThat(updater, is(instanceOf(OrganicBananaUpdater.class)));
    }

    @Test
    public void should_return_a_sulfaras_updater_when_the_item_name_is_sulfaras() {
        //Given
        Item item = new Item("Sulfuras", 0, 0);

        //When
        ItemUpdater updater = itemUpdaterFactory.getUpdater(item.getName());

        //Then
        assertThat(updater, is(instanceOf(SulfarasUpdater.class)));
    }

    @Test
    public void should_return_a_backstage_passes_updater_when_the_item_name_is_backstage_passes() {
        //Given
        Item item = new Item("Backstage Passes", 0, 0);

        //When
        ItemUpdater updater = itemUpdaterFactory.getUpdater(item.getName());

        //Then
        assertThat(updater, is(instanceOf(BackstagePassesUpdater.class)));
    }
}
