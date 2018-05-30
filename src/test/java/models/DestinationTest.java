package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestinationTest {

    @Before
    public void setUp() throws Exception {
    }

    public Destination setUpDestination () {
        return new Destination("Thailand", "Bangkok", "2010", "work", "https://www.streetsoftheworld.com/shop/paris/78-large_default/thailand-bangkok.jpg", "food, beaches, jungles");
    }

    @After
    public void tearDown() throws Exception {
        Destination.clearAll();
    }


    @Test
    public void deastination_instatiatesCorrectly() throws Exception {
        Destination destination = setUpDestination();
        assertEquals(true, destination instanceof Destination);
    }

    @Test
    public void getCountry_getsCountry_thailand() {
        Destination destination = setUpDestination();
        assertEquals("Thailand", destination.getCountry());
    }

    @Test
    public void getCityArea_getsCityArea_bangkok() {
        Destination destination = setUpDestination();
        assertEquals("Bangkok", destination.getCityArea());

    }

    @Test
    public void getdate_getsdate_2010() {
        Destination destination = setUpDestination();
        assertEquals("2010", destination.getDate());
    }

    @Test
    public void getdate_getsdate_work() {
        Destination destination = setUpDestination();
        assertEquals("work", destination.getReason());
    }

    @Test
    public void getCountry_getsCountry_URL() {
        Destination destination = setUpDestination();
        assertEquals("https://www.streetsoftheworld.com/shop/paris/78-large_default/thailand-bangkok.jpg", destination.getPicture());
    }

    @Test
    public void getdate_getsdate_foodBeachesJungles() {
        Destination destination = setUpDestination();
        assertEquals("food, beaches, jungles", destination.getHighlights());
    }

    @Test
    public void getAll_getAllInstancesOfDestination_1() {
        Destination destination = setUpDestination();
        assertEquals(1, Destination.getAll().size());
    }
}