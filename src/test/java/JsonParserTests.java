import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

public class JsonParserTests extends BaseSpec {
    ObjectMapper mapper=new ObjectMapper();

    @Test
    @DisplayName("Verify writeToFile works correct")
    void writeToFileSuccessfullyCreatesJsonFile() throws IOException {
        Cart expectedCart = TestData.createTestCart();

        parser.writeToFile(expectedCart);
        Path actualFilePath = Paths.get("src/main/resources/" + expectedCart.getCartName() + ".json");
        String actualFile = Files.readAllLines(actualFilePath).get(0);
        Cart actualCartObject = mapper.readValue(actualFile,Cart.class);

        String expectedCartString = new Gson().toJson(expectedCart);
        String actualCartString = new Gson().toJson(actualCartObject);

        Assert.assertEquals(expectedCartString, actualCartString);
    }

    @Test
    @DisplayName("Verify readFromFile works correct")
    void readFromFile_InformationProperlyRead() throws IOException {
        Cart expectedCart = TestData.createTestCart();
        String expectedCartJson = new Gson().toJson(expectedCart);

        parser.writeToFile(expectedCart);
        Path actualFilePath = Paths.get("src/main/resources/" + expectedCart.getCartName() + ".json");
        Cart actualCart = parser.readFromFile(new File(String.valueOf(actualFilePath)));
        String actualCartString = new Gson().toJson(actualCart);

        Assert.assertEquals(expectedCartJson,actualCartString);
    }

    //check this one
    @Test
    @Disabled
    @DisplayName("Test readFromFile works with json file types only")
    void passWrongFormatFileToReadFromFile_NoSuchFileExceptionPresented() {
        Cart test = parser.readFromFile(new File("src/main/resources/emptyXMLfile.xml"));
        System.out.println(test);
    }

    @ParameterizedTest
    @DisplayName("Verify NoSuchFileException is presented if wrong file is passed")
    @ValueSource(strings = {"src/main/resources/NoSuchFile.file",
            "src/main/resources/NoSuchFile",
            "",
            " ",
            "src/main/resources/andrew-cart.xml"})
    void passWrongFileToReadFromFile_NoSuchFileExceptionPresented(String input) {
        assertThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File(String.valueOf(input)));
        });
    }
}
