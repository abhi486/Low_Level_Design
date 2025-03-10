import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private static volatile ParkingLot parkingLot;
    List<Level> levels;
    int totalLevels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            synchronized (ParkingLot.class) {
                if (parkingLot == null) {
                    parkingLot = new ParkingLot();
                }
            }
        }

        return parkingLot;
    }

    public synchronized void addLevel(int numberOfSpots) {
        totalLevels++;
        levels.add(new Level(totalLevels, numberOfSpots));
    }

    public synchronized void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Vehicle Parked successfully");
                return true;
            }
        }

        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unParkVehicle(vehicle)) {
                System.out.println("Vehicle unparked successfully");
                return true;
            }
        }

        return false;
    }
}
