public class Main {
    public static void main(String[] args) {
        System.out.println("\n---Hotel System is Launching---");

        Customer musteri1 = new Customer(1, "Ahmad", "Gurkan", "ahmadgurkan@gmail.com", "111");
        Rooms oda201 = new SuiteRoom(201, 3000.0);

        Customer musteri2 = new Customer(2, "Mr Worldwide", "DJ Snake", "snake@gmail.com","212121");
        Rooms oda101 = new NormalRoom(101, 1500);

        RoomService gym = new RoomService("Gym Membership", 300);
        RoomService valet = new RoomService("Vale Service", 300);
        RoomService extraBed = new RoomService("Extra Bed", 750);
        RoomService transfer = new RoomService("Airport Transportation", 1200);
        RoomService minibar = new RoomService("Minibar", 300);
        RoomService spa = new RoomService("Spa Session" , 500);

        Reservation r1 = new Reservation(musteri1, oda201, 3);

        Reservation r2 = new Reservation(musteri2 , oda101 , 2);

        r1.addService(gym);
        r1.addService(valet);
        r1.addService(transfer);
        r1.addService(extraBed);
        r1.addService(spa);

        r2.addService(gym);
        r2.addService(transfer);
        r2.addService(minibar);

        r2.prd();
        r1.prd();
    }
}