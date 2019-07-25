package org.westpac.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.westpac.util.Read_TDExcel;
import java.io.IOException;



public class Kiwisaver_RetirementPage extends PageObject {

    Read_TDExcel Read_Excel =new Read_TDExcel();

    //web elements

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/iframe[1]")
    private WebElement clc_Frame;

    @FindBy(xpath="//div[@class='field-message message-info ng-binding']/p")
    private WebElement info_Message;

    @FindBy(xpath="//div[@label='Current age']//div[@class='field-cell field-controls']//input")
    private WebElement current_Age;

    @FindBy(xpath="//div[@label='Employment status']//div[@class='field-cell field-controls']//span")
    private WebElement employment_Status;

    @FindBy(xpath="//div[contains(@class,'dropdown-cell control-cell ng-scope ng-isolate-scope')]//div[@class='control-well']")
 //  @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    private WebElement presc_Investorrate;

  //  @FindBy(xpath="//div[@label='Voluntary contributions']//div[@class='field-cell field-controls']//span[contains(text(),'Frequency')]")
    @FindBy(xpath ="//div[contains(@class,'control-group')]//div[contains(@class,'ng-scope ng-isolate-scope ng-pristine ng-valid wpnib-drop-down')]//div[contains(@class,'control-well')]")
    private WebElement contrib_Frequency;

    @FindBy(xpath="//div[@label='Current KiwiSaver balance']//div[@class='field-cell field-controls']//input")
    private WebElement current_KWBalance;

    @FindBy(xpath="//div[@label='Salary or wages per year (before tax)']//div[@class='field-cell field-controls']//input")
    private WebElement sal_Ary;

    @FindBy(xpath="//div[@label='Voluntary contributions']//div[@class='field-cell field-controls']//input")
    private WebElement voluntary_Contrib;

    @FindBy(xpath="//div[@label='Savings goal at retirement']//div[@class='field-cell field-controls']//input")
    private WebElement savings_Goal;

    @FindBy(xpath="//button[contains(@class,'btn btn-regular btn-results-reveal btn-has-chevron')]")
    private WebElement projections_Button;

    @FindBy(xpath= "//div[@class='field-group-set-portion results-validation-overlay-holder']")
    private WebElementFacade result_Section;


    @FindBy(xpath="//span[@class='result-value result-currency ng-binding']")
    private WebElementFacade amount_Value;

    //methods

    public void Switch_toframe(){ getDriver().switchTo().frame(clc_Frame); }

    public void Check_msg(String message){

        Assert.assertEquals(info_Message.getText(),message);
        // with WebElementFacade could do  infoMessage.shouldContainText(message);
    }

 public void Click_icon(String fieldname){

     //  This is the pattern of the subsequent fields to parameterize
     //   driver.findElement(By.xpath("//div[@class='wpnib-field-employment-status field-group ng-isolate-scope']//div//i[@class='icon']"))
    WebElement icon_Info = getDriver().findElement(By.xpath("//div[@class='wpnib-field-"+fieldname+" field-group ng-isolate-scope']//div//i[@class='icon']"));

     try {
         //normal click produces ElementClickInterceptedException occasionally

         WebDriverWait wait = new WebDriverWait(getDriver(),15);
         wait.until(ExpectedConditions.elementToBeClickable(icon_Info));
         Actions action = new Actions(getDriver());
         action.click(icon_Info).perform();

}
catch(ElementClickInterceptedException e) {
    System.out.println(e);

}

                                        }
    public void Enter_age(int testcaseno) throws IOException, InvalidFormatException {

           Read_Excel.read(testcaseno);
           current_Age.sendKeys(Read_Excel.columnName("Current Age"));

    }

    //enter all other details based on Employment Status
    public void Enter_otherdetails()
    {
      employment_Status.click();
      String employmentvalue = Read_Excel.columnName("Employment Status");
      getDriver().findElement(By.xpath("//div[@label='Employment status']//div[@class='field-cell field-controls']//span[contains(text(),'"+employmentvalue+"')]")).click();

        if(employmentvalue.equalsIgnoreCase("Employed")){
           Enter_salary();
           Enter_kwcontrib();
           Enter_pir();
           Select_riskprofile();
        }
        else
        {
            Enter_kwbalance();
            Enter_pir();
            Enter_volcontrib();
            Enter_frequency();
            Select_riskprofile();
            Enter_savingsgoal();
        }

    }

    public void Enter_pir() {

        presc_Investorrate.click();
        String pirvalue = Read_Excel.columnName("PIR");
        getDriver().findElement(By.xpath("//div[@label='Prescribed investor rate (PIR)']//div[@class='field-cell field-controls']//span[contains(text(),'" + pirvalue + "%')]")).click();
    }


    public void Enter_salary() { sal_Ary.sendKeys(Read_Excel.columnName("Salary")); }

    public void Enter_kwbalance() { current_KWBalance.sendKeys(Read_Excel.columnName("Current KiwiSaver Balance")); }

    public void Enter_volcontrib() { voluntary_Contrib.sendKeys(Read_Excel.columnName("Voluntary Contribution")); }

    public void Enter_savingsgoal() { savings_Goal.sendKeys(Read_Excel.columnName("Savings goal")); }

    public void Enter_kwcontrib() {

        String contribution = Read_Excel.columnName("Contribution");
        getDriver().findElement(By.xpath("//div[@label='KiwiSaver member contribution']//input[@value='"+ contribution + "']")).click();
    }

    public void Select_riskprofile() {

        String riskprofile = Read_Excel.columnName("Risk Profile");
        getDriver().findElement(By.xpath("//div[@label='Risk profile']//input[@value='"+riskprofile+"']")).click();
    }


    public void Enter_frequency() {

        contrib_Frequency.click();
        String frequency = Read_Excel.columnName("Frequency");
        getDriver().findElement(By.xpath("//div[@label='Voluntary contributions']//div[@class='field-cell field-controls']//span[contains(text(),'"+frequency+"')]")).click();
    }

    public void Click_projbtn(){projections_Button.click(); }

    //check the graph table section
    public void Graph_section() { result_Section.shouldBeVisible();amount_Value.shouldBeVisible(); }

}
