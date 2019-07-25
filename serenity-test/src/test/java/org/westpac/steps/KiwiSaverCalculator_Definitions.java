package org.westpac.steps;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class KiwiSaverCalculator_Definitions {

    @Steps
    KiwiSaverRetirement_Steps KW_Steps;

    @Given("As an user I am on the KiwiSaver Retirement Calculator page")
    public void I_am_on_the_KiwiSaver_Retirement_Calculator_page() {
        KW_Steps.Navigate_toKiwiSaverCalculatorPage();
        KW_Steps.Navigate_toRetirementCalculatorPage();
    }

    @When("^an user clicks the information icon besides the ([^\\\"]*)$")
    public void an_user_clicks_the_information_icon(String fieldname) { KW_Steps.Click_infobtn(fieldname); }

    @Then("^the following message should be displayed- ([^\\\"]*)$")
    public void the_following_message_should_be_displayed(String message) { KW_Steps.Check_msgtext(message); }

    @When("^an user enters the details for scenario (.*?) in the KiwiSaver calculator$")
    public void enter_details(int testcasenumber) throws IOException, InvalidFormatException { KW_Steps.Get_details(testcasenumber); }

    @Then("^the projected KiwiSaver balance at retirement gets displayed$")
    public void projected_balance() { KW_Steps.Section_displayed(); }


}
