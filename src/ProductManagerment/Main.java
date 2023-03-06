package ProductManagerment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        do {
            System.out.printf("Menu:\n" +
                    "1. Input Product Info. \n" +
                    "2. Calculate Export Price. \n" +
                    "3. Display Products Info. \n" +
                    "4. Sort Ascending for Products. \n" +
                    "5. Find by Product Name. \n" +
                    "6. Summary Product with quantity <5: \n" +
                    "7. Update Product's Status by ID\n" +
                    "8. Exit....\n");
            System.out.print("\nPlease select option: ");
            option = input.nextInt();

            if (option != 8) {
                switch (option) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Select option invalid, please select againt!!!");
                        break;
                }
            }
        } while (option != 8);
    }


    //1. Options
    private static Product[] inputProductsInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number for n Products: ");
        int size = input.nextInt();
        Product[] productsArray = new Product[size];
        for (int i = 0; i < productsArray.length; i++) {
            System.out.printf("Enter Info for product %d\n", (i + 1));
            productsArray[i] = new Product();
            productsArray[i].inputData();
            productsArray[i].calExportPrice();
        }
        return productsArray;
    }

    public static void displayProductsTable(Product[] productsArray) {
        System.out.println("Products List: ");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                "ID", "Product Name", "Title", "Description",
                "Quantity", "Import Price", "Export Price", "Status");
        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].displayData();
        }
    }
}
