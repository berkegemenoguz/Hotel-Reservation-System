public class SuiteRoom extends Rooms {


    public SuiteRoom(int RoomNumber, double NormalPrice) {
        super(RoomNumber, NormalPrice);
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