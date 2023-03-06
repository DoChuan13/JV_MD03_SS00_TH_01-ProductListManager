package ProductManagerment;

import java.util.Scanner;

public class Product {
    //Property
    private String productID, productName, title, description;
    private float importPrice, exportPrice;
    private int quantity;
    private boolean productStatus;

    //Constructor
    public Product() {
    }

    public Product(String productID, String productName,
                   String title, String description,
                   float importPrice, float exportPrice,
                   int quantity, boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.title = title;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.productStatus = productStatus;
    }

    //Method

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getProductStatus() {
        return productStatus;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Product Id: ");
        this.setProductID(input.nextLine());
        System.out.print("Enter Product Name: ");
        this.setProductName(input.nextLine());
        System.out.print("Enter Product Title: ");
        this.setTitle(input.nextLine());
        System.out.print("Enter Product Description: ");
        this.setDescription(input.nextLine());
        System.out.print("Enter Import Price: ");
        this.setImportPrice(input.nextFloat());
        System.out.print("Enter Quantity: ");
        this.setQuantity(input.nextInt());
        System.out.print("Enter Product Status (true/false): ");
        this.setProductStatus(input.nextBoolean());
    }

    public void displayData() {
        System.out.printf("%-20s%-20s%-20s%-20s%-20d%-20.2f%-20.2f%-20b\n",
                getProductID(), getProductName(), getTitle(), getDescription(),
                getQuantity(), getImportPrice(), getExportPrice(), getProductStatus());
    }

    public void calExportPrice() {
        float export = (float) (this.importPrice * 1.2);
        this.setExportPrice(export);
    }
}
