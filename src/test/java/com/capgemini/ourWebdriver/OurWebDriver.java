package com.capgemini.ourWebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by DLAMMERS on 24/1/2017.
 */
public interface OurWebDriver extends WebDriver {

    int IMPLICIT_WAIT_TIMEOUT = 15;


    WebElement waitForElement(String selector);

    WebElement waitForVisible(String selector);

    void waitForAjax();

}
