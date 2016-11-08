package com.davidbaena.qa;


import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.server.AppiumServer;
import com.davidbaena.qa.config.GithubConfigApp;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberTest{
    public static final String UDID_ANDROID = "default";

    ParetoApp<AndroidDriver,GithubConfigApp> paretoApp;
    private AppiumServer appiumServer;
    private AndroidDriver androidDriver;

    @Before
    public  void beforeScenario() throws Exception {
        paretoApp = ParetoApp.<AndroidDriver,GithubConfigApp>getInstance(GithubConfigApp.class);
        appiumServer = paretoApp.createAppiumServer(UDID_ANDROID, ParetoApp.ANDROID);
        androidDriver = paretoApp.createDriver(appiumServer.getURL(), ParetoApp.ANDROID);
    }

    @After
    public  void afterScenario() throws Exception {
        androidDriver.quit();
        appiumServer.stop();
    }
}
