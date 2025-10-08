abstract class Vehicle {
    protected String licence;
    protected VehicleType vehicleType;

    Vehicle(String licence, VehicleType vehicleType) {
        this.licence = licence;
        this.vehicleType = vehicleType;
    }

    protected String getLicence() {
        return licence;
    }
    protected VehicleType getVehicleType() {
        return vehicleType;
    }
}
