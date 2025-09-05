package com.example.tests;

import com.example.base.BaseTest;
import com.example.base.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginDataFromJson", dataProviderClass = TestDataProvider.class)
    public void loginTest(String username, String password, boolean expectedSuccess) {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        String message = loginPage.getMessage();

        if (expectedSuccess) {
            Assert.assertTrue(message.contains("You logged into a secure area!"),
                    "Login should succeed with valid credentials");
        } else {
            Assert.assertTrue(message.contains("invalid"),
                    "Login should fail with invalid credentials");
        }
    }
}
