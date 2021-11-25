package spec.seleniumSpec;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.seleniumTraining.Customer;
import pages.seleniumTraining.TablePage;
import spec.BaseSpec;

import java.util.ArrayList;
import java.util.List;

public class TableSpec extends BaseSpec {

    private TablePage tablePage;


    @Test
    public void test (){
        tablePage = new TablePage(driver);

        Select recordsOnPageDropDown = new Select(driver.findElement(tablePage.getSHOW_PER_PAGE()));
        recordsOnPageDropDown.selectByIndex(0);

        List<Customer> employeeList = tablePage.createCustomersList(30,200000);
        //tablePage.checkAreThereMoreTableRecords();
    }

}
