package com.kayakAutomation.pages;

import com.kayakAutomation.utilities.Driver;
import java.util.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
//temprorary aded todo ask Talha

    @FindBy(xpath = "//nav[contains(@class,'container')]//*[@aria-label='Flights icon']")
    public WebElement flights;

    //close
    @FindBy(css = "[class='MvE2-menu-button']")
    public WebElement burgerMenuSign;

    @FindBy(css = ".hsCY-menu-item-title")
    public List<WebElement> burgerMenuOptions;

    @FindBy(xpath = "//nav[contains(@class,'container')]//a[contains(@class,'hsCY')]")
    public List<WebElement>collapsedMenu;

    @FindBy(xpath = "//nav[contains(@class,'container')]//*[@role='presentation']")
    public List<WebElement> burgerMenuIcons;

    @FindBy(xpath = "//div[contains(@class,'MvE2-responsive')]")
    public WebElement leftPanel;

    @FindBy(xpath = "  //div[@id='c_jBL']//a[@class='main-logo__link']")
    public WebElement pageKayakTitle;



    public void navigateTo(String moduleName) {
        WebElement ModuleLocator = Driver.get().findElement(By.xpath("//nav[contains(@class, 'nav-container')]//a//div[normalize-space(text()) = '" + moduleName + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(ModuleLocator));
        ModuleLocator.click();
    }

    public void verifyIcon(String iconName) {
        iconName = iconName.substring(0, iconName.indexOf(" ")).toLowerCase();

        WebElement iconLocator = Driver.get().findElement(By.xpath(
                "//div[contains(@class,'responsive')]//a[contains(@href,'" + iconName + "')"));
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(iconLocator));
        Assert.assertTrue(iconLocator.getAttribute("href").contains(iconName) ||
                iconLocator.getAttribute("aria-label").contains(iconName));

    }

    //div[contains(@class,"hsCY-menu-item-title") and .='']
    public void verifySidePanelPages(String sideName) {
        WebElement picsLocator = Driver.get().findElement(By.xpath(
                "//div[contains(@class,'hsCY-menu-item-title') and .='" + sideName + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(picsLocator));//todo   ????
        Assert.assertEquals(picsLocator.getText(), sideName);

    }
    public void verifyRowCollapsed (String status) {
        if (status.equals("close")) {
            System.out.println("if close = " + leftPanel.getAttribute("class"));
            Assert.assertFalse(leftPanel.getAttribute("class").contains("MvE2-expanded"));
        }
        else if (status.equals("open")) {
            System.out.println("if open = " + leftPanel.getAttribute("class"));
            Assert.assertTrue(leftPanel.getAttribute("class").contains("MvE2-expanded"));
        }
    }
    public void verifyEachLineCollapsed() {
        for (WebElement each : collapsedMenu) {
//            System.out.println("each.getAttribute(\"class\") = " + each.getAttribute("class"));
//            System.out.println("name = " + each.getAttribute("aria-label"));
            Assert.assertTrue(each.getAttribute("class").contains("hsCY-collapsed"));

        }
    }
    public void verifyPanelPageIcons(List<String> icons) {
        List<String> burgerIcons = new ArrayList<>();
        for (WebElement each : burgerMenuIcons) {
            String temp = each.getAttribute("aria-label").replace(" icon", "").toLowerCase();
            burgerIcons.add(temp);
        }
        Assert.assertEquals(burgerIcons, icons);
    }
}



