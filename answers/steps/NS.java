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
 * Created by DLAMMERS on 19/4/2016.
 */
public class NS {
    WebDriver browser;

    public NS() throws MalformedURLException {
        this.browser = new BrowserFactory().createFfDriver();
    }

    @Given("^I am at www.ns.nl$")
    public void iAmAtWwwNsNl() throws Throwable {
        browser.get("https://www.ns.nl/producten/s/enkele-reis");
    }

    @Given("^I am at NS website for \"([^\"]*)\"$")
    public void iAmAtNSWebsiteFor(String reisType) throws Throwable {
        browser.get("https://www.ns.nl/producten/s/" + reisType);
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

    @And("^I choose to travel on \"([^\"]*)\"$")
    public void iChooseToTravelOn(String vertrekDatum) throws Throwable {
        browser.findElement(By.cssSelector("[for=\"OtherDay_TravelDate\"]")).click();
        browser.findElement(By.cssSelector("#TravelDate")).sendKeys(vertrekDatum);
    }

    @And("^I fill \"([^\"]*)\" as the station Vanaf$")
    public void iFillAsTheStationVanaf(String stationVanaf) throws Throwable {
        browser.findElement(By.cssSelector("#displayStationFrom")).sendKeys(stationVanaf);
    }

    @And("^I fill the station To$")
    public void iFillTheStationTo() throws Throwable {
        browser.findElement(By.cssSelector("#displayStationTo")).sendKeys("Amsterdam");
        Thread.sleep(1000);
        List<WebElement> listOfElements = browser.findElements(By.cssSelector(".ui-menu-item [id*=\"ui-id-\"]"));
        for(WebElement oneElement: listOfElements){
            String textOfElement = oneElement.getText();
            if (textOfElement.equals("Amsterdam Airport")){
                oneElement.click();
                return;
            }
        }
    }

    @And("^I fill \"([^\"]*)\" as the station Naar$")
    public void iFillAsTheStationNaar(String stationNaar) throws Throwable {
        browser.findElement(By.cssSelector("#displayStationTo")).clear();
        browser.findElement(By.cssSelector("#displayStationTo")).sendKeys(stationNaar);
        Thread.sleep(1000);
        List<WebElement> listOfElements = browser.findElements(By.cssSelector(".ui-menu-item [id*=\"ui-id-\"]"));
        for(WebElement oneElement: listOfElements){
                    String textOfElement = oneElement.getText();
                    if (textOfElement.equals(stationNaar)){
                        oneElement.click();
                        return;
            }
        }
    }

    @And("^I select \"([^\"]*)\" as the Klasse$")
    public void iSelectAsTheKlasse(String klasse) throws Throwable {
        if (klasse.equals("1e")){
            browser.findElement(By.cssSelector(".ClassLabel1")).click();
        }
        if (klasse.equals("2e")){
            browser.findElement(By.cssSelector(".ClassLabel2")).click();
        }
    }

    @And("^I select \"([^\"]*)\" as the number of Reizigers$")
    public void iSelectAsTheNumberOfReizigers(Integer numberOfPassengers) throws Throwable {
        for(int i = 1 ; i<= numberOfPassengers -1 ; i++){
        browser.findElement(By.cssSelector(".plus-active")).click();
        }
    }

    @And("^I fill \"([^\"]*)\" as the first initials$")
    public void iFillAsTheFirstInitials(String firstInitials) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_Initials_1\"]")).sendKeys(firstInitials);
    }

    @And("^I fill initials \"([^\"]*)\" for traveller \"([^\"]*)\"$")
    public void iFillInitialsForTraveller(String initials, String travellerNumber) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_Initials_" + travellerNumber + "\"]")).sendKeys(initials);
    }

    @And("^I fill \"([^\"]*)\" as the first name$")
    public void iFillAsTheFirstName(String firstName) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_LastName_1\"]")).sendKeys(firstName);
    }

    @And("^I fill name \"([^\"]*)\" for traveller \"([^\"]*)\"$")
    public void iFillNameForTraveller(String firstName, String travellerNumber) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_LastName_" + travellerNumber + "\"]")).sendKeys(firstName);
    }

    @And("^I fill \"([^\"]*)\" as the first Birth date$")
    public void iFillAsTheFirstBirthDate(String firstBirthdate) throws Throwable {
        String birthDay = Integer.toString(Integer.parseInt(firstBirthdate.substring(0,2)));
        String birthMonth = Integer.toString(Integer.parseInt(firstBirthdate.substring(3,5)));
        String birthYear = firstBirthdate.substring(6,10);
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_1\"] .inputfield__selectbox--birthdateDay [value=\"" + birthDay + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_1\"] .inputfield__selectbox--birthdateMonth [value=\"" + birthMonth + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_1\"] .inputfield__selectbox--birthdateYear [value=\"" + birthYear + "\"]")).click();
    }

    @And("^I fill birth date \"([^\"]*)\" for traveller \"([^\"]*)\"$")
    public void iFillBirthDateForTraveller(String birthDate, String travellerNumber) throws Throwable {
        String birthDay = Integer.toString(Integer.parseInt(birthDate.substring(0,2)));
        String birthMonth = Integer.toString(Integer.parseInt(birthDate.substring(3,5)));
        String birthYear = birthDate.substring(6,10);
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_" + travellerNumber + "\"] .inputfield__selectbox--birthdateDay [value=\"" + birthDay + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_" + travellerNumber + "\"] .inputfield__selectbox--birthdateMonth [value=\"" + birthMonth + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_" + travellerNumber + "\"] .inputfield__selectbox--birthdateYear [value=\"" + birthYear + "\"]")).click();
    }

    @And("^I fill \"([^\"]*)\" as the first email address$")
    public void iFillAsTheFirstEmailAddress(String firstEmail) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_Email_1\"]")).sendKeys(firstEmail);
    }

    @And("^I fill email address \"([^\"]*)\" for traveller \"([^\"]*)\"$")
    public void iFillEmailAddressForTraveller(String emailAddress, String travellerNumber) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_Email_" + travellerNumber + "\"]")).sendKeys(emailAddress);
    }

    @And("^I fill \"([^\"]*)\" as the second initials$")
    public void iFillAsTheSecondInitials(String secondInitials) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_Initials_2\"]")).sendKeys(secondInitials);
    }

    @And("^I fill \"([^\"]*)\" as the second name$")
    public void iFillAsTheSecondName(String secondName) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_LastName_2\"]")).sendKeys(secondName);
    }

    @And("^I fill \"([^\"]*)\" as the second Birth date$")
    public void iFillAsTheSecondBirthDate(String secondBirthdate) throws Throwable {
        String birthDay = Integer.toString(Integer.parseInt(secondBirthdate.substring(0,2)));
        String birthMonth = Integer.toString(Integer.parseInt(secondBirthdate.substring(3,5)));
        String birthYear = secondBirthdate.substring(6,10);
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_2\"] .inputfield__selectbox--birthdateDay [value=\"" + birthDay + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_2\"] .inputfield__selectbox--birthdateMonth [value=\"" + birthMonth + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_2\"] .inputfield__selectbox--birthdateYear [value=\"" + birthYear + "\"]")).click();
    }

    @And("^I fill \"([^\"]*)\" as the second email address$")
    public void iFillAsTheSecondEmailAddress(String secondEmail) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_Email_2\"]")).sendKeys(secondEmail);
    }

    @And("^I have clicked on InWinkelwagen$")
    public void iHaveClickedOnInWinkelwagen() throws Throwable {
        browser.findElement(By.cssSelector(".button.button--nsYellow.button--arrowRight")).click();
    }

    @And("^I have clicked on Railrunner$")
    public void iHaveClickedOnRailrunner() throws Throwable {
        browser.findElement(By.cssSelector("[data-product-name=\"Railrunner\"] .tile__heading.headingM")).click();
    }

    @And("^I have clicked on DirectBestellen$")
    public void iHaveClickedOnDirectBestellen() throws Throwable {
        browser.findElement(By.cssSelector("[class=\"grid product--detail\"] .button.button--buy")).click();
    }

    @And("^I fill to travel today$")
    public void iFillToTravelToday() throws Throwable {
        browser.findElement(By.cssSelector("[for=\"Today_TravelDate\"]")).click();
    }

    @And("^I select \"([^\"]*)\" as the number of Children$")
    public void iSelectAsTheNumberOfChildren(Integer numberOfChildren) throws Throwable {
        for(int i = 1 ; i<= numberOfChildren -1 ; i++){
        browser.findElement(By.cssSelector(".plus-active")).click();
        }
    }

    @And("^I fill \"([^\"]*)\" as the first child initials$")
    public void iFillAsTheFirstChildInitials(String firstChildInitials) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_Initials_1\"]")).sendKeys(firstChildInitials);
    }

    @And("^I fill \"([^\"]*)\" as the first child name$")
    public void iFillAsTheFirstChildName(String firstChildName) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_LastName_1\"]")).sendKeys(firstChildName);
    }

    @And("^I fill \"([^\"]*)\" as the first child Birth date$")
    public void iFillAsTheFirstChildBirthDate(String firstChildBirthdate) throws Throwable {
        String birthDay = Integer.toString(Integer.parseInt(firstChildBirthdate.substring(0,2)));
        String birthMonth = Integer.toString(Integer.parseInt(firstChildBirthdate.substring(3,5)));
        String birthYear = firstChildBirthdate.substring(6,10);
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_1\"] .inputfield__selectbox--birthdateDay [value=\"" + birthDay + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_1\"] .inputfield__selectbox--birthdateMonth [value=\"" + birthMonth + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_1\"] .inputfield__selectbox--birthdateYear [value=\"" + birthYear + "\"]")).click();
    }

    @And("^I fill \"([^\"]*)\" as the second child initials$")
    public void iFillAsTheSecondChildInitials(String secondChildInitials) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_Initials_2\"]")).sendKeys(secondChildInitials);
    }

    @And("^I fill \"([^\"]*)\" as the second child name$")
    public void iFillAsTheSecondChildName(String secondChildName) throws Throwable {
        browser.findElement(By.cssSelector("[name=\"PO_LastName_2\"]")).sendKeys(secondChildName);
    }

    @And("^I fill \"([^\"]*)\" as the second child Birth date$")
    public void iFillAsTheSecondChildBirthDate(String secondChildBirthdate) throws Throwable {
        String birthDay = Integer.toString(Integer.parseInt(secondChildBirthdate.substring(0,2)));
        String birthMonth = Integer.toString(Integer.parseInt(secondChildBirthdate.substring(3,5)));
        String birthYear = secondChildBirthdate.substring(6,10);
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_2\"] .inputfield__selectbox--birthdateDay [value=\"" + birthDay + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_2\"] .inputfield__selectbox--birthdateMonth [value=\"" + birthMonth + "\"]")).click();
        browser.findElement(By.cssSelector("Fieldset[name=\"PO_BirthDate_2\"] .inputfield__selectbox--birthdateYear [value=\"" + birthYear + "\"]")).click();
    }

    @And("^I have checked the kids price$")
    public void iHaveCheckedTheKidsPrice() throws Throwable {
        String kidspriceOnScreen = browser.findElement(By.cssSelector(".total--price")).getText();
        assertTrue(kidspriceOnScreen.contains("5,00"));    }

    @And("^I have clicked on KidsInWinkelwagen$")
    public void iHaveClickedOnKidsInWinkelwagen() throws Throwable {
        browser.findElement(By.cssSelector(".button.button--nsYellow.button--arrowRight")).click();
    }

    @And("^I have checked the total price$")
    public void iHaveCheckedTheTotalPrice() throws Throwable {
        String totalpriceOnScreen = browser.findElement(By.cssSelector(".total--price")).getText();
        assertTrue(totalpriceOnScreen.contains("69,60"));
    }

    @And("^I delete the parents from the Winkelwagen$")
    public void iDeleteTheParentsFromTheWinkelwagen() throws Throwable {
        browser.findElement(By.cssSelector("[title=\"Verwijder het volgende product Enkele reis\"]")).click();
    }

    @And("^I confirm deleting the parents$")
    public void iConfirmDeletingTheParents() throws Throwable {
        browser.findElement(By.cssSelector(".kor-overlay-content .kor-content-contents .button.remove-ticket")).click();
    }

    @And("^I delete the kids from the Winkelwagen$")
    public void iDeleteTheKidsFromTheWinkelwagen() throws Throwable {
        browser.findElement(By.cssSelector("[title=\"Verwijder het volgende product Railrunner\"]")).click();
    }

    @And("^I confirm deleting the kids$")
    public void iConfirmDeletingTheKids() throws Throwable {
        browser.findElement(By.cssSelector(".kor-overlay-content .kor-content-contents .button.remove-ticket")).click();
    }

    @Then("^the total price is \"([^\"]*)\"$")
    public void theTotalPriceIs(String totalPrice) throws Throwable {
        WebElement priceElement = browser.findElement(By.cssSelector(".total--price"));
 //       new Actions(browser).moveToElement(priceElement).perform();
 //       new Actions(browser).moveToElement(priceElement).click().perform();
        Thread.sleep(2000);
        browser.findElement(By.cssSelector(".button.button--nsYellow.button--arrowRight")).getLocation();
        Thread.sleep(2000);
        new Actions(browser).moveToElement(priceElement).doubleClick().perform();
        Thread.sleep(2000);



        String priceOnScreen = browser.findElement(By.cssSelector(".total--price")).getText();
        assertTrue(priceOnScreen.contains(totalPrice));
    }

    private void perform() {
    }

    @Given("^I travel today from \"([^\"]*)\"$")
    public void iTravelTodayFrom(String stationVanaf) throws Throwable {
        iAmAtWwwNsNl();
        iClickedAcceptInCookiePopup();
        iChooseToTravelToday();
        browser.findElement(By.cssSelector("#displayStationFrom")).sendKeys(stationVanaf);
    }

    @When("^I'm going to \"([^\"]*)\"$")
    public void iMGoingTo(String stationNaar) throws Throwable {
        iFillAsTheStationNaar(stationNaar);
        iFillAsTheFirstInitials("H.");
        iFillAsTheFirstName("Vermout");
        iFillAsTheFirstBirthDate("02-06-1968");
        iHaveClickedOnInWinkelwagen();
    }

    @When("^I change the destinity into \"([^\"]*)\"$")
    public void iChangeTheDestinityInto(String stationNaar) throws Throwable {
        browser.findElement(By.cssSelector(".editLink")).click();
        iFillAsTheStationNaar(stationNaar);
        iHaveClickedOnInWinkelwagen();
    }

    @When("^I travel to \"([^\"]*)\"$")
    public void iTravelTo(String toStation) throws Throwable {
        iFillAsTheStationNaar(toStation);
    }

    @Given("^I'm travelling today from \"([^\"]*)\"$")
    public void iMTravellingTodayFrom(String stationVanaf) throws Throwable {
        iAmAtWwwNsNl();
        iClickedAcceptInCookiePopup();
        iChooseToTravelToday();
        iFillAsTheFirstInitials("H.");
        iFillAsTheFirstName("Vermout");
        iFillAsTheFirstBirthDate("02-06-1968");
        browser.findElement(By.cssSelector("#displayStationFrom")).sendKeys(stationVanaf);

    }

    @Then("^I have to pay \"([^\"]*)\"$")
    public void iHaveToPay(String totalPrice) throws Throwable {
        theTotalPriceIs(totalPrice);
    }

    @Then("^I have to pay \"([^\"]*)\":$")
    public void iHaveToPayTable(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I go to \"([^\"]*)\" and pay \"([^\"]*)\":$")
    public void iGoToAndPay(String toStation, String totalPrice) throws Throwable {
        iFillAsTheStationNaar(toStation);
        theTotalPriceIs(totalPrice);
    }

    @Then("^I select a destination and check the totalPrice:$")
    public void iSelectADestinationAndCheckTheTotalPrice(DataTable table) throws Throwable {
        for(List<String> row: table.cells(1)){
//            System.out.println("waarde 1: " + row.get(0));
//            System.out.println("waarde 2: " + row.get(1));
            iFillAsTheStationNaar(row.get(0));
            iHaveClickedOnInWinkelwagen();
            theTotalPriceIs(row.get(1));
            browser.findElement(By.cssSelector(".editLink")).click();
        }
    }

    @Given("^travelling today$")
    public void travellingToday() throws Throwable {
        iAmAtWwwNsNl();
        iClickedAcceptInCookiePopup();
        iChooseToTravelToday();
    }

    @Given("^travelling today \"([^\"]*)\"$")
    public void travellingToday(String reisType) throws Throwable {
        iAmAtNSWebsiteFor(reisType);
        iClickedAcceptInCookiePopup();
        iChooseToTravelToday();
    }

    @And("^we travel with the following adults:$")
    public void weTravelWithTheFollowingAdults(DataTable table) throws Throwable {
        for(List<String> row: table.cells(2)){
            browser.findElement(By.cssSelector(".plus-active")).click();
        }
        int i = 1;
        for(List<String> row: table.cells(1)){
            String travellerNumber = Integer.toString(i);
            iFillInitialsForTraveller(row.get(0), travellerNumber);
            iFillNameForTraveller(row.get(1), travellerNumber);
            iFillBirthDateForTraveller(row.get(2), travellerNumber);
            iFillEmailAddressForTraveller(row.get(3), travellerNumber);
            i++;
        }
    }

    @And("^we travel with the following kids:$")
    public void weTravelWithTheFollowingKids(DataTable table) throws Throwable {
        iHaveClickedOnInWinkelwagen();
        iHaveClickedOnRailrunner();
        iHaveClickedOnDirectBestellen();
        iFillToTravelToday();
        for(List<String> row: table.cells(2)){
            browser.findElement(By.cssSelector(".plus-active")).click();
        }
        int i = 1;
        for(List<String> row: table.cells(1)){
            String travellerNumber = Integer.toString(i);
            iFillInitialsForTraveller(row.get(0), travellerNumber);
            iFillNameForTraveller(row.get(1), travellerNumber);
            iFillBirthDateForTraveller(row.get(2), travellerNumber);
            i++;
        }
    }

    @Given("^I'm on ABN Amro site$")
    public void iMOnABNAmroSite() throws Throwable {
        browser.get("https://www.abnamro.nl/nl/prive/index.html");
    }

    @And("^I have accepted AA cookies$")
    public void iHaveAcceptedAACookies() throws Throwable {
        browser.findElement(By.cssSelector(".mlf-js-cookie-accept.mlf-button.mlf-button-action")).click();
        Thread.sleep(3000);

    }

    @And("^I have selected Menu \"([^\"]*)\"$")
    public void iHaveSelectedMenu(String Menu) throws Throwable {
    //    browser.findElement(By.xpath("//li[contains(text(),'Verzekeren')][@class='translate']")).click();
        browser.findElement(By.xpath("//li[contains(text(),'Verzekeren')]")).click();
        throw new PendingException();
    }
}
