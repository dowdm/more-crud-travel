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
    public void getDate_getsDate_2010() {
        Destination destination = setUpDestination();
        assertEquals("2010", destination.getDate());
    }

    @Test
    public void getReason_getsReason_work() {
        Destination destination = setUpDestination();
        assertEquals("work", destination.getReason());
    }

    @Test
    public void getPicture_getsPicture_URL() {
        Destination destination = setUpDestination();
        assertEquals("https://www.streetsoftheworld.com/shop/paris/78-large_default/thailand-bangkok.jpg", destination.getPicture());
    }

    @Test
    public void getHighlights_getsHighlights_foodBeachesJungles() {
        Destination destination = setUpDestination();
        assertEquals("food, beaches, jungles", destination.getHighlights());
    }

    @Test
    public void setCountry_setCountry_spain() {
        Destination destination = setUpDestination();
        destination.setCountry("Spain");
        assertEquals("Spain", destination.getCountry());
    }

    @Test
    public void setCityArea_setCityArea_theCoast() {
        Destination destination = setUpDestination();
        destination.setCityArea("the coast");
        assertEquals("the coast", destination.getCityArea());
    }

    @Test
    public void setDate_setDate_2000() {
        Destination destination = setUpDestination();
        destination.setDate("2000");
        assertEquals("2000", destination.getDate());
    }

    @Test
    public void setReason_setReason_punishment() {
        Destination destination = setUpDestination();
        destination.setReason("punishment");
        assertEquals("punishment", destination.getReason());
    }

    @Test
    public void setPicture_setPicture_URL() {
        Destination destination = setUpDestination();
        destination.setPicture("https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iP0foqZEKURY/v0/1200x-1.jpg");
        assertEquals("https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iP0foqZEKURY/v0/1200x-1.jpg", destination.getPicture());
    }

    @Test
    public void setHighlights_setHighlights_none() {
        Destination destination = setUpDestination();
        destination.setHighlights("none");
        assertEquals("none", destination.getHighlights());
    }


    @Test
    public void getAll_getAllInstancesOfDestination_1() {
        Destination destination = setUpDestination();
        assertEquals(1, Destination.getAll().size());
    }

    @Test
    public void getId_getsId_1() {
        Destination destination = setUpDestination();
        assertEquals(1, destination.getId());
    }

    @Test
    public void findById_returnsSpecificDestinationId_1() {
        Destination destination = setUpDestination();
        assertEquals(1, destination.findById(destination.getId()).getId());
    }

    @Test
    public void findById_returnsOtherSpecificDestinationId_2() {
        Destination destination = setUpDestination();
        Destination otherDestination = new Destination("a", "b", "c", "d", "e", "f");
        assertEquals(2, otherDestination.findById(otherDestination.getId()).getId());
    }

}