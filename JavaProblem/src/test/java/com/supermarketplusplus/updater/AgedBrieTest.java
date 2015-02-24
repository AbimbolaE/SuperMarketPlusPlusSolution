package com.supermarketplusplus.updater;

import com.supermarketplusplus.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Bimz on 24/02/2015.
 */
public class AgedBrieTest {

    private AgedBrieUpdater agedBrieUpdater;

    @Before
    public void setUp() {
        agedBrieUpdater = new AgedBrieUpdater();
    }

    @Test
    public void should_increase_the_quality_of_the_aged_brie() {
        //Given
        Item agedBrie = new Item("Aged Brie", 10, 10);

        //When
        agedBrieUpdater.update(agedBrie);

        //Then
        assertEquals(11, agedBrie.getQuality());
    }

    @Test
    public void should_reduce_the_sellIn_duration_of_the_agedBrie_by_one() {
        //Given
        Item agedBrie = new Item("Aged Brie", 10, 10);

        //When
        agedBrieUpdater.update(agedBrie);

        //Then
        assertEquals(9, agedBrie.getSellIn());
    }

    @Test
    public void should_not_increase_the_quality_of_the_agedbrie_beyond_50() {
        //Given
        Item agedBrie = new Item("Aged Brie", 10, 50);

        //When
        agedBrieUpdater.update(agedBrie);

        //Then
        assertEquals(50, agedBrie.getQuality());
    }

    @Test
    public void should_not_reduce_the_quality_of_the_agedBrie_below_zero() {
        //Given
        Item agedBrie = new Item("Aged Brie", 10, 0);

        //When
        agedBrieUpdater.update(agedBrie);

        //Then
        assertThat(agedBrie.getQuality(), greaterThan(-1));
    }
}
