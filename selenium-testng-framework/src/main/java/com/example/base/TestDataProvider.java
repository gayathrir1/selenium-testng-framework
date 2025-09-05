package com.example.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class TestDataProvider {

    @DataProvider(name = "loginDataFromJson")
    public Object[][] getLoginDataFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON file into array of LoginData objects
        LoginData[] data = mapper.readValue(
                new File("src/test/resources/loginData.json"),
                LoginData[].class
        );

        // Convert LoginData[] into Object[][]
        Object[][] testData = new Object[data.length][3];
        for (int i = 0; i < data.length; i++) {
            testData[i][0] = data[i].getUsername();
            testData[i][1] = data[i].getPassword();
            testData[i][2] = data[i].isExpectedSuccess();
        }
        return testData;
    }
}
