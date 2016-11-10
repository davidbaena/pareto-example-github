package com.davidbaena.qa.pages.web;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.bq.qa.pareto.web.util.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page<ChromeDriver>{

    @FindBy(name="q")
    WebElement searchEditText;

    @FindBy(xpath = "//*[@class='site-header-actions']/a[2]")
    WebElement signUpButton;

    @FindBy(xpath = "//*[@class='site-header-actions']/a[2]")
    WebElement signInButton;

    public HomePage(ParetoWeb paretoWeb) {
        super((ChromeDriver) paretoWeb.getDriver());
        decorate(this);
    }

    public void search(String text){
        searchEditText.sendKeys(text+"\n");
    }

    public void gotToSignIn(){
        signInButton.click();
    }

    public void gotToSignUp(){
        signUpButton.click();
    }
}
