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
        Item sulfuras = new Item("Sulfuras", 10, 10);

        //When
        sulfarasUpdater.update(sulfuras);

        //Then
        assertEquals(10, sulfuras.getQuality());
    }

    @Test
    public void should_not_decrease_the_sellIn_duration_of_sulfuras() {
        //Given
        Item sulfuras = new Item("Sulfuras", 10, 10);

        //When
        sulfarasUpdater.update(sulfuras);

        //Then
        assertEquals(10, sulfuras.getSellIn());
    }

    @Test
    public void should_not_increase_the_quality_of_sulfuras_beyond_50() {
        //Given
        Item sulfuras = new Item("Sulfuras", 10, 80);

        //When
        sulfarasUpdater.update(sulfuras);

        //Then
        assertEquals(80, sulfuras.getQuality());
    }
}
