package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Bimz on 24/02/2015.
 */
public class RegularUpdaterTest {
    
    private RegularUpdater regularUpdater;

    @Before
    public void setUp() {
        regularUpdater = new RegularUpdater();
    }

    @Test
    public void should_reduce_the_quality_of_the_item_by_one() {
        //Given
        Item item = new Item("SomethingRegular", 10, 10);

        //When
        regularUpdater.update(item);

        //Then
        assertEquals(9, item.getQuality());
    }

    @Test
    public void should_reduce_the_sellIn_duration_of_the_item_by_one() {
        //Given
        Item item = new Item("SomethingRegular", 10, 10);

        //When
        regularUpdater.update(item);

        //Then
        assertEquals(9, item.getSellIn());
    }

    @Test
    public void should_not_reduce_the_quality_of_the_item_below_zero() {
        //Given
        Item item = new Item("SomethingRegular", 10, 0);

        //When
        regularUpdater.update(item);

        //Then
        assertEquals(0, item.getQuality());
    }

    @Test
    public void should_reduce_the_quality_of_the_item_by_two_when_the_sellIn_date_is_zero_or_below() {
        //Given
        Item expiresToday = new Item("SomethingRegular", 0, 10);
        Item expiredYesterday = new Item("SomethingRegular", -1, 10);

        //When
        regularUpdater.update(expiresToday);
        regularUpdater.update(expiredYesterday);

        //Then
        assertEquals(8, expiresToday.getQuality());
        assertEquals(8, expiredYesterday.getQuality());
    }
}
