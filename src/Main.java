import Productions.Category;
import Productions.Product;
import auth.Initialization;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Category[] categories;
    static Category categoryMB, categoryLada;
    static Product[] products, garage;
    static int selectedProduct, countCarsInGarage = 1;

    public static void main(String[] args) {
        if (new Initialization().initialization()) {
            System.out.println("----- StoreCar -----");
            initShop();
        } else System.exit(0);
    }

    static void assortment() {
        // Products:
        Product product1 = new Product("MB - 1", "W124", "black", 200, 4000);
        Product product2 = new Product("MB - 2", "W210", "white", 230, 8000);
        Product product3 = new Product("MB - 3", "W211", "blue", 250, 12000);
        Product product4 = new Product("MB - 4", "W221", "pink", 300, 20000);
        Product product5 = new Product("Lada - 5", "Sedan", "Baklazhan", 45, 1200);
        Product product6 = new Product("Lada - 6", "четырка", "Синий", 100, 1000);
        Product product7 = new Product("Lada - 7", "семерка", "Красный", 80, 1200);
        Product product8 = new Product("Lada - 8", "шестерка", "черный", 60, 1500);

        // All car products in array:
        products = new Product[]{product1, product2, product3, product4, product5, product6, product7, product8};

        // Car category:
        categoryMB = new Category("Mercedes-benz", new Product[]{product1, product2, product3, product4});
        categoryLada = new Category("Lada", new Product[]{product5, product6, product7, product8});
        categories = new Category[]{categoryMB, categoryLada};

        // Garage (basket):
        garage = new Product[10];
    }

    static void initShop() {
        assortment();
        System.out.println("1. Category list\n2. Exit");
        switch (tryBlock("Choose an action", 2)) {
            case 1 -> selectCategory();
            case 2 -> System.exit(0);
            default -> errors(2);
        }
    }

    static void selectCategory() {
        System.out.print("----------");
        int i = 0;
        for (Category category : categories) {
            i++;
            System.out.printf("\n%d: %s", i, category.getName());
        }
        System.out.println("\n----------");
        switch (tryBlock("Select category", 2)) {
            case 1 -> System.out.println(categoryMB.toString()
            .replace("[", "").replace("]", "").replace(",", "") + "\n");
            case 2 -> System.out.println(categoryLada.toString()
            .replace("[", "").replace("]", "").replace(",", "") + "\n");
            default -> errors(2);
        }
        switch (selectedProduct = tryBlock("Select product",
            categoryMB.getCars().length + categoryLada.getCars().length)) {
            case 1 -> System.out.println(products[0]);
            case 2 -> System.out.println(products[1]);
            case 3 -> System.out.println(products[2]);
            case 4 -> System.out.println(products[3]);
            case 5 -> System.out.println(products[4]);
            case 6 -> System.out.println(products[5]);
            case 7 -> System.out.println(products[6]);
            case 8 -> System.out.println(products[7]);
            default -> errors(2);
        }
        System.out.printf("----------\nCount cars in your garage: %d\n----------", countCarsInGarage);
        garage[countCarsInGarage] = products[selectedProduct - 1];
        countCarsInGarage++;
        System.out.println("\nRepeat operation?\n1. Yes\n2. No");
        switch (tryBlock("Choose an action", 2)) {
            case 1 -> selectCategory();
            case 2 -> {
                System.out.print("\nIn your garage:");
                for (Product garages: garage) {
                    if (garages != null) System.out.println(garages);
                }
                System.exit(0);
            }
            default -> errors(2);
        }
    }

    static int tryBlock(String message, int to) {
        int dialog;
        while (true) {
            try {
                System.out.printf("• %s: ", message);
                dialog = scanner.nextInt();
                if (dialog < 1 || dialog > to) errors(1);
                else return dialog;
            } catch (java.util.InputMismatchException e) {
                errors(1);
                scanner.nextLine();
            }
        }
    }

    static void errors(int status) {
        if (status == 1) System.out.println("[!] Incorrect value.");
        else if (status == 2) {
            System.out.println("[!] Unknown error.");
            System.exit(0);
        } else System.out.println("[!] Incorrect system value.");
    }
}