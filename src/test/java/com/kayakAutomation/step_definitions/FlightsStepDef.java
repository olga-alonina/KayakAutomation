package com.kayakAutomation.step_definitions;

import com.kayakAutomation.pages.BasePage;
import com.kayakAutomation.pages.FlightsPage;
import com.kayakAutomation.utilities.ConfigurationReader;
import com.kayakAutomation.utilities.Driver;

import java.util.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class FlightsStepDef {

    BasePage basePage = new BasePage();
    FlightsPage flightsPage = new FlightsPage();
    Actions actions = new Actions(Driver.get());


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @When("I go to the {string} page")
    public void i_go_to_the_page(String pageName) {
        basePage.navigateTo(pageName);
    }

    @Then("I {string} see {string} page title")
    public void i_see_page_title(String vision, String title) {
        flightsPage.verifyTitleByVision(vision, title);
    }

    @Then("I {string} see {string} button on side panel")
    public void i_see_button_on_side_panel(String vision, String buttonName) {//todo how to use 2 strings here from parameters
        Assert.assertTrue(basePage.burgerMenuSign.isDisplayed());
    }

    @Then("I should be able to see side panel pages")
    public void i_should_be_able_to_see_side_panel_pages(List<String> list) {
        List<String> burgerList = new ArrayList<>();
        for (WebElement each : basePage.burgerMenuOptions) {
            burgerList.add(each.getText());
        }
        System.out.println("burgerList = " + burgerList);
        System.out.println("list = " + list);
        Assert.assertEquals(burgerList, list);
    }

    @And("I should be able to see side panel page icons")
    public void i_should_be_able_to_see_side_panel_icons(List<String> icons) {
        basePage.verifyPanelPageIcons(icons);
    }

    @When("I click {string} button")
    public void i_click_button(String string) {
        actions.click(basePage.burgerMenuSign).perform();
    }

    @Then("Verify side panel is {string}")
    public void verify_side_panel_is(String status) {
        basePage.verifyRowCollapsed(status);
    }

    @Then("I should not be able to see side panel pages")
    public void i_should_not_be_able_to_see_side_panel_pages() {
        basePage.verifyEachLineCollapsed();
    }


    @When("I hover over to {string} icon")
    public void i_hover_over_to_icon(String pageName) {
        flightsPage.pageFlightTitle.click();
        actions.moveToElement(basePage.flights).perform();
    }
}

