package com.davidbaena.qa.pages.web;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.util.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Copyright 2016 (C) BQ
 */
public class DashboardPage extends Page {

    @FindBy(xpath = "//*[@id=\"user-links\"]/li[2]")
    WebElement newButton;

    @FindBy(xpath = "//*[@id=\"user-links\"]/li[2]")
    WebElement profileButton;

    @FindBy(id="your-repos-filter")
    WebElement reposFilterEditText;

    @FindBy(className = "boxed-group-action")
    WebElement newRepositoryButton;

    public DashboardPage(ParetoWeb paretoWeb) {
        super(paretoWeb.getDriver());
        decorate(this);
    }

    public void goToCreateRepository(){
        newRepositoryButton.click();
    }

}
