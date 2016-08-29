package com.capgemini.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.capgemini.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;
import java.util.List;

import static com.google.common.base.Verify.verify;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jaarts on 8-8-2016.
 */
public class ABN {
    WebDriver browser;

    public ABN() throws MalformedURLException {
        this.browser = new BrowserFactory().createFfDriver();
    }


}
