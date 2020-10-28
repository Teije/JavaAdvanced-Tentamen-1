package nl.inholland.oefententamen.TeijeVanHemert.dto;

public class CarDTO
{
    private String brand;
    private long driverId;

    public CarDTO(String brand, long driverId)
    {
        this.brand = brand;
        this.driverId = driverId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
}
