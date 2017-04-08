package com.capgemini.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.capgemini.ourWebdriver.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by DLAMMERS on 19/4/2016.
 */
public class NS {
    private WebDriver browser;

    public NS() throws MalformedURLException {
        this.browser = BrowserFactory.createFfDriver();

    }


    @Given("^I am at www.ns.nl$")
    public void iAmAtWwwNsNl() throws Throwable {
        browser.get("https://www.ns.nl/producten/en/s/enkele-reis");
    }

    @And("^I clicked accept in cookie popup$")
    public void iClickedAcceptInCookiePopup() throws Throwable {
        WebElement iframe = browser.findElement(By.cssSelector(".r42CookieBar"));
        browser.switchTo().frame(iframe);
        browser.findElement(By.cssSelector(".button.accept")).click();
        browser.switchTo().defaultContent();

    }

    @When("^I choose to travel today$")
    public void iChooseToTravelToday() throws Throwable {
        browser.findElement(By.cssSelector("[for=\"Today_TravelDate\"]")).click();
    }

    /**
     * Helper for waiting on an element
     * @param selector; Css-selector to wait for
     * @return element you waited for
     */
    private WebElement waitForElement(String selector) {
        WebDriverWait wait = new WebDriverWait(browser, 15);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
        return element;
    }

    /**
     * Helper to select the station in the dropdown
     * @param station; Station name
     */
    private void findStationInDropDown(String station) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> listOfElements = browser.findElements(By.cssSelector(".ui-menu-item [id*=\"ui-id-\"]"));
        for(WebElement oneElement: listOfElements){
            String textOfElement = oneElement.getText();
            if (textOfElement.equals(station)){
                oneElement.click();
                return;
            }
        }
    }
}
