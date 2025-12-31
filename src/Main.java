public class Main {
    public static void main(String[] args) {
        System.out.println("\n---Hotel System is Launching---");

        Customer musteri1 = new Customer(1, "Ahmad", "Gurkan", "ahmadgurkan@gmail.com", "111");
        Rooms oda201 = new SuiteRoom(201);

        Customer musteri2 = new Customer(2, "Mr Worldwide", "DJ Snake", "snake@gmail.com","212121");
        Rooms oda101 = new NormalRoom(101);

        Customer musteri3 = new Customer(3, "Vadaa", "Morogullari", "Vadaa@gmail.com", "3321");

        try {
            Reservation r1 = new Reservation(musteri1, oda201, 3);
            Reservation r2 = new Reservation(musteri2, oda101, 2);

            r1.addService(ExtraServiceRegister.GYM);
            r1.addService(ExtraServiceRegister.VALET);

            r2.addService(ExtraServiceRegister.AIRPORT_TRANSFER);
            r2.addService(ExtraServiceRegister.SPA);

            r2.prd();
            r1.prd();





        } catch (IllegalStateException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}