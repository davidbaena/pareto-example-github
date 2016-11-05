package com.davidbaena.qa.cucumber.steps;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.davidbaena.qa.config.GithubConfigWeb;
import org.openqa.selenium.WebDriver;

public class RepositorySteps {

    private final ParetoWeb paretoWeb;
    public WebDriver webDriver;

    public RepositorySteps(){
        paretoWeb = ParetoWeb.<ChromeDriver,GithubConfigWeb>getInstance(GithubConfigWeb.class);
        this.webDriver=paretoWeb.getDriver();
    }

}
