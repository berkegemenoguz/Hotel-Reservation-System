import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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
    //-------------------------------------------------------

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
    //-------------------------------------------------------
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

    //-----------------HotelMenu Class Tests-----------------
    //-------------------------------------------------------

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputCapture;

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void captureOutput() {
        outputCapture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCapture));
    }

    private String getOutput() {
        return outputCapture.toString();
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testMenuDisplaysOptions() {
        // Input: 6 = Exit
        setInput("6\n");
        captureOutput();

        HotelMenu.start();

        String output = getOutput();
        assertTrue(output.contains("MAIN MENU"));
        assertTrue(output.contains("List the rooms"));
        assertTrue(output.contains("Book a reservation"));
        assertTrue(output.contains("Exit the system"));
    }

    @Test
    void testListRoomsOption() {
        // Input: 1 = List rooms, 6 = Exit
        setInput("1\n6\n");
        captureOutput();

        HotelMenu.start();

        String output = getOutput();
        assertTrue(output.contains("Rooms") || output.contains("Room") || output.contains("N101"));
    }

    @Test
    void testInvalidMenuChoice() {
        // Input: 99 = Invalid, 6 = Exit
        setInput("99\n6\n");
        captureOutput();

        HotelMenu.start();

        String output = getOutput();
        assertTrue(output.contains("Invalid"));
    }

}
