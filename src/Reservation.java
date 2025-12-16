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

            System.out.println("Reservation Created.");
        }
    }

}