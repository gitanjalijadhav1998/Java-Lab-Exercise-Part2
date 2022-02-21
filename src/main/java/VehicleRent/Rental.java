package VehicleRent;

public class Rental {
    private String customer_Name;
    private String start_date;
    private String end_date;
    private int number_of_days;
    private int identification_code;
    private Vehicle vehicle;

    public Rental(String customer_Name, String start_date, String end_date, int number_of_days, int identification_code, Vehicle vehicle) {
        this.customer_Name = customer_Name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.number_of_days = number_of_days;
        this.identification_code = identification_code;
        this.vehicle = vehicle;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public int getNumber_of_days() {
        return number_of_days;
    }

    public int getIdentification_code() {
        return identification_code;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setNumber_of_days(int number_of_days) {
        this.number_of_days = number_of_days;
    }

    public void setIdentification_code(int identification_code) {
        this.identification_code = identification_code;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
