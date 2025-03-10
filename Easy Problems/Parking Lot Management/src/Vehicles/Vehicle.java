package Vehicles;

public abstract class Vehicle {
    protected VehicleType vehicleType;
    protected String licensePlate;

    Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public VehicleType getType() {
        return vehicleType;
    }

    public String getLicencePlate() {
        return licensePlate;
    }

    public boolean equals(Vehicle vehicle) {
        return getLicencePlate().equals(vehicle.getLicencePlate());
    }
}
