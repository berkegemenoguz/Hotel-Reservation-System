import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Hotel-Reservation-System")
public class HotelReservationTest {

    private Customer customer;
    private NormalRoom normalRoom;
    private SuiteRoom suiteRoom;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "Bilal", "Hancı", "bilalhanci@gmail.com", "321321");
        normalRoom = new NormalRoom(101, 500.0);
        suiteRoom = new SuiteRoom(201, 1000.0);
    }

    @Test
    @DisplayName("Customer properties are set correctly.")
    void testCustomerCreation() {
        assertEquals("Bilal", customer.getName(), "Customer name should be Bilal.");
        assertEquals("bilalhanci@gmail.com", customer.getEmail(), "Customer email should match.");
    }

    @Test
    @DisplayName("Price calculation works for different room types.")
    void testRoomPriceCalculation() {
        assertEquals(2500.0, normalRoom.CalculatePrice(5), "Normal room price for 5 days should be 2500");
        assertEquals(3000.0, suiteRoom.CalculatePrice(3), "Suite room price for 3 days should be 3000");
    }

    @Test
    @DisplayName("Room details returns the correct format.")
    void testRoomDetails() {
        assertEquals("Normal Room ==> Room No: 101", normalRoom.getRoomDetails(),
                "Normal room details format is incorrect");
        assertEquals("Suite Room ==> Room No: 201", suiteRoom.getRoomDetails(),
                "Suite room details format is incorrect");
    }




}