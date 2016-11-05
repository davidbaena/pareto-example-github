package com.davidbaena.qa.pages.web;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.util.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Copyright 2016 (C) BQ
 */
public class CommitsPage extends Page {

    @FindBy(className = "message")
    List<WebElement> commitList;

    public CommitsPage(ParetoWeb paretoWeb) {
        super(paretoWeb.getDriver());
        decorate(this);
    }

    public void goToLastCommit(){
        commitList.get(0).click();
    }
}
