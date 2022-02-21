package VehicleRent;

import static org.junit.Assert.assertEquals;

        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class VehicleTest {

    private Vehicle vehicle;
    @Before
    public void setUp() {
        vehicle=new Vehicle(101,"Audi","A5",4,"MH13T5646");
    }

    @Test
    public void getIdentificationCode() {
        assertEquals(101, vehicle.getIdentificationCode());
    }

    @Test
    public void getBrand() {
        assertEquals("Audi",vehicle.getBrand());
    }

    @Test
    public void getModel() {
        assertEquals("A5", vehicle.getModel());
    }

    @Test
    public void getNumberOfSeat() {
        assertEquals(4, vehicle.getNumberOfSeat());
    }

    @Test
    public void getLicensePlate() {
        assertEquals("MH13T5646", vehicle.getLicensePlate());
    }
}