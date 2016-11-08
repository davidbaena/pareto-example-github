package com.davidbaena.qa.cucumber.steps;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.davidbaena.qa.config.GithubConfigApp;
import com.davidbaena.qa.domain.RepositoryModel;
import com.davidbaena.qa.pages.app.DashboardPage;
import com.davidbaena.qa.pages.app.RepositoryPage;
import cucumber.api.java.en.Then;

public class RepositorySteps {

    private final RepositoryPage repositoryPage;
    private AndroidDriver androidDriver;
    private ParetoApp<AndroidDriver,GithubConfigApp> paretoApp;

    private DashboardPage dashboardPage;
    private RepositoryModel ANY_REPOSITORY;
    private RepositoryModel repositoryModel;

    public RepositorySteps(){
        paretoApp = ParetoApp.<ChromeDriver,GithubConfigApp>getInstance(GithubConfigApp.class);
        androidDriver=paretoApp.getDriver();

        dashboardPage = new DashboardPage(paretoApp);
        repositoryPage= new RepositoryPage(paretoApp);

    }

    @Then("^access repository$")
    public void existsRepository() {
        repositoryModel = new RepositoryModel("ANY_REPO1478548040075");
        dashboardPage.accessToRepo(repositoryModel);
    }

    @Then("^exists commit")
    public void existCommit(){
        repositoryPage.goToCommitsSection();
        repositoryPage.accessToCommit("a54ef73745");
    }
}
