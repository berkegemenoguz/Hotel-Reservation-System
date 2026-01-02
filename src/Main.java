public class Main {
    public static void main(String[] args) {
        System.out.println("\n---Hotel System is Launching---");

       CSVManager.clearAllData();

        java.io.File roomsFile = new java.io.File("data/rooms.csv");
        if (!roomsFile.exists()) {
            CSVManager.initializeRoomsCSV();
        }

        RoomManager.listAllRooms();

        Customer musteri1 = new Customer(1, "Ahmad", "Gurkan", "ahmadgurkan@gmail.com", "111");
        Customer musteri2 = new Customer(2, "Mr Worldwide", "DJ Snake", "snake@gmail.com","212121");
        Customer musteri3 = new Customer(3, "Vadaa", "Morogullari", "Vadaa@gmail.com", "3321");
        Customer musteri4 = new Customer(4, "Mauro", "icardi","mauroicardi@gmail.com", "1213");

        CSVManager.saveCustomer(musteri1);
        CSVManager.saveCustomer(musteri2);
        CSVManager.saveCustomer(musteri3);
        CSVManager.saveCustomer(musteri4);

        try {
            Reservation r1 = new Reservation(musteri1, RoomManager.S201, 3);
            Reservation r2 = new Reservation(musteri2, RoomManager.N101, 2);
            Reservation r3 = new Reservation(musteri3, RoomManager.N102, 3);
            Reservation r4 = new Reservation(musteri4, RoomManager.S202, 5);

            r1.addService(ExtraServiceRegister.GYM);
            r1.addService(ExtraServiceRegister.VALET);

            r2.addService(ExtraServiceRegister.AIRPORT_TRANSFER);
            r2.addService(ExtraServiceRegister.SPA);

            r3.addService(ExtraServiceRegister.MINIBAR);

            r4.addService(ExtraServiceRegister.SPA);

            r1.saveToCSV();
            r2.saveToCSV();
            r3.saveToCSV();
            r4.saveToCSV();

            r4.prd();
            r3.prd();
            r2.prd();
            r1.prd();


            CSVManager.listReservations();
            RoomManager.listAllRooms();

        } catch (IllegalStateException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}