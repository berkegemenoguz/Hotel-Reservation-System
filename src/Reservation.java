import java.util.ArrayList;

public class Reservation {
    private final Customer Client;
    private final Rooms Room;
    private int StayDays;
    private double TotalPrice;
    private final String RoomCode;

    private final ArrayList<ExtraService> additional;

    public Reservation(Customer Client, Rooms Room, int stayDays) {
        this.RoomCode = findRoomCode(Room);

        if (CSVManager.isRoomOccupied(RoomCode)) {
            throw new IllegalStateException("Room " + Room.getRoomNumber() + " is already occupied.\n");
        }

        this.Client = Client;
        this.Room = Room;
        this.StayDays = stayDays;

        this.TotalPrice = Room.CalculatePrice(stayDays);

        this.additional = new ArrayList<>();

        CSVManager.setRoomOccupied(RoomCode, true);
        System.out.println("\nReservation Created for " + Client.getName() + " " + Client.getSurname());
    }

    private String findRoomCode(Rooms room) {
        if (room == RoomManager.N101)
            return "N101";
        if (room == RoomManager.N102)
            return "N102";
        if (room == RoomManager.N103)
            return "N103";
        if (room == RoomManager.N104)
            return "N104";
        if (room == RoomManager.N105)
            return "N105";
        if (room == RoomManager.N106)
            return "N106";
        if (room == RoomManager.N107)
            return "N107";
        if (room == RoomManager.N108)
            return "N108";
        if (room == RoomManager.S201)
            return "S201";
        if (room == RoomManager.S202)
            return "S202";
        return "UNKNOWN";
    }


    public void addService(ExtraService service) {
        if (this.Client != null) {
            this.additional.add(service);
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

            if (!additional.isEmpty()) {
                System.out.println("--- Extras ---");
                for (ExtraService s : additional) {
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

    public Customer getClient() {
        return Client;
    }

    public Rooms getRoom() {
        return Room;
    }

    public int getStayDays() {
        return StayDays;
    }

    public ArrayList<ExtraService> getAdditionalServices() {
        return additional;
    }

    public void saveToCSV() {
        CSVManager.saveReservation(Client, Room, StayDays, additional, TotalPrice);
    }

}