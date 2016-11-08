package com.davidbaena.qa.cucumber.steps;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.davidbaena.qa.config.GithubConfigApp;
import com.davidbaena.qa.pages.app.SignInPage;
import cucumber.api.java.en.And;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginSteps{

    private final ParetoApp<AndroidDriver,GithubConfigApp> paretoApp;
    private AndroidDriver androidDriver;
    private SignInPage signInPage;

    public LoginSteps(){
        paretoApp = ParetoApp.<AndroidDriver,GithubConfigApp>getInstance(GithubConfigApp.class);
        androidDriver= paretoApp.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver,paretoApp.getConfig().driver_timeout(), TimeUnit.SECONDS),this);


        signInPage = new SignInPage(paretoApp);
    }


    @And("^login with correct user$")
    public void loginWithCorrectUser() {
        String username = paretoApp.getConfig().github_username();
        String password = paretoApp.getConfig().github_password();
        signInPage.login(username,password);
    }


}
