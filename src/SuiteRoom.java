public class SuiteRoom extends Rooms {


    public SuiteRoom(int RoomNumber) {
        super(RoomNumber, Prices.SUITE_ROOM_PRICE);
    }

    @Override
    public double CalculatePrice(int Days){
        return (getNormalPrice() * Days);
    }

    @Override
    public String getRoomDetails() {
        return "Suite Room ==> Room No: " + getRoomNumber();
    }
}