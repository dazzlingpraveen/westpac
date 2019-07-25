package org.westpac.pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Home_LandingPage extends PageObject {

        //web elements

        @FindBy(id="ubermenu-section-link-kiwisaver-ps")
        private WebElement btn_Kiwisaver;

        @FindBy(id="ubermenu-item-cta-kiwisaver-calculators-ps")
        private WebElement btn_Kiwisavercalculators;


        //methods below

    //Opens the default URL
        public  void Home_open(){

            open();
            getDriver().manage().window().maximize();
            Actions action = new Actions(getDriver());
            WebDriverWait wait = new WebDriverWait(getDriver(),10);

            //wait until button is visible
            wait.until(ExpectedConditions.visibilityOf(btn_Kiwisaver));
            try {
                action.moveToElement(btn_Kiwisaver).pause(3).build().perform();
                btn_Kiwisavercalculators.click();
            }
            catch(ElementNotFoundException e)
            {
                System.out.println(e);
            }


        }
    }

