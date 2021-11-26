package pages.seleniumTraining;

import exceptions.DropDownValueException;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TablePage {

    final WebDriver driver;
    private static final String URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";

    private final By SHOW_PER_PAGE = By.xpath("//select[@name='example_length']");
    private final By EMPLOYEE_TABLE = By.id("example");
    private final By NEXT_BUTTON = By.id("example_next");

    public TablePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
    }

    public TablePage setTableRecordsPerPage(String value) {
        try {
            Select recordsOnPageDropDown = new Select(driver.findElement(getSHOW_PER_PAGE()));
            recordsOnPageDropDown.selectByValue(value);
        } catch (NoSuchElementException e) {
            throw new DropDownValueException("No such drop-down value", e);
        }
        return new TablePage(driver);
    }

    public List<Customer> createCustomersList(int age, double salary) {
        List<Customer> customerList = new ArrayList<>();
        WebElement nextButton = driver.findElement(getNEXT_BUTTON());
        String nextButtonClass = nextButton.getAttribute("class");

        while (!nextButtonClass.contains("disabled")) {
            driver.findElement(getNEXT_BUTTON()).click();
            nextButtonClass = driver.findElement(getNEXT_BUTTON()).getAttribute("class");

            WebElement table = driver.findElement(getEMPLOYEE_TABLE());
            List<WebElement> rows = table.findElements(By.xpath(".//tbody//tr"));

            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.xpath(".//td"));
                int customerAge = Integer.parseInt(columns.get(3).getText());
                String customerSalary = columns.get(5).getText();

                String salarySubstring = customerSalary.substring(customerSalary.indexOf('$') + 1,
                        customerSalary.indexOf('/')).replace(',', '.');

                double salaryFormattedValue = (salarySubstring.length() > 7) ?
                        Double.parseDouble((salarySubstring.replace(".", ""))) : Double.parseDouble((salarySubstring));

                if (customerAge > age && salaryFormattedValue <= salary) {
                    Customer customer = new Customer(
                            columns.get(0).getText(),
                            columns.get(1).getText(),
                            columns.get(2).getText());
                    customerList.add(customer);
                }
            }
        }
        return customerList;
    }
}