package com.davidbaena.qa.config;

import com.bq.qa.pareto.apps.config.AndroidAppConfig;
import org.aeonbits.owner.Config;


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