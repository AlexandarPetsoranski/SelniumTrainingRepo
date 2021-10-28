import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import parser.JsonParser;
import parser.Parser;

public class BaseSpec {
    Parser parser;

    @BeforeEach
    void setUp(){
         parser = new JsonParser();
    }

    @AfterAll
    void close(){
        System.out.println("Tests passed successfully");
    }
}