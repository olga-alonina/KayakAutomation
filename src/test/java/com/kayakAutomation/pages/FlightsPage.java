package com.kayakAutomation.pages;

import com.kayakAutomation.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
    public FlightsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    BasePage basePage = new BasePage();
    @FindBy(css = "h2[class='title dark']")
    public WebElement pageFlightTitle;


    public void verifyTitleByVision(String vision, String title) {
        if (vision.equals("should")) {
            if (title.equals("Where are you flying?")) {
                Assert.assertEquals(pageFlightTitle.getText(), title);
            }
            if (title.equals("KAYAK")) {
                Assert.assertEquals(basePage.pageKayakTitle.getAttribute("aria-label"), title);
            }
        }
        if (vision.equals("should not")) {
            if (title.equals("Where are you flying?")) {
                Assert.assertEquals(pageFlightTitle.getText(), "");
            }
            if (title.equals("KAYAK")) {
                Assert.assertEquals(basePage.pageKayakTitle.getAttribute("aria-label"), "");
            }
        }
    }
}
