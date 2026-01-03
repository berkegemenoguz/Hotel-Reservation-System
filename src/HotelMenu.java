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
        while(running)

    {
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

    private static void showMainMenu() {
        System.out.println("\n---------- MAIN MENU ----------");
        System.out.println("1. List the rooms");
        System.out.println("2. Book a reservation");
        System.out.println("3. Show reservations");
        System.out.println("4. Add customer");
        System.out.println("5. Show customers");
        System.out.println("6. Exit the system");
        System.out.println("--------------------------------");
    }

    private static void addCustomer() {
        System.out.println("\n--- Add New Customer ---");

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Surname: ");
        String surname = scanner.nextLine().trim();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();

        Customer customer = new Customer(nextCustomerId, name, surname, email, phone);
        customers.put(nextCustomerId, customer);
        CSVManager.saveCustomer(customer);

        System.out.println("\nCustomer added! ID: " + nextCustomerId);
        nextCustomerId++;
    }

    private static void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("\nNo registered customers yet.");
            return;
        }

        System.out.println("\n----------------- CUSTOMERS -----------------");
        for (Customer c : customers.values()) {
            System.out.println("ID: " + c.getId() + " | " + c.getName() + " " + c.getSurname() +
                    " | " + c.getEmail() + " | Phone: " + c.getPhoneNumber());
        }
        System.out.println("------------------------------------------------");
    }

    private static void makeReservation() {
        System.out.println("\n----- Make reservation -----");
        if (customers.isEmpty()) {
            System.out.println("No customers yet! Add customers.");
            return;
        }

        listCustomers();

        int customerId = getIntInput("Customer ID: ");
        Customer customer = customers.get(customerId);

        if (customer == null) {
            System.out.println("Invalid ID!");
            return;
        }

        RoomManager.listAllRooms();

        System.out.print("Room code: (N101, S201 etc.): ");
        String roomCode = scanner.nextLine().trim().toUpperCase();

        Rooms room = RoomManager.getRoom(roomCode);
        if (room == null) {
            System.out.println("Invalid room code!");
            return;
        }

        int days = getIntInput("Days to stay: ");
        if (days <= 0) {
            System.out.println("U cant stay 0 days!");
            return;
        }

        try {
            Reservation reservation = new Reservation(customer, room, days);


            addExtraServices(reservation);

            reservation.saveToCSV();
            reservations.add(reservation);

            System.out.println("\n------Reservation completed------");
            reservation.prd();

        } catch (IllegalStateException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }


}






}