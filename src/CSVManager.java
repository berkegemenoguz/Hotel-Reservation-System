import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {
    private static final String DATA_DIR = "data/";
    private static final String CUSTOMERS_FILE = DATA_DIR + "customers.csv";
    private static final String ROOMS_FILE = DATA_DIR + "rooms.csv";
    private static final String RESERVATIONS_FILE = DATA_DIR + "reservations.csv";

    static {
        new File(DATA_DIR).mkdirs();
    }

    // CUSTOMER OPERATIONS

    //Saves Customers to CSV files
    public static void saveCustomer(Customer customer) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CUSTOMERS_FILE, true))) {
            pw.println(customer.getId() + "," + customer.getName() + "," + customer.getSurname() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
        } catch (IOException e) {
            System.out.println("Customer register error: " + e.getMessage());
        }
    }

    //Reads the customers from CSV files
    public static List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        File file = new File(CUSTOMERS_FILE);
        if (!file.exists())
            return customers;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    Customer c = new Customer(Integer.parseInt(parts[0].trim()), parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim());
                    customers.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Customer Reading Error: " + e.getMessage());
        }
        return customers;
    }
}