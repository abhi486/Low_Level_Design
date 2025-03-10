import Vehicles.Car;
import Vehicles.MotorCycle;
import Vehicles.Truck;
import Vehicles.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(10);

        Vehicle car = new Car("123456");
        Vehicle bike = new MotorCycle("980876");
        Vehicle truck = new Truck("8765469");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bike);
        parkingLot.parkVehicle(truck);

        parkingLot.displayAvailability();

        parkingLot.unParkVehicle(car);

        parkingLot.displayAvailability();
    }
}
