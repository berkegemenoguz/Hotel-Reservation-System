public class Main {
    public static void main(String[] args) {

        System.out.println("\n---Hotel System is Launching---\n");


        Customer musteri1 = new Customer(1, "Ahmad", "Gurkan", "0555-111-2233", "ahmet@ornek.com");
        Customer musteri2 = new Customer(2, "Zeynep", "Kaya", "0555-444-5566", "zeynep@ornek.com");


        Rooms oda101 = new NormalRoom(101, 1000.0);
        Rooms oda201 = new SuiteRoom(201, 3000.0);


        Reservation r1 = new Reservation(musteri1, oda201, 3);
        r1.prd();


        System.out.println("\n------New Reservation-------\n");
        Reservation r3 = new Reservation(musteri2, oda101, 5);
        r3.prd();
    }
}