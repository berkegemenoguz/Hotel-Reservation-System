
public abstract class Rooms implements Bookings{

    private int RoomNumber;
    private double NormalPrice;
    private boolean isOccupied;

    public Rooms(int RoomNumber, double NormalPrice){

        this.NormalPrice = NormalPrice;
        this.RoomNumber = RoomNumber;
        this.isOccupied = false;

        }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public double getNormalPrice() {
        return NormalPrice;
    }

    public void setNormalPrice(double normalPrice) {
        NormalPrice = normalPrice;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }


    // Kod okunabilirliği için
    @Override
    public abstract double CalculatePrice(int Days);

    @Override
    public abstract String getRoomDetails();

}
