package com.kayakAutomation.step_definitions;

import com.kayakAutomation.utilities.ConfigurationReader;
import com.kayakAutomation.utilities.Driver;
import io.cucumber.java.en.Given;

public class LoginStep {




    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }
}
