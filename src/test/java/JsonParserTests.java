import com.google.gson.Gson;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import parser.NoSuchFileException;
import shop.Cart;
import testData.TestData;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static testData.TestData.testCart;

public class JsonParserTests extends BaseSpec{

    @Test
    @DisplayName("Verify writeToFile works correct")
    void writeToFile_successfullyCreatesJsonFile() throws IOException {
        TestData.createTestCart("test-cart");
        parser.writeToFile(testCart);

        Path expectedFilePath = Paths.get("src/main/resources/expected-cart.json");
        String expectedFile = Files.readAllLines(expectedFilePath).get(0);

        Path actualFilePath = Paths.get("src/main/resources/test-cart.json");
        String actualFile = Files.readAllLines(actualFilePath).get(0);

        System.out.println("expected file:" + expectedFile + "\n" + "  actual file:" + actualFile );
        Assert.assertEquals(expectedFile,actualFile);
    }

    @Test
    @DisplayName("Verify readFromFile works correct")
    void readFromFile_InformationProperlyRead() throws IOException {
        Cart expectedCart = TestData.createTestCart("test-cart");
        Cart actualCart = parser.readFromFile(new File("src/main/resources/test-cart.json"));

        //I used that approach because I see in code you used Gson and easier than
        //overriding equals method
        String expectedCartJson = new Gson().toJson(expectedCart);
        String actualCartJson = new Gson().toJson(actualCart);

        System.out.println("Expected cart string is: " + expectedCartJson + "\n" +
                "Actual cart value is: " + actualCartJson );
        Assert.assertEquals(expectedCartJson,actualCartJson);
    }

    //check this one
    @Test
    @Disabled
    @DisplayName("Test readFromFile works with json file types only")
    void passWrongFormatFileToReadFromFile_NoSuchFileExceptionPresented(){
        Cart test = parser.readFromFile(new File("src/main/resources/emptyXMLfile.xml"));
        System.out.println(test);
    }

    @Test
    @DisplayName("Verify NoSuchFileException is presented if wrong file is passed")
    void passWrongFileToReadFromFile_NoSuchFileExceptionPresented(){
         assertThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File("src/main/resources/NoSuchFile.file"));
        });
    }
}
