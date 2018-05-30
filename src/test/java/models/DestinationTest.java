package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestinationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deastination_instatiatesCorrectly() throws Exception {
        Destination destination = new Destination("Thailand", "Bangkok", "2010", "work", "https://jsdhfkjsdhf", "food, beaches, jungles");
        assertEquals(true, destination instanceof Destination);
    }
}