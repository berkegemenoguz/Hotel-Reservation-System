public class Main {
    public static void main(String[] args) {
        System.out.println("\n---Hotel System is Launching---");

        Customer musteri1 = new Customer(1, "Ahmad", "Gurkan", "111-222-333", "ahmet@ornek.com");
        Rooms oda201 = new SuiteRoom(201, 3000.0);




        RoomService gym = new RoomService("Gym Membership", 500);
        RoomService valet = new RoomService("Vale Service", 200);
        RoomService extraBed = new RoomService("Extra Bed", 750);
        RoomService transfer = new RoomService("Airport Transportation", 1200);

        Reservation r1 = new Reservation(musteri1, oda201, 3);

        r1.addService(gym);
        r1.addService(valet);
        r1.addService(transfer);
        r1.addService(extraBed);

        r1.prd();
    }
}