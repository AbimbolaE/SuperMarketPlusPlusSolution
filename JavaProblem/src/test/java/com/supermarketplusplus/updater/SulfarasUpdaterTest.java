package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Bimz on 24/02/2015.
 */
public class SulfarasUpdaterTest {

    private SulfarasUpdater sulfarasUpdater;

    @Before
    public void setUp() {
        sulfarasUpdater = new SulfarasUpdater();
    }

    @Test
    public void should_not_decrease_the_quality_of_sulfuras() {
        //Given
        Item item = new Item("Sulfuras", 10, 10);

        //When
        sulfarasUpdater.update(item);

        //Then
        assertEquals(10, item.getQuality());
    }

    @Test
    public void should_not_decrease_the_sellIn_duration_of_sulfuras() {
        //Given
        Item item = new Item("Sulfuras", 10, 10);

        //When
        sulfarasUpdater.update(item);

        //Then
        assertEquals(10, item.getSellIn());
    }
}
