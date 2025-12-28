public class NormalRoom extends Rooms {

    public NormalRoom(int RoomNumber, double NormalPrice) {

        super(RoomNumber, NormalPrice);
    }

    @Override
    public double CalculatePrice(int Days) {
        return getNormalPrice() * Days;
    }

    @Override
    public String getRoomDetails(){
        return "Normal Room ==> Room No: " + getRoomNumber();
    }
}