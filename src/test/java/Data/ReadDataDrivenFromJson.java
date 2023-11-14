package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataDrivenFromJson {

    String UserLogin = "UserLogin";


    private String[] readJson(String testStatus) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();


        FileReader fileReader = new FileReader("./src\\test\\resources\\userLoginData.json ");
        Object object = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(testStatus);
        String arr[] = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject users = (JSONObject) jsonArray.get(i);
            String userName = (String) users.get("userName");
            String userPass = (String) users.get("userPass");
            arr[i] = userName + "," + userPass;
        }
        return arr;
    }


    public String[] testDataForSucessfulLogin() throws IOException, ParseException {
        return readJson(UserLogin);
    }


}
