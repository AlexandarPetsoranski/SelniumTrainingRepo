import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import parser.JsonParser;
import parser.Parser;
import shop.RealItem;
import shop.VirtualItem;

public class BaseSpec {
    Parser parser;
    RealItem realItem;
    VirtualItem virtualItem;


    @BeforeEach
    void setUp(){
         parser = new JsonParser();
         realItem = new RealItem();
         virtualItem = new VirtualItem();
    }

    @AfterAll
    static void close(){
        System.out.println("Test execution finished successfully");
    }
}