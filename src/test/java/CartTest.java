import org.testng.Assert;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;
import testData.TestData;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CartTest extends BaseSpec {


    @Test
    void givenMultipleAssertionWhenAssertingAllThenOK() {
        Cart cart = TestData.createTestCart();
        List<RealItem> actualRealItems = cart.getRealItems();
        List<RealItem> expectedRealItems = List.of(
                new RealItem("Audi", 32026.9, 1560.0));
        List<VirtualItem> actualVirtualItems = cart.getVirtualItems();
        List<VirtualItem> expectedVirtualItems = List.of(
                new VirtualItem("Windows", 11.0, 20000.0));

        double actualPrice = cart.getTotalPrice();
        double expectedPrice = 76864.56;
        System.out.println(actualRealItems + "\n" + expectedRealItems);

        assertAll(
                "Cart created successfully if",
                () -> Assert.assertEquals(expectedRealItems.size(), actualRealItems.size()),
                () -> Assert.assertEquals(actualVirtualItems.size(), expectedVirtualItems.size()),
                () -> Assert.assertEquals(actualPrice, expectedPrice)
        );
    }

    @Test
    void getCartName_TestCart() {
        String expectedCartName  = TestData.generateRandomString();
        Cart cart = new Cart(expectedCartName );

        String actualResult = cart.getCartName();

        Assert.assertEquals(actualResult, expectedCartName);
    }

    @Test
    void getTotalPrice_priceFromAllVirtualAndRealItems() {
        Cart cart = TestData.createTestCart();
        double expectedPrice = 76864.56;

        double actualPrice = cart.getTotalPrice();

        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @Test
    void deleteRealItemRealItemDeleted() {
        Cart cart = new Cart(TestData.generateRandomString());
        RealItem realItem1 = new RealItem("RealItem1", 1, 1);
        RealItem realItem2 = new RealItem("RealItem2", 2, 2);
        cart.addRealItem(realItem1);
        cart.addRealItem(realItem2);

        cart.deleteRealItem(realItem1);

        Assert.assertEquals(cart.getRealItems().size(), 1);
    }
}