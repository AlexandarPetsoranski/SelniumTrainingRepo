package shop;

public class VirtualItem extends Item {

    public VirtualItem(String name, double price, double sizeOnDisk) {
        super(name, price);
        this.sizeOnDisk = sizeOnDisk;
    }

    public VirtualItem(){}

    private double sizeOnDisk;

    public void setSizeOnDisk(double sizeOnDisk) {
        this.sizeOnDisk = sizeOnDisk;
    }

    public double getSizeOnDisk() {
        return this.sizeOnDisk;
    }

    @Override
    public String toString() {
        return super.toString() + "Size on disk: " + sizeOnDisk;
    }
}
