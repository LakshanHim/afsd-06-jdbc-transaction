package lk.ACPT.tm;

public class ItemTM {
    private String brand;
    private String model;
    private int qty;
    private double UnitPrice;
    private double total;

    public String getBrand() {
        return brand;
    }

    public ItemTM(String brand, String model, int qty, double unitPrice, double total) {
        this.brand = brand;
        this.model = model;
        this.qty = qty;
        this.UnitPrice = unitPrice;
        this.total = total;
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

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
