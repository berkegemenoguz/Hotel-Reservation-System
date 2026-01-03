import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HotelMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static int nextCustomerId = 1;

    public static void start() {
        System.out.println("\n----------Hotel Reservation System----------");

        java.io.File roomsFile = new java.io.File("data/rooms.csv");
        if (!roomsFile.exists()) {
            CSVManager.initializeRoomsCSV();
        }
    }

    boolean running = true;
        while (running) {
        showMainMenu();
        int choice = getIntInput("Operation you wanna make is: ");

        switch (choice) {
            case 1:
                RoomManager.listAllRooms();
                break;
            case 2:
                makeReservation();
                break;
            case 3:
                CSVManager.listReservations();
                break;
            case 4:
                addCustomer();
                break;
            case 5:
                listCustomers();
                break;
            case 6:
                running = false;
                System.out.println("\nQuitting the system.");
                break;
            default:
                System.out.println("\nInvalid pick! Choose between 1-6.");
        }
    }
        scanner.close();
}
private static void showMainMenu() {
    System.out.println("\n---------- ANA MENU ----------");
    System.out.println("1. List the rooms");
    System.out.println("2. Book a reservation");
    System.out.println("3. Show reservations");
    System.out.println("4. Add customer");
    System.out.println("5. Show customers");
    System.out.println("6. Exit the system");
    System.out.println("--------------------------------");
}


