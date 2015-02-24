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
public class BackstagePassesUpdaterTest {

    private  BackstagePassesUpdater backstagePassesUpdater;
    
    @Before
    public void setUp() {
        backstagePassesUpdater = new BackstagePassesUpdater();
    }

    @Test
    public void should_increase_the_quality_of_the_backstage_pass_by_one_when_then_sellIn_duration_is_greater_than_10() {
        //Given
        Item backstagePass = new Item("Backstage Passes", 20, 21);

        //When
        backstagePassesUpdater.update(backstagePass);

        //Then
        assertEquals(22, backstagePass.getQuality());
    }

    @Test
    public void should_increase_the_quality_of_the_backstage_pass_by_two_when_then_sellIn_duration_is_between_10_and_6() {
        //Given
        Item backstagePassWithTenDaysLeft = new Item("Backstage Passes", 10, 10);
        Item backstagePassWithSixDaysLeft = new Item("Backstage Passes", 6, 14);

        //When
        backstagePassesUpdater.update(backstagePassWithTenDaysLeft);
        backstagePassesUpdater.update(backstagePassWithSixDaysLeft);

        //Then
        assertEquals(12, backstagePassWithTenDaysLeft.getQuality());
        assertEquals(16, backstagePassWithSixDaysLeft.getQuality());
    }

    @Test
    public void should_increase_the_quality_of_the_backstage_pass_by_three_when_then_sellIn_duration_is_between_5_and_1() {
        //Given
        Item backstagePassWithFiveDaysLeft = new Item("Backstage Passes", 5, 10);
        Item backstagePassWithOneDayLeft = new Item("Backstage Passes", 1, 14);

        //When
        backstagePassesUpdater.update(backstagePassWithFiveDaysLeft);
        backstagePassesUpdater.update(backstagePassWithOneDayLeft);

        //Then
        assertEquals(13, backstagePassWithFiveDaysLeft.getQuality());
        assertEquals(17, backstagePassWithOneDayLeft.getQuality());
    }

    @Test
    public void should_set_the_quality_of_the_backstage_pass_to_zero_when_the_sellIn_duration_is_zero() {
        //Given
        Item backstagePassWithNoDaysLeft = new Item("Backstage Passes", 0, 10);

        //When
        backstagePassesUpdater.update(backstagePassWithNoDaysLeft);

        //Then
        assertEquals(0, backstagePassWithNoDaysLeft.getQuality());
    }

    @Test
    public void should_reduce_the_sellIn_duration_of_the_backstage_pass_by_one() {
        //Given
        Item backstagePass = new Item("Backstage Passes", 10, 10);

        //When
        backstagePassesUpdater.update(backstagePass);

        //Then
        assertEquals(9, backstagePass.getSellIn());
    }

    @Test
    public void should_not_increase_the_quality_of_the_backstage_pass_beyond_50() {
        //Given
        Item backstagePass = new Item("Backstage Passes", 10, 50);

        //When
        backstagePassesUpdater.update(backstagePass);

        //Then
        assertEquals(50, backstagePass.getQuality());
    }

}
