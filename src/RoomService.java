public class RoomService {

    private String ServiceName;
    private int ServicePrice;

    public RoomService(String serviceName, int servicePrice) {
        ServiceName = serviceName;
        ServicePrice = servicePrice;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public int getServicePrice() {
        return ServicePrice;
    }

    public void setServicePrice(int servicePrice) {
        ServicePrice = servicePrice;
    }
}
