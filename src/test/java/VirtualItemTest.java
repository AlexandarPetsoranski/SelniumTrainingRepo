import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import testData.TestData;

public class VirtualItemTest extends BaseSpec{

    @Test
    @DisplayName("Test toString functionality")
    void realItemToString_StringRealItemIsReturnedSuccessfully() {
        virtualItem = TestData.createVirtualItem();
        String expectedVirtualItem = "Class: class shop.VirtualItem; Name: Audi; Price: 32026.9; Size on disk: 1560.0";

        String actualVirtualItem = virtualItem.toString();

        Assert.assertEquals(actualVirtualItem,expectedVirtualItem);
    }
}
