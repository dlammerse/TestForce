package com.capgemini.steps;

import com.capgemini.CalculateBonus;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by DLAMMERS on 5/10/2017.
 */
public class bonus {
    private List<String> jobList = new ArrayList<String>();
    private List<Double> salaryList = new ArrayList<Double>();
    private List<Double> calculatedBonus = new ArrayList<Double>();


    @Given("^A (\\w+\\s?\\w+) with a salary of ([\\d_,.]+)$")
    public void aWithSalary(String job, double salary) throws Throwable {
        jobList.add(job);
        salaryList.add(salary);
    }

    @When("^the bonus are calculated$")
    public void theBonusAreCalculated() throws Throwable {
        for(int i=0;i<jobList.size();i++){
            Double bonus = CalculateBonus.calculate(jobList.get(i),salaryList.get(i));
            calculatedBonus.add(bonus);
        }
    }


    @Then("^a (\\w+\\s?\\w+) gets ([\\d_.,]+) bonus$")
    public void aManagerGetsBonus(String job, double bonus) throws Throwable {
//        Assert.assertEquals();ssertEquals("asdf","asdf");
       Assert.assertEquals(bonus,calculatedBonus.get(jobList.indexOf(job)));


    }

    @After
    public void clearDate(){
        jobList.clear();
        salaryList.clear();
        calculatedBonus.clear();

    }
}
