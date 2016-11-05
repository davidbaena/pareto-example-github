package com.davidbaena.qa;


import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.davidbaena.qa.config.GithubConfigWeb;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberTest{
    public static final String UDID_ANDROID = "default";
    private ChromeDriver webDriver;

    ParetoWeb<ChromeDriver,GithubConfigWeb> paretoWeb;

    @Before
    public  void beforeScenario() throws Exception {
        paretoWeb = ParetoWeb.<ChromeDriver,GithubConfigWeb>getInstance(GithubConfigWeb.class);

        paretoWeb.createLocalServer();
        paretoWeb.getLocalServer().startSeleniumServer();

        webDriver = paretoWeb.createDriver(ParetoWeb.BROWSER.CHROME);
        webDriver.manage().window().maximize();
    }

    @After
    public  void afterScenario() throws Exception {
        paretoWeb.getDriver().quit();
        paretoWeb.getLocalServer().stopSeleniumServer();

    }
}
