package com.davidbaena.qa.cucumber.steps;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.davidbaena.qa.config.GithubConfigWeb;
import com.davidbaena.qa.domain.RepositoryModel;
import com.davidbaena.qa.pages.web.DashboardPage;
import com.davidbaena.qa.pages.web.NewRepositoryPage;
import com.davidbaena.qa.pages.web.RepositoryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class RepositorySteps {

    private final ParetoWeb paretoWeb;
    private final NewRepositoryPage newRepositoryPage;
    private WebDriver webDriver;
    private DashboardPage dashboardPage;
    private RepositoryPage repositoryPage;
    private RepositoryModel ANY_REPOSITORY;

    public RepositorySteps(){
        paretoWeb = ParetoWeb.<ChromeDriver,GithubConfigWeb>getInstance(GithubConfigWeb.class);
        webDriver=paretoWeb.getDriver();

        dashboardPage = new DashboardPage(paretoWeb);
        repositoryPage= new RepositoryPage(paretoWeb);
        newRepositoryPage = new NewRepositoryPage(paretoWeb);

    }

    @When("create a new repository")
    public void crete_a_new_repository(){
        dashboardPage.goToCreateRepository();
        ANY_REPOSITORY = new RepositoryModel();
        newRepositoryPage.createRepository(ANY_REPOSITORY);
    }


    @Then("^exists repository$")
    public void existsRepository() {
        repositoryPage.existsRepository(ANY_REPOSITORY);
    }
}
