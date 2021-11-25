package pages.seleniumTraining;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public List<Customer> createCustomersList(int age, double salary) {
        List<Customer> customerList = new ArrayList<>();

        WebElement table = driver.findElement(getEMPLOYEE_TABLE());
        List<WebElement> rows = table.findElements(By.xpath(".//tbody//tr"));

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.xpath(".//td"));
            int customerAge = Integer.parseInt(columns.get(3).getText());
            String customerSalary = columns.get(5).getText();

            String salarySubstring = customerSalary.substring(customerSalary.indexOf('$') + 1,
                    customerSalary.indexOf('/')).replace(',', '.');

            double salaryFormatted;
            if (salarySubstring.length() > 7) {
                salaryFormatted = Double.parseDouble((salarySubstring.replace(".", "")));
            } else {
                salaryFormatted = Double.parseDouble((salarySubstring));
            }

            if (customerAge > age && salaryFormatted <= salary) {
                Customer customer = new Customer(
                        columns.get(0).getText(),
                        columns.get(1).getText(),
                        columns.get(2).getText());
                customerList.add(customer);
                System.out.println(customerList + "\n");
            }
        }

        WebElement nextButton = driver.findElement(getNEXT_BUTTON());
        String nextButtonClass = nextButton.getAttribute("class");

        while (!nextButtonClass.contains("disabled")) {
            nextButton.click();
            nextButtonClass = nextButton.getAttribute("class");
        }
        return customerList;

    }
}