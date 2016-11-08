package com.davidbaena.qa.pages.app;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.util.Page;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class RepositoryPage extends Page<AndroidDriver>{


    @FindBy(xpath = "//android.widget.TextView[@text='commits']")
    AndroidElement commitsButton;

    @FindBy(id="jp.forkhub:id/tv_commit_id")
    List<AndroidElement> commitList;

    public void goToCommitsSection(){
        commitsButton.click();
    }

    public RepositoryPage(ParetoApp paretoApp) {
        super((AndroidDriver) paretoApp.getDriver());
        decorate(this);
    }

    public void accessToCommit(String commit){
                for(AndroidElement commitItem: commitList){
                        if(commitItem.getText().equals(commit)){
                            commitItem.click();
                            break;
                        }
                }
    }


}
