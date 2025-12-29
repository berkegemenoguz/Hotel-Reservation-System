import java.util.ArrayList;

public class Reservation {
    private final Customer Client;
    private final Rooms Room;
    private int StayDays;
    private double TotalPrice;

    private final ArrayList<RoomService> extraServices;

    public Reservation(Customer Client, Rooms Room, int stayDays) {
        if (Room.isOccupied()) {
            throw new IllegalStateException("Room " + Room.getRoomNumber() + " is already occupied.\n");
        }

        this.Client = Client;
        this.Room = Room;
        this.StayDays = stayDays;

        this.TotalPrice = Room.CalculatePrice(stayDays);

        this.extraServices = new ArrayList<>();

        Room.setOccupied(true);
        System.out.println("\nReservation Created for " + Client.getName() + " " + Client.getSurname());
    }

    public void addService(RoomService service) {
        if (this.Client != null) {
            this.extraServices.add(service);
            this.TotalPrice += service.getServicePrice();
        }
    }

    public void prd() {
        if (Client != null && Room != null) {
            System.out.println("\n-----------Reception Receipt------------");
            System.out.println("Customer Info: ");
            System.out.println("Full Name: " + Client.getName() + " " + Client.getSurname());
            System.out.println("Email: " + Client.getEmail());
            System.out.println("Phone Number: " + Client.getPhoneNumber());
            System.out.println("ID: " + Client.getId());
            System.out.println("----------------------------------------");
            System.out.println("Room Info      : " + Room.getRoomDetails());
            System.out.println("Days to stay   : " + StayDays);
            System.out.println("Room Price     : " + Room.CalculatePrice(StayDays) + " TL");

            if (!extraServices.isEmpty()) {
                System.out.println("--- Extras ---");
                for (RoomService s : extraServices) {
                    System.out.println(" * " + s.getServiceName() + " : " + s.getServicePrice() + " TL");
                }
            }

            System.out.println("----------------------------------------");
            System.out.println("Total Amount   : " + TotalPrice + " TL");
            System.out.println("----------------------------------------\n");
        }
    }

    public double getTotalPrice() {
        return TotalPrice;
    }
}