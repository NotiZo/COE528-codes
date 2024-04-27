/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package coe528.lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author notiz
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testConstructor() {
        //Test the constructor with valid arguments
        Flight instance = new Flight(1, "Canada", "China", "10:00 AM", 10, 100.0);

        //Verifies that the instance has the expected values
        assertEquals(1, instance.getFlightNumber());
        assertEquals("Canada", instance.getOrigin());
        assertEquals("China", instance.getDestination());
        assertEquals("10:00 AM", instance.getDepartureTime());
        assertEquals(10, instance.getCapacity());
        assertEquals(10, instance.getNumberOfSeatsLeft());
        assertEquals(100.0, instance.getOriginalPrice(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        //destination is the same as origin
        Flight invalidInstance = new Flight(1, "China", "China", "10:00 AM", 10, 100.0);
    }

    @Test
    public void testBookASeat() {
        //Create a Flight instance with a known capacity
        Flight instance = new Flight(1, "Canada", "China", "10:00 AM", 10, 100.0);

        //Test booking a seat when there are available seats
        assertTrue(instance.bookASeat());

        //Test booking a seat when there are no available seats
        for (int i = 0; i < 10; i++) {
            instance.bookASeat();
        }
        assertFalse(instance.bookASeat());
    }

    @Test
    public void testGettersAndSetters() {
        //Create a Flight instance
        Flight instance = new Flight(1, "Canada", "China", "10:00 AM", 10, 100.0);

        //Test getters and setters
        instance.setFlightNumber(2);
        assertEquals(2, instance.getFlightNumber());

        instance.setCapacity(20);
        assertEquals(20, instance.getCapacity());

        instance.setNumberOfSeatsLeft(15);
        assertEquals(15, instance.getNumberOfSeatsLeft());

        instance.setOrigin("America");
        assertEquals("America", instance.getOrigin());

        instance.setDestination("Ontario");
        assertEquals("Ontario", instance.getDestination());

        instance.setDepartureTime("12:00 PM");
        assertEquals("12:00 PM", instance.getDepartureTime());

        instance.setOriginalPrice(150.0);
        assertEquals(150.0, instance.getOriginalPrice(), 0);
    }

    @Test
    public void testToString() {
        //Create a Flight instance
        Flight instance = new Flight(1, "Canada", "China", "10:00 AM", 10, 100.0);

        //Test toString method
        String expectedString = "Flight Number: 1, Canada to China, 10:00 AM, Original Price: $100.0\n";
        assertEquals(expectedString, instance.toString());
    }
}
