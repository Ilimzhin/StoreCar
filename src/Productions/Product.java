package Productions;

public class Product {
    private String mark;
    private String model;
    private String carBody;
    private int maxSpeed;

    public Product(String mark, String model, String carBody, int maxSpeed) {
        this.mark = mark;
        this.model = model;
        this.carBody = carBody;
        this.maxSpeed = maxSpeed;
    }

    public Product() {
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarBody() {
        return carBody;
    }

    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
