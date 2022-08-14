package com.kayakAutomation.step_definitions;

import com.kayakAutomation.pages.BasePage;
import com.kayakAutomation.utilities.ConfigurationReader;
import com.kayakAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FlightsStepDef {

    BasePage basePage = new BasePage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @When("I go to the {string} page")
    public void i_go_to_the_page(String pageName) {
        basePage.navigateTo(pageName);
    }
}
