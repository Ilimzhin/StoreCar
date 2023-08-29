package Productions;

import java.util.Arrays;

public class Category {
    private String name;
    private Product[] cars;

    public Category(String name, Product[] cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product[] getCars() {
        return cars;
    }

    public void setCars(Product[] cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "\nCategory: " +
                "\nname: " + name +
                "\ncars: " + Arrays.toString(cars);
    }

    public void parseProducts() {
        for (int i = 0; i < cars.length; i++) System.out.printf("%d. %s\n", (i + 1), cars[i].toString());
    }
}
