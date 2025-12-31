public class NormalRoom extends Rooms {

    public NormalRoom(int RoomNumber) {

        super(RoomNumber, Prices.NORMAL_ROOM_PRICE);
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