package testData;

import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class TestData {

    public static Cart testCart = new Cart("test-cart");
    public static RealItem testRealItem = new RealItem();
    public static VirtualItem testVirtualItem = new VirtualItem();

    public static Cart createTestCart(String cartName){
        testRealItem.setName("Audi");
        testRealItem.setPrice(32026.9);
        testRealItem.setWeight(1560.0);

        testVirtualItem.setName("Windows");
        testVirtualItem.setPrice(11.0);
        testVirtualItem.setSizeOnDisk(20000.0);

        testCart.addRealItem(testRealItem);
        testCart.addVirtualItem(testVirtualItem);
        return testCart;
    }


    public static RealItem createRealItem(){
        RealItem realItem = new RealItem();
        realItem.setName("Audi");
        realItem.setPrice(32026.9);
        realItem.setWeight(1560);
        return realItem;
    }

    public static VirtualItem createVirtualItem(){
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName("Audi");
        virtualItem.setPrice(32026.9);
        virtualItem.setSizeOnDisk(1560);
        return virtualItem;
    }

}
