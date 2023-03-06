package ProductManagerment;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        System.out.println("Please Initial Array length before select option!!!");
        System.out.print("Enter Number for n Products: ");
        int size = input.nextInt();
        Product[] productsArray = new Product[size];
        boolean inputStatus = false;
        do {
            System.out.printf("Menu:\n" +
                    "1. Input Product Info. \n" +
                    "2. Calculate Export Price. \n" +
                    "3. Display Products Info. \n" +
                    "4. Sort Ascending for Products Price. \n" +
                    "5. Find by Product Name. \n" +
                    "6. Summary Product with quantity <5: \n" +
                    "7. Update Product's Status by ID\n" +
                    "8. Exit....\n");
            System.out.print("\nPlease select option: ");
            option = input.nextInt();
            if (option != 8) {
                if (!inputStatus && option != 1) {
                    System.out.println("Product List is Empty, please input Product List before take other actions");
                } else {
                    switch (option) {
                        case 1:
                            if (!inputStatus) {
                                inputProductsInfo(productsArray);
                                inputStatus = true;
                            } else {
                                System.out.println("Product List already exist");
                            }
                            break;
                        case 2:
                            calExportPrice(productsArray);
                            break;
                        case 3:
                            displayProductsTable(productsArray);
                            break;
                        case 4:
                            sortAscendingPrice(productsArray);
                            break;
                        case 5:
                            sortByName(productsArray);
                            break;
                        case 6:
                            outOfQuantity(productsArray);
                            break;
                        case 7:
                            updateStatusProduct(productsArray);
                            break;
                        default:
                            System.out.println("Select option invalid, please select again!!!");
                            break;
                    }
                }
            }
        } while (option != 8);
    }


    //1. Options 1
    public static void inputProductsInfo(Product[] productsArray) {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter Number for n Products: ");
        int size = input.nextInt();
        Product[] productsArray = new Product[size];*/
        for (int i = 0; i < productsArray.length; i++) {
            System.out.printf("Enter Info for product %d\n", (i + 1));
            productsArray[i] = new Product();
            productsArray[i].inputData();
            productsArray[i].calExportPrice();
        }
    }

    //Option 2
    public static void calExportPrice(Product[] productsArray) {
        for (int i = 0; i < productsArray.length; i++) {
            String name = productsArray[i].getProductName();
            float exportPrice = productsArray[i].getExportPrice();
            System.out.printf("Export Price of %s is %.2f\n", name, exportPrice);
        }
    }

    //Option 3
    public static void displayProductsTable(Product[] productsArray) {
        System.out.println("Products List: ");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                "ID", "Product Name", "Title", "Description",
                "Quantity", "Import Price", "Export Price", "Status");
        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].displayData();
        }
    }

    //Option 4
    public static void sortAscendingPrice(Product[] productsArray) {
        Product[] sortProductArray = cloneArray(productsArray);
        for (int i = 0; i < sortProductArray.length; i++) {
            for (int j = 0; j < sortProductArray.length; j++) {
                if (sortProductArray[j].getImportPrice()>sortProductArray[i].getImportPrice()) {
                    Product temp = sortProductArray[j];
                    sortProductArray[j] = sortProductArray[i];
                    sortProductArray[i] = temp;
                }
            }
        }
        displayProductsTable(sortProductArray);
    }

    //Option 5-pending
    public static void sortByName(Product[] productsArray) {
        Product[] sortProductArray = cloneArray(productsArray);
        for (int i = 0; i < sortProductArray.length; i++) {
            for (int j = 0; j < sortProductArray.length; j++) {
                char charJ = sortProductArray[j].getProductName().charAt(0);
                char charI = sortProductArray[i].getProductName().charAt(0);
                int checkResult = Character.compare(charJ, charI);
                if (checkResult > 0) {
                    Product temp = sortProductArray[j];
                    sortProductArray[j] = sortProductArray[i];
                    sortProductArray[i] = temp;
                }
            }
        }
        displayProductsTable(sortProductArray);
    }

    //Option 6
    public static void outOfQuantity(Product[] productsArray) {
        int count = 0;
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i].getQuantity() < 5) {
                count++;
            }
        }
        Product[] sortProductArray = new Product[count];
        int index = 0;
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i].getQuantity() < 5) {
                sortProductArray[index] = productsArray[i];
                index++;
            }
        }
        displayProductsTable(sortProductArray);
    }

    //Option 7
    public static void updateStatusProduct(Product[] productsArray) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        String id = input.nextLine();
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i].getProductID().equals(id)) {
                boolean newStatus = productsArray[i].getProductStatus() ? false : true;
                productsArray[i].setProductStatus(newStatus);
            }
        }
        System.out.println("Product list after update status: ");
        displayProductsTable(productsArray);
    }

    //Extra
    public static Product[] cloneArray(Product[] productsArray) {
        Product[] sortProductArray = new Product[productsArray.length];
        for (int i = 0; i < sortProductArray.length; i++) {
            sortProductArray[i] = productsArray[i];
        }
        return sortProductArray;
    }
}
