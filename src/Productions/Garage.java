package Productions;

import java.util.Arrays;

public class Garage {
    private Product[] cars;

    public Garage(Product[] cars) {
        this.cars = cars;
    }

    public Garage() {
    }

    public Product[] getCars() {
        return cars;
    }

    public void setCars(Product[] cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "\nGarage: " +
                "\ncars: " + Arrays.toString(cars);
    }
}
