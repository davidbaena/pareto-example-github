# pareto-example-github
Pareto Example for VLC Testing 2016

This example uses pareto framework (0.3.2): 
https://github.com/bq/pareto


```
  Scenario:
    Given login with correct user
    When access repository
    Then exists commit
```

Manage appium and driver in setup and teardown:
```
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
```

Use PageObject pattern to interact with the User Interface:
http://martinfowler.com/bliki/PageObject.html

```
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
    ...
 }
```

Provides configuration throught Owner Framework:
```
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:default.properties",
        "classpath:ProjectConfig.properties"})
public interface GithubConfigApp extends AndroidAppConfig {

    @Config.Key("github.username")
    String github_username();

    @Config.Key("github.password")
    String github_password();

    @Config.Key("github.repodescription")
    String github_repodescription();

}
```
