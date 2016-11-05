package com.davidbaena.qa.config;

import com.bq.qa.pareto.web.config.ParetoWebConfig;
import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:default.properties",
        "classpath:ProjectConfig.properties"})
public interface GithubConfigWeb extends ParetoWebConfig{

    @Config.Key("github.username")
    String github_username();

    @Config.Key("github.password")
    String github_password();

    @Config.Key("github.repodescription")
    String github_repodescription();

}