public class Reservation {
    private Customer Client;
    private Rooms Room;
    private int StayDays;
    private double TotalPrice;

    public Reservation(Customer Client, Rooms Room, int stayDays) {

        if (Room.isOccupied()) {
            System.out.println("Warning: " + "Room" + " " + Room.getRoomNumber() + " is full.");
        } else {

            this.Client = Client;
            this.Room = Room;
            this.StayDays = stayDays;
            this.TotalPrice = Room.CalculatePrice(stayDays);

            Room.setOccupied(true);

            System.out.println("\nReservation Created.");
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
            System.out.println("Room Info     : " + Room.getRoomDetails());
            System.out.println("Days to stay  : " + StayDays );
            System.out.println("Total Amount  : " + TotalPrice + " TL");
            System.out.println("----------------------------------------\n");

        }
    }

}