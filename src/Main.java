import Productions.Category;
import Productions.Product;
import auth.Initialization;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Initialization initialization = new Initialization();
        initialization.initialization();
        shop();

// max wirbelwind
    }

    public static void shop() {
        Scanner sc = new Scanner(System.in);
        Product product1 = new Product("MB          1", "W124", "black", 200, 4000);
        Product product2 = new Product("MB          2", "W210", "white", 230, 8000);
        Product product3 = new Product("MB          3", "W211", "blue", 250, 12000);
        Product product4 = new Product("MB          4", "W221", "pink", 300, 20000);
        Product product5 = new Product("Lada          5", "Sedan", "Baklazhan", 45, 1200);
        Product product6 = new Product("Lada          6", "четырка", "Синий", 100, 1000);
        Product product7 = new Product("Lada          7", "семерка", "Красный", 80, 1200);
        Product product8 = new Product("Lada          8", "шестерка", "черный", 60, 1500);
        Product[] products = {product1, product2, product3, product4, product5, product6, product7, product8};
        Category categoryMB = new Category("Mercedes-benz", new Product[]{product1, product2, product3, product4});
        Category categoryLada = new Category("Lada", new Product[]{product5, product6, product7, product8});

        Category[] categories = {categoryMB, categoryLada};
        boolean isActive = true;
        Product[] garage = new Product[10];
        int num1 = 0;
        while (isActive) {
            System.out.println("что бы вывести список категории нажмите 1\nЧто бы выйти нажми 2");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Введите цифру для выбора");
                int i = 0;
                for (Category c : categories) {
                    i++;
                    System.out.println("\n" +i + ": " + c.getName());
                }
                int choiceP = sc.nextInt();
                //-------------------
                while (isActive) {
                    switch (choiceP) {
                        case 1 -> System.out.println(categoryMB.toString() + "\n");
                        case 2 -> System.out.println(categoryLada.toString() + "\n");
                        default -> System.out.println("введите от 1 до 2");
                    }

                    System.out.println("Под каким номером хотите взять продукт");
                    int choiceProduct = sc.nextInt();
                    System.out.println("Вы набрали: " + num1);
                    switch (choiceProduct) {
                        case 1 -> System.out.println(products[0]);
                        case 2 -> System.out.println(products[1]);
                        case 3 -> System.out.println(products[2]);
                        case 4 -> System.out.println(products[3]);
                        case 5 -> System.out.println(products[4]);
                        case 6 -> System.out.println(products[5]);
                        case 7 -> System.out.println(products[6]);
                        case 8 -> System.out.println(products[7]);
                        default -> System.out.println("FU");
                    }
                    garage[num1] = products[choiceProduct-1];
                    num1++;
                    System.out.println("\nХотите продолжить (y) или хотит закончить покупки (n)");
                    while (isActive) {
                        String choiceForContinue = sc.nextLine();
                        if (choiceForContinue.equalsIgnoreCase("n")) {
                            isActive = false;
                        } else if (choiceForContinue.equalsIgnoreCase("y")) {
                            break;
                        }
                    }
                    System.out.println();
                }
            }
        }
        for (Product gara: garage) {
            if (gara==null) {
            } else {
                System.out.println(gara);
            }
        }
    }
}