import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Hotel-Reservation-System")
public class HotelReservationTest {

    private Customer customer;
    private NormalRoom NormalRoom;
    private SuiteRoom SuiteRoom;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "Bilal", "Hancı", "bilalhanci@gmail.com", "321321");
        NormalRoom = new NormalRoom(101, 500.0);
        SuiteRoom = new SuiteRoom(201);
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
        assertEquals(2500.0, NormalRoom.CalculatePrice(5), "Normal room price for 5 days should be 2500");
        assertEquals(3000.0, SuiteRoom.CalculatePrice(3), "Suite room price for 3 days should be 3000");
    }

    @Test
    @DisplayName("Room details returns the correct format.")
    void testRoomDetails() {
        assertEquals("Normal Room ==> Room No: 101", NormalRoom.getRoomDetails(),
                "Normal room details format is incorrect");
        assertEquals("Suite Room ==> Room No: 201", SuiteRoom.getRoomDetails(),
                "Suite room details format is incorrect");
    }

    @Test
    @DisplayName("Reservation action creates and marks the room as occupied.")
    void testReservationCreation() {
        Reservation reservation = new Reservation(customer, NormalRoom, 3);
        assertEquals(1500.0, reservation.getTotalPrice(), "Reservation total should be 1500.");
        assertTrue(NormalRoom.isOccupied(), "Room should be marked as occupied after reservation.");
    }

    @Test
    @DisplayName("Service price is successfully added to reservation total.")
    void testAddServiceToReservation() {
        Reservation reservation = new Reservation(customer, NormalRoom, 2);
        RoomService breakfast = new RoomService("Breakfast", 100);
        reservation.addService(breakfast);
        assertEquals(1100.0, reservation.getTotalPrice(), "Total should include service price.");
    }

    @Test
    @DisplayName("Booking occupied room throws IllegalStateException")
    void testOccupiedRoomThrowsException() {
        NormalRoom.setOccupied(true);
        assertThrows(IllegalStateException.class, () -> {
            new Reservation(customer, NormalRoom, 2);
        }, "Should throw IllegalStateException when room is occupied");
    }
}