package VehicleRent;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RentalTest extends TestCase {
    private Rental rental;
    Vehicle vehicle = new Vehicle(101,"Audi","A5",4,"MH13T5646");
    @Before
    public void setUp() {
        rental = new Rental("John","10-04-2022","20-04-2022",10,101,vehicle);
    }
    @Test
    public void testGetCustomer_Name() {
        assertEquals("John",rental.getCustomer_Name());
    }

    @Test
    public void testGetStart_date() {
        assertEquals("10-04-2022", rental.getStart_date());
    }

    @Test
    public void testGetEnd_date() {
        assertEquals("20-04-2022", rental.getEnd_date());
    }

    @Test
    public void testGetNumber_of_days() {
        assertEquals(10,rental.getNumber_of_days());
    }

    @Test
    public void testGetIdentification_code() {
        assertEquals(101,rental.getIdentification_code());
    }

}