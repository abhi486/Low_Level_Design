import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    int numberOfSpots;
    List<ParkingSpot> parkingSpots;
    private static ParkingLot parkingLot;

    private ParkingLot() { parkingSpots = new ArrayList<>(); }

    public static synchronized ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
    /*
    * 50% motor cycle parking
    * 30% car parking
    * 20% truck parking
    * */
    public void Initialize(int numberOfSpots) {
        this.numberOfSpots = numberOfSpots;

        int motorCycleParking = (int)(numberOfSpots * 0.5);
        int carParking = (int) (numberOfSpots * 0.3);
        int truckParking = (int) (numberOfSpots * 0.2);

        int spotNumber = 0;
        for (int i = 0; i < motorCycleParking; i++) {
            parkingSpots.add(new ParkingSpot(spotNumber++, VehicleType.MOTORCYCLE));
        }

        for (int i = 0; i < carParking; i++) {
            parkingSpots.add(new ParkingSpot(spotNumber++, VehicleType.CAR));
        }

        for (int i = 0; i < truckParking; i++) {
            parkingSpots.add(new ParkingSpot(spotNumber++, VehicleType.TRUCK));
        }
    }

    boolean parkVehicle(Vehicle vehicle) {
        for (var parkingSpot : parkingSpots) {
            if (parkingSpot.parkVehicle(vehicle)) {
                return true;
            }
        }
        System.out.println("Parking is full!");
        return false;
    }

    boolean removeVehicle(Vehicle vehicle) {
        for (var parkingSpot : parkingSpots) {
            if (parkingSpot.getParkedVehicle().licence.equals(vehicle.getLicence())) {
                parkingSpot.removeVehicle();
                return true;
            }
        }
        return false;
    }
}
