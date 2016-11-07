package com.davidbaena.qa.pages.web;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.util.Page;
import com.davidbaena.qa.domain.RepositoryModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class RepositoryPage extends Page{

    @FindBy(className = "commits")
    WebElement commitsButton;

    @FindBy(xpath = "//*[@itemprop='name']/a")
    WebElement repoName;


    public void goToCommitsSection(){
        commitsButton.click();
    }

    public RepositoryPage(ParetoWeb paretoWeb) {
        super(paretoWeb.getDriver());
        decorate(this);
    }

    public void existsRepository(RepositoryModel repositoryModel){
        assertThat(repoName.getText(),is(repositoryModel.getName()));

    }


}
