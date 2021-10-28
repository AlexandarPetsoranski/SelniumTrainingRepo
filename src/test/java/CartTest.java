import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;
import testData.TestData;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class CartTest extends BaseSpec{

    @Test
    @DisplayName("Test cart is created successfully")
    void givenMultipleAssertion_whenAssertingAll_thenOK() {
        Cart cart = TestData.createTestCart("test-cart");

        List<RealItem> actualRealItems = cart.getRealItems();
        List<RealItem> expectedRealItems = List.of(
                new RealItem("Audi",32026.9,1560.0));

        List<VirtualItem> actualVirtualItems = cart.getVirtualItems();
        List<VirtualItem> expectedVirtualItems = List.of(
                new VirtualItem("Windows",11.0,20000.0));

        String expectedName = cart.getCartName();
        String actualName = "test-cart";

        double actualPrice = cart.getTotalPrice();
        double expectedPrice = 38445.479999999996;

        System.out.println(actualRealItems + "\n" + expectedRealItems);

        assertAll(
                "Cart created successfully if",
                () -> Assert.assertEquals(expectedRealItems.size(), actualRealItems.size()),
                () -> Assert.assertEquals(actualVirtualItems.size(),expectedVirtualItems.size()),
                () -> Assert.assertEquals(expectedName,actualName),
                () -> Assert.assertEquals(actualPrice,expectedPrice)
        );    }

    @Test
    @DisplayName("Test getCartName functionality")
    void getCartName_TestCart1() {
        Cart cart = new Cart("TestCart1");
        String actualResult = cart.getCartName();
        String expectedResult = "TestCart1";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    @DisplayName("Test getTotalPrice functionality")
    void getTotalPrice_priceFromAllVirtualAndRealItems() {
        Cart cart = TestData.createTestCart("Test cart2");
        double actualPrice = cart.getTotalPrice();
        double expectedPrice = 38445.479999999996;
        Assert.assertEquals(actualPrice, expectedPrice);
    }
}
