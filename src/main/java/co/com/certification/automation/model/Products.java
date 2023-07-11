package co.com.certification.automation.model;

public class Products {
    private int position;
    private int amount;
    private String nameOfProduct;

    private double price;

    public Products(int position, int amount) {
        this.position = position;
        this.amount = amount;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPosition() {
        return position;
    }

    public int getAmount() {
        return amount;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public double getPrice() {
        return price;
    }
}
