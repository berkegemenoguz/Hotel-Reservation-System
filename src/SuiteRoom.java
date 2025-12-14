public class SuiteRoom extends Rooms {

    private double ServiceFee;

    public SuiteRoom(int RoomNumber, double NormalPrice, double ServiceFee) {
        super(RoomNumber, NormalPrice);
        this.ServiceFee = ServiceFee;
    }

    @Override
    public double CalculatePrice(int Days){
        return (getNormalPrice() * Days) + ServiceFee;
    }

    @Override
    public String getRoomDetails() {
        return "Lüks Suit Oda (VIP) - No: " + getRoomNumber();
    }
}