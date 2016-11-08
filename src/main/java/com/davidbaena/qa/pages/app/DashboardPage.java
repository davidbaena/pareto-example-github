package com.davidbaena.qa.pages.app;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.util.Page;
import com.davidbaena.qa.domain.RepositoryModel;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DashboardPage extends Page<AndroidDriver>{


    @WithTimeout(time = 20,unit = TimeUnit.SECONDS)
    @FindBy(xpath = "//android.widget.TextView[@text='repositorios']")
    AndroidElement repositoriesHome;

    @FindBy(id = "jp.forkhub:id/tv_repo_name")
    List<AndroidElement> repositoryTextView;

    public DashboardPage(ParetoApp paretoApp) {
        super((AndroidDriver) paretoApp.getDriver());
        decorate(this);
    }

    public void goToRepositories() {
        repositoriesHome.click();
    }

    public void accessToRepo(RepositoryModel repositoryModel) {
        goToRepositories();
        for (AndroidElement repo : repositoryTextView) {
            if(repo.getText().equals(repositoryModel.getName())){
                repo.click();
                break;
            }
        }
    }

}
