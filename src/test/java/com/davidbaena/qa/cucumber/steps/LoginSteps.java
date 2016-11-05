package com.davidbaena.qa.cucumber.steps;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.davidbaena.qa.config.GithubConfigWeb;
import com.davidbaena.qa.pages.web.HomePage;
import com.davidbaena.qa.pages.web.SignInPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps{

    private final ParetoWeb<ChromeDriver,GithubConfigWeb> paretoWeb;
    private final HomePage homePage;
    public WebDriver webDriver;
    private SignInPage signInPage;

    public LoginSteps(){
        paretoWeb = ParetoWeb.<ChromeDriver,GithubConfigWeb>getInstance(GithubConfigWeb.class);
        signInPage = new SignInPage(paretoWeb);
        homePage = new HomePage(paretoWeb);
        this.webDriver=paretoWeb.getDriver();
    }

    @Given("^GitHub webpage$")
    public void go_to_github(){
        String url = paretoWeb.getConfig().driver_endpoint();
        webDriver.get(url);
    }


    @When("^login with correct user$")
    public void loginWithCorrectUser() {
        String username = paretoWeb.getConfig().github_username();
        String password = paretoWeb.getConfig().github_password();
        signInPage.login(username,password);
    }

    @When("^go to sign in")
    public void goToSignUp(){
        homePage.gotToSignIn();
    }
}
