package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

/**
 * Created by Bimz on 24/02/2015.
 */
public class OrganicBananaTest {

    private OrganicBananaUpdater organicBananasUpdater;

    @Before
    public void setUp() {
        organicBananasUpdater = new OrganicBananaUpdater();
    }

    @Test
    public void should_reduce_the_quality_of_organic_bananas_by_two() {
        //Given
        Item organicBanana = new Item("Organic Banana", 10, 10);

        //When
        organicBananasUpdater.update(organicBanana);

        //Then
        assertEquals(8, organicBanana.getQuality());
    }

    @Test
    public void should_reduce_the_sellIn_duration_of_the_regularItem_by_one() {
        //Given
        Item organicBanana = new Item("Organic Banana", 10, 10);

        //When
        organicBananasUpdater.update(organicBanana);

        //Then
        Assert.assertEquals(9, organicBanana.getSellIn());
    }


    @Test
    public void should_not_reduce_the_quality_of_the_regularItem_below_zero() {
        //Given
        Item organicBanana = new Item("SomethingRegular", 10, 0);

        //When
        organicBananasUpdater.update(organicBanana);

        //Then
        assertThat(organicBanana.getQuality(), greaterThan(-1));
    }
}
