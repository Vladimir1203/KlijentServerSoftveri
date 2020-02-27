package domain;

/**
 *
 * @author stackOverflow
 */

public class Vehicle {
    private String brand;
    private String vehicleType;

    public Vehicle(String brand, String vehicleType) {
        this.brand = brand;
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    
}
