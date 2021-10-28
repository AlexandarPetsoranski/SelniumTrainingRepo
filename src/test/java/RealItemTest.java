import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import shop.RealItem;

public class RealItemTest extends BaseSpec{
    RealItem realItem = new RealItem();

    @Test
    @DisplayName("Test setName functionality")
    void realItemSetName_NameIsSetProperly() {
        String expectedName = "SKODA";
        realItem.setName("SKODA");
        String actualName = realItem.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    @DisplayName("Test setPrice functionality")
    void realItemSetPrice_PriceIsSetProperly() {
        Double expectedPrice = 20.0;
        realItem.setPrice(20.0);
        Double actualPrice = realItem.getPrice();

        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    @DisplayName("Test setWeight functionality")
    void realItemSetWeight_WeightIsSetProperly() {
        Double expectedWeight= 123344.0;
        realItem.setWeight(123344.0);
        Double actualWeight = realItem.getWeight();

        Assert.assertEquals(expectedWeight, actualWeight);
    }
}
