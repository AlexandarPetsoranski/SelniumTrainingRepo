import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import shop.VirtualItem;

public class VirtualItemTest extends BaseSpec{
    VirtualItem virtualItem = new VirtualItem();

    @Test
    @DisplayName("Test setName functionality")
    void virtualItemSetName_NameIsSetProperly() {
        String expectedName = "SKODA";
        virtualItem.setName("SKODA");
        String actualName = virtualItem.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    @DisplayName("Test setPrice functionality")
    void virtualItemSetPrice_PriceIsSetProperly() {
        Double expectedPrice = 20.0;
        virtualItem.setPrice(20.0);
        Double actualPrice = virtualItem.getPrice();

        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    @DisplayName("Test setWeight functionality")
    void virtualItemSetWeight_WeightIsSetProperly() {
        Double expectedSizeOnDisk= 123344.0;
        virtualItem.setSizeOnDisk(123344.0);
        Double actualSizeOnDisk = virtualItem.getSizeOnDisk();

        Assert.assertEquals(expectedSizeOnDisk, actualSizeOnDisk);
    }
}
