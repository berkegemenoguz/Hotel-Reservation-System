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
}