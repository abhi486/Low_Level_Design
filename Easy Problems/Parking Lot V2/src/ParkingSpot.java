public class ParkingSpot {
    final int spotNumber;
    final VehicleType spotType;
    Vehicle parkedVehicle;
    boolean isAvailable;

    ParkingSpot(int spotNumber, VehicleType spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        parkedVehicle = null;
        isAvailable = true;
    }

    int getSpotNumber() { return spotNumber; }
    VehicleType getSpotType() { return spotType; }
    Vehicle getParkedVehicle() { return parkedVehicle; }

    synchronized boolean parkVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType() != spotType) {
            System.out.println("Wrong Spot! Can't park vehicle.");
        }
        if (!isAvailable) {
            System.out.println("Spot is not available!");
            return false;
        }

        parkedVehicle = vehicle;
        isAvailable = false;
        return true;
    }

    synchronized boolean removeVehicle() {
        parkedVehicle = null;
        isAvailable = true;

        return true;
    }

}
