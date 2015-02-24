package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
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
    public void should_reduce_the_quality_of_the_regularItem_by_one() {
        //Given
        Item regularItem = new Item("SomethingRegular", 10, 10);

        //When
        regularUpdater.update(regularItem);

        //Then
        assertEquals(9, regularItem.getQuality());
    }

    @Test
    public void should_reduce_the_sellIn_duration_of_the_regularItem_by_one() {
        //Given
        Item regularItem = new Item("SomethingRegular", 10, 10);

        //When
        regularUpdater.update(regularItem);

        //Then
        assertEquals(9, regularItem.getSellIn());
    }

    @Test
    public void should_not_reduce_the_quality_of_the_regularItem_below_zero() {
        //Given
        Item regularItem = new Item("SomethingRegular", 10, 0);

        //When
        regularUpdater.update(regularItem);

        //Then
        assertThat(regularItem.getQuality(), greaterThan(-1));
    }

    @Test
    public void should_reduce_the_quality_of_the_regularItem_by_two_when_the_sellIn_date_is_zero_or_below() {
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
