package org.westpac.steps;

import net.thucydides.core.annotations.Step;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.westpac.pages.Home_LandingPage;
import org.westpac.pages.Kiwisaver_CalculatorPage;
import org.westpac.pages.Kiwisaver_RetirementPage;
import java.io.IOException;


public class KiwiSaverRetirement_Steps {

    Home_LandingPage Home;
    Kiwisaver_CalculatorPage KW_Calculator;
    Kiwisaver_RetirementPage KW_Retirement;


    @Step
    public  void Navigate_toKiwiSaverCalculatorPage() { Home.Home_open(); }

    @Step
    public  void Navigate_toRetirementCalculatorPage() { KW_Calculator.Retnmt_calc(); }

    @Step
    public  void Click_infobtn(String fieldname) { KW_Retirement.Switch_toframe(); KW_Retirement.Click_icon(fieldname); }

    @Step
    public  void Check_msgtext(String message) {  KW_Retirement.Check_msg(message); }

    @Step
    public  void Get_details(int testcaseno) throws IOException, InvalidFormatException {

          KW_Retirement.Switch_toframe();
          KW_Retirement.Enter_age(testcaseno);
          KW_Retirement.Enter_otherdetails();
          KW_Retirement.Click_projbtn();
    }

    @Step
    public void Section_displayed()
    {
        KW_Retirement.Graph_section();
    }

}
