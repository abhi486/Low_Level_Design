import Vehicles.Vehicle;
import Vehicles.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int level;
    private List<ParkingSpot> parkingSpotList;

    Level(int level, int numberOfSpots) {
        this.level = level;
        parkingSpotList = new ArrayList<>(numberOfSpots);

        int numberOfCar = (int) (numberOfSpots * 0.5);
        int numberOfMotorCycle = (int) (numberOfSpots * 0.4);
        int numberOfTrucks = numberOfSpots - (numberOfCar + numberOfMotorCycle);

        int i = 0;
        while (numberOfCar-- > 0) {
            addSpot(i, VehicleType.CAR);
            i++;
        }
        while (numberOfMotorCycle-- > 0) {
            addSpot(i, VehicleType.MOTORCYCLE);
            i++;
        }
        while (numberOfTrucks-- > 0) {
            addSpot(i, VehicleType.TRUCK);
        }
    }

    public synchronized void addSpot(int spotNumber, VehicleType vehicleType) {
        parkingSpotList.add(new ParkingSpot(spotNumber, vehicleType));
    }

    public int getLevel() {
        return level;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpotList) {
            if (spot.isAvailable() && vehicle.getType() == spot.getSpotType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }

        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpotList) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unParkVehicle();
                return true;
            }
        }

        return false;
    }

    public void displayAvailability() {
        System.out.println("Level: " + level);
        for (ParkingSpot spot : parkingSpotList) {
            System.out.println("Spot Number: " + spot.getSpotNumber() + ", Spot Type: " + spot.getSpotType() + ", Spot Availability: " + spot.isAvailable());
        }
    }
}
