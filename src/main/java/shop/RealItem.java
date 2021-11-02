package shop;

public class RealItem extends Item {

    public RealItem(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    public RealItem(){}

    private double weight;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return super.toString() + "Weight: " + weight;
    }
}
