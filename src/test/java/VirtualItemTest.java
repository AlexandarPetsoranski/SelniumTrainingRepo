
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestData;

public class VirtualItemTest extends BaseSpec{

    @Test
    void realItemToString_StringRealItemIsReturnedSuccessfully() {
        virtualItem = TestData.createVirtualItem();
        String expectedVirtualItem = "Class: class shop.VirtualItem; Name: Audi; Price: 32026.9; Size on disk: 1560.0";

        String actualVirtualItem = virtualItem.toString();

        Assert.assertEquals(actualVirtualItem,expectedVirtualItem);
    }
}
