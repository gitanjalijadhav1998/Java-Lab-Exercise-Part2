package VehicleRent;

public class Vehicle {
    private long identificationCode;
    private String brand;
    private String model;
    private int numberOfSeat;
    private String licensePlate;

    public Vehicle(long identificationCode, String brand, String model, int numberOfSeat, String licensePlate) {
        this.identificationCode = identificationCode;
        this.brand = brand;
        this.model = model;
        this.numberOfSeat = numberOfSeat;
        this.licensePlate = licensePlate;
    }

    //Getter methods.
    public long getIdentificationCode() {
        return identificationCode;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
