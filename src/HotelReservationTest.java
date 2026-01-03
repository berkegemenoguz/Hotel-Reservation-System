import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;



public class HotelReservationTest {

    private Customer testCustomer;
    private NormalRoom testNormalRoom;
    private SuiteRoom testSuiteRoom;

    @BeforeEach
    void setUp() {
        testCustomer = new Customer(1, "Caner", "Asilioglu", "caner@gmail.com", "321312312");
        testNormalRoom = new NormalRoom(101);
        testSuiteRoom = new SuiteRoom(201);
    }

    //-----------------Customer Tests-----------------

    @Test
    void testCustomerCreation() {
        assertEquals(1, testCustomer.getId());
        assertEquals("Caner", testCustomer.getName());
        assertEquals("Asilioglu", testCustomer.getSurname());
        assertEquals("caner@gmail.com", testCustomer.getEmail());
        assertEquals("321312312", testCustomer.getPhoneNumber());
    }

    @Test
    void testCustomerSetters() {
        testCustomer.setName("davut");
        testCustomer.setSurname("cuci");
        testCustomer.setEmail("davut@gmail.com");

        assertEquals("davut", testCustomer.getName());
        assertEquals("cuci", testCustomer.getSurname());
        assertEquals("davut@gmail.com", testCustomer.getEmail());
    }

    //-----------------Room Tests-----------------

    @Test
    void testNormalRoomPrice() {
        assertEquals(Prices.NORMAL_ROOM_PRICE, testNormalRoom.getNormalPrice());
    }

    @Test
    void testSuiteRoomPrice() {
        assertEquals(Prices.SUITE_ROOM_PRICE, testSuiteRoom.getNormalPrice());
    }

    @Test
    void testNormalRoomCalculatePrice() {
        int days = 3;
        double expected = Prices.NORMAL_ROOM_PRICE * days;
        assertEquals(expected, testNormalRoom.CalculatePrice(days));
    }

    @Test
    void testSuiteRoomCalculatePrice() {
        int days = 5;
        double expected = Prices.SUITE_ROOM_PRICE * days;
        assertEquals(expected, testSuiteRoom.CalculatePrice(days));
    }

    @Test
    void testRoomOccupiedStatus() {
        assertFalse(testNormalRoom.isOccupied());
        testNormalRoom.setOccupied(true);
        assertTrue(testNormalRoom.isOccupied());
    }

    @Test
    void testRoomDetails() {
        String details = testNormalRoom.getRoomDetails();
        assertTrue(details.contains("101"));
        assertTrue(details.contains("Normal Room"));
    }



}
