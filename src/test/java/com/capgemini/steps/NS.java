package com.capgemini.steps;

import com.capgemini.ourWebdriver.BrowserFactory;
import com.capgemini.ourWebdriver.OurWebDriver;
import com.capgemini.ourWebdriver.TearDown;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

/**
 * Created by DLAMMERS on 19/4/2016.
 */
public class NS {
    private OurWebDriver browser;
    private TearDown tearDown;

    public NS() throws MalformedURLException {
        this.browser = BrowserFactory.getWebDriver();

    }


    @Given("^I am at www.ns.nl$")
    public void iAmAtWwwNsNl() throws Throwable {
        browser.get("https://www.ns.nl/producten/en/s/enkele-reis");
    }

    @And("^I clicked accept in cookie popup$")
    public void iClickedAcceptInCookiePopup() throws Throwable {
        try {
            WebElement iframe = browser.findElement(By.cssSelector(".r42CookieBar"));
            browser.switchTo().frame(iframe);
            browser.findElement(By.cssSelector(".button.accept")).click();
            browser.switchTo().defaultContent();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    @When("^I choose to travel today$")
    public void iChooseToTravelToday() throws Throwable {
        browser.findElement(By.cssSelector("[for=\"Today_TravelDate\"]")).click();
    }


    @And("^I travel from Amsterdam$")
    public void iTravelFromAmsterdam() throws Throwable {
        browser.findElement(By.cssSelector("#displayStationFrom")).sendKeys("Amsterdam Centraal");

    }

    @And("^I travel to Utrecht$")
    public void iTravelToUtrecht() throws Throwable {
        browser.findElement(By.cssSelector("#displayStationTo")).sendKeys("Utrecht Centraal");
    }

    @And("^I set Class$")
    public void iSetClass() throws Throwable {
        browser.findElement(By.cssSelector(".ClassLabel1")).click();

    }

    @And("^no of pessengers$")
    public void NoPessengers() throws Throwable {
        browser.findElement(By.cssSelector("#PO_TravelerAmount")).sendKeys("a.plus-active");
    }

    @And("^I set Initials$")
    public void ISetInitials() throws Throwable {
        browser.findElement(By.cssSelector("#PO_Initials_1")).sendKeys("EP");
    }

    @And("^I set Surname$")
    public void ISetSurname() throws Throwable {
        browser.findElement(By.cssSelector("#PO_LastName_1")).sendKeys("Plieger");
    }

    @And("^Set date of birth$")
    public void SetDateOfbirth() throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_BirthDate_1\"] .inputfield__selectbox--birthdateDay [value='10']")).click();
    }

    @And("^Set date Month$")
    public void SetDateMonth() throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_BirthDate_1\"] .inputfield__selectbox--birthdateMonth [value='3']")).click();

    }

    @And("^Set date Year$")
    public void SetDateYear() throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_BirthDate_1\"] .inputfield__selectbox--birthdateYear [value='1970']")).click();
    }

    @And("^Set Email address$")
    public void SetEmailAddress() throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_Email_1\"]")).sendKeys("xx@xx.com");
    }

    @And("^Add to shoppingcard$")
    public void AddToShoppingCard() throws Throwable {
        browser.findElement(By.cssSelector("[name=\"addProduct\"]")).click();

    }

    @And("^verify price$")
    public void verifyPrice() throws Throwable {


        String priceonscreen = browser.findElement(By.cssSelector(".actionBar--shoppingCart .total--price")).getText();

        Assert.assertEquals ("12,80", priceonscreen);





        throw new PendingException();
    }
}
//    @After
//    public void afterScenario() {
//        browser.quit();
//    }
