package spec.seleniumSpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.seleniumTraining.SelectPage;
import spec.BaseSpec;

import java.util.ArrayList;
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
        List<Integer> number = random
                .ints(0, 7)
                .limit(3)
                .boxed()
                .collect(Collectors.toList());

        List<String> expectedList = new ArrayList<>();
        if (multiSelect.isMultiple()) {
            for (Integer index : number) {
                multiSelect.selectByIndex(index);
                Select select = new Select(driver.findElement(selectPage.getMULTISELECT()));
                expectedList = select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
            }
        }

        List<String> actualList = multiSelect.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());

        Assertions.assertEquals(actualList, expectedList);
    }
}
