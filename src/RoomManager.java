import java.util.HashMap;
import java.util.Map;

public class RoomManager {
    private static final Map<String, Rooms> rooms = new HashMap<>();

    public static final Rooms N101 = new NormalRoom(101);
    public static final Rooms N102 = new NormalRoom(102);
    public static final Rooms N103 = new NormalRoom(103);
    public static final Rooms N104 = new NormalRoom(104);
    public static final Rooms N105 = new NormalRoom(105);
    public static final Rooms N106 = new NormalRoom(106);
    public static final Rooms N107 = new NormalRoom(107);
    public static final Rooms N108 = new NormalRoom(108);

    public static final Rooms S201 = new SuiteRoom(201);
    public static final Rooms S202 = new SuiteRoom(202);

    static {
        rooms.put("N101", N101);
        rooms.put("N102", N102);
        rooms.put("N103", N103);
        rooms.put("N104", N104);
        rooms.put("N105", N105);
        rooms.put("N106", N106);
        rooms.put("N107", N107);
        rooms.put("N108", N108);
        rooms.put("S201", S201);
        rooms.put("S202", S202);
    }

    public static Rooms getRoom(String roomCode) {
        return rooms.get(roomCode.toUpperCase());
    }

    public static void listAllRooms() {
        System.out.println("\n------------------------ ROOM LIST ------------------------");
        System.out.println("Normal Rooms:");
        System.out.println("  N101 - Room 101 " + (N101.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("  N102 - Room 102 " + (N102.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("  N103 - Room 103 " + (N103.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("  N104 - Room 104 " + (N104.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("  N105 - Room 105 " + (N105.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("  N106 - Room 106 " + (N106.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("  N107 - Room 107 " + (N107.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("  N108 - Room 108 " + (N108.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("\nSuite Rooms:");
        System.out.println("  S201 - Room 201 " + (S201.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("  S202 - Room 202 " + (S202.isOccupied() ? "[FULL]" : "[EMPTY]"));
        System.out.println("----------------------------------------------------------------\n");
    }
}
