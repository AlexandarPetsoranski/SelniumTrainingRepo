import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import shop.RealItem;
import testData.TestData;

public class RealItemTest extends BaseSpec{

    @Test
    @DisplayName("Test toString functionality")
    void realItemToString_StringRealItemIsReturnedSuccessfully() {
        realItem = TestData.createRealItem();
        String expectedRealItem = "Class: class shop.RealItem; Name: Audi; Price: 32026.9; Weight: 1560.0";

        String actualRealItem = realItem.toString();

        Assert.assertEquals(actualRealItem,expectedRealItem);
    }
}
