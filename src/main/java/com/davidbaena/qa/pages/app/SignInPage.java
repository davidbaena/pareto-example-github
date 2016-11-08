package com.davidbaena.qa.pages.app;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.util.Page;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Page<AndroidDriver>{

    ///LOCATORS
    @FindBy(id="jp.forkhub:id/et_login")
    private AndroidElement inputEditText;

    @FindBy(id="jp.forkhub:id/et_password")
    private  AndroidElement passwordEditText;

    @FindBy(id = "jp.forkhub:id/m_login")
    public AndroidElement submitButton;

    public SignInPage(ParetoApp paretoApp) {
        super((AndroidDriver) paretoApp.getDriver());
        decorate(this);
    }

    public void login(String username,String password){
        inputEditText.sendKeys(username);
        passwordEditText.sendKeys(password);

        submitButton.click();

    }

}
