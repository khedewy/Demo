package data;

import Pages.PageBase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AddReviewData extends PageBase {
    public AddReviewData(WebDriver driver) {
        super(driver);
    }
    public String firstName, LastName, email,company, Password;

    public void userData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/AddReview.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object jsonObj : jArray){
            JSONObject person = (JSONObject) jsonObj;

            firstName = (String) person.get("firstName");
            LastName = (String) person.get("lastName");
            email = (String) person.get("email");
            Password = (String) person.get("password");
            company = (String) person.get("company");
        }
    }
}
