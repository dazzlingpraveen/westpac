package org.westpac.pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class Kiwisaver_CalculatorPage extends PageObject {

    //webelements

    @FindBy(xpath="//a[@href='/kiwisaver/calculators/kiwisaver-calculator/']")
    private WebElement btn_Getstarted;

@Step
 public  void Retnmt_calc()
 {

        try {
            btn_Getstarted.click();
            }
        catch(ElementNotFoundException e)
            {
                System.out.println(e);
            }

 }

                                                            }
