package com.davidbaena.qa.pages.web;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.bq.qa.pareto.web.util.Page;
import com.davidbaena.qa.domain.RepositoryModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewRepositoryPage extends Page<ChromeDriver> {

    @FindBy(id = "repository_name")
    WebElement repositoryNameEditText;


    @FindBy(id="repository_description")
    WebElement repositoryDescription;

    @FindBy(xpath = "//div[@class=\"with-permission-fields\"]//button[@type=\"submit\"]")
    WebElement createRepositoryButton;


    @FindBy(id="repository_public_true")
    WebElement publicRepositoryRadioButton;


    @FindBy(id="repository_public_false")
    WebElement privateRepositoryRadioButton;

    @FindBy(id = "repository_auto_init")
    WebElement initRespositoryCheck;

    public NewRepositoryPage(ParetoWeb paretoWeb) {
        super((ChromeDriver) paretoWeb.getDriver());
        decorate(this);
    }

    public void createRepository(RepositoryModel repositoryViewModel){

        repositoryNameEditText.sendKeys(repositoryViewModel.getName());
        repositoryDescription.sendKeys(repositoryViewModel.getDescription());
        setRepositoryPrivacy(repositoryViewModel);
        initializeRepo(repositoryViewModel);
        createRepositoryButton.click();
    }

    private void initializeRepo(RepositoryModel repositoryViewModel) {
        if(repositoryViewModel.isInitialized())
            initRespositoryCheck.click();
    }


    private void setRepositoryPrivacy(RepositoryModel repositoryViewModel) {
        if(repositoryViewModel.isPublic())
            publicRepositoryRadioButton.click();
        else
            privateRepositoryRadioButton.click();
    }


}
