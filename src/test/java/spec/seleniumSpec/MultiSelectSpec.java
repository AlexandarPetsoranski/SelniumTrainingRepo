package spec.seleniumSpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import pages.seleniumTraining.SelectPage;
import spec.BaseSpec;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MultiSelectSpec extends BaseSpec {
    private SelectPage selectPage;

    @Test
    public void VerifyUserCanSelectMultipleOptions() {
        selectPage = new SelectPage(driver);
        Select multiSelect = new Select(driver.findElement(selectPage.getMULTISELECT()));

        Random random = new Random();
        List<Integer> options = random
                .ints(0,7)
                .limit(3)
                .boxed()
                .collect(Collectors.toList());

        if (multiSelect.isMultiple()) {
            for (Integer index : options){
                multiSelect.selectByIndex(index);
            }
        }

        Integer numberOfSelectedOptions = multiSelect.getAllSelectedOptions().size();
        Assertions.assertEquals(3, numberOfSelectedOptions);

        for (Integer index : options) {
            multiSelect.deselectByIndex(index);
        }

        Assertions.assertEquals(0, multiSelect.getAllSelectedOptions().size());
    }
}
