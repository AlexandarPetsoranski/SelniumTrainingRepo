package spec.seleniumSpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.seleniumTraining.Customer;
import pages.seleniumTraining.TablePage;
import spec.BaseSpec;

import java.util.List;

public class TableSpec extends BaseSpec {

    private TablePage tablePage;

    @Test
    public void test (){
        tablePage = new TablePage(driver);
        tablePage.setTableRecordsPerPage("10");

        List<Customer> employeeList = tablePage.createCustomersList(30,200000);

        Assertions.assertEquals(14,employeeList.size());
        //I know that if I change the createCustomersList arguments this assert will fail
        //I added it in the sake of the test
    }
}
