import Vehicles.Vehicle;
import Vehicles.VehicleType;

class ParkingSpot {
    private final int spotNumber;
    private final VehicleType spotType;
    private Vehicle parkedVehicle;

    ParkingSpot(int spotNumber, VehicleType spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
    }

    int getSpotNumber() {
        return spotNumber;
    }

    VehicleType getSpotType() {
        return spotType;
    }

    synchronized Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    synchronized boolean parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getType() == spotType) {
            parkedVehicle = vehicle;
        }
        else {
            throw new IllegalArgumentException("Either spot is not available or wrong vehicle type");
        }

        return true;
    }

    synchronized void unParkVehicle() {
        parkedVehicle = null;
    }
}
