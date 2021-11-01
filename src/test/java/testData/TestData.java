package testData;

import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.util.Random;

public class TestData {

    public static Cart createTestCart(){
        Cart testCart = new Cart(generateRandomString());
        RealItem testRealItem = new RealItem();
        VirtualItem testVirtualItem = new VirtualItem();
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

    public static String generateRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

}
