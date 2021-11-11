import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import parser.JsonParser;
import parser.Parser;
import shop.RealItem;
import shop.VirtualItem;

public class BaseSpec {
    Parser parser;
    RealItem realItem;
    VirtualItem virtualItem;


    @BeforeMethod
    void setUp(){
         parser = new JsonParser();
         realItem = new RealItem();
         virtualItem = new VirtualItem();
    }

    @AfterClass
    static void close(){
        System.out.println("Test execution finished successfully");
    }
}