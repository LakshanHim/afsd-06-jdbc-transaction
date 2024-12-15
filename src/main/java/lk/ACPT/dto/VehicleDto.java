package lk.ACPT.dto;

public class VehicleDto {
    private int id;
    private String brand;
    private String model;
    private int qty;
    private Double price;

    public VehicleDto() {
    }

    public VehicleDto(String brand, String model, int qty, Double price) {
        this.brand = brand;
        this.model = model;
        this.qty = qty;
        this.price = price;
    }

    public VehicleDto(int id, String brand, String model, int qty, Double price) {
        this.id = id;
        this.price = price;
        this.qty = qty;
        this.model = model;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
