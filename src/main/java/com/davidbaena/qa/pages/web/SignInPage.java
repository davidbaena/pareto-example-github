package com.davidbaena.qa.pages.web;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.bq.qa.pareto.web.util.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Page<ChromeDriver> {

///LOCATORS
    @FindBy(id="login_field")
    private WebElement inputEditText;

    @FindBy(id="password")
    private  WebElement passwordEditText;

    @FindBy(xpath = "//*[@name=\"commit\"]")
    public WebElement submitButton;

    public SignInPage(ParetoWeb paretoWeb) {
        super((ChromeDriver) paretoWeb.getDriver());
        this.webDriver=paretoWeb.getDriver();
        decorate(this); ///<---- DECORATE
    }

    public void login(String username,String password){
        inputEditText.sendKeys(username);
        passwordEditText.sendKeys(password);

        submitButton.click();

    }

}
