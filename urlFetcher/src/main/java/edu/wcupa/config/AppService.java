package edu.wcupa.config;

import edu.wcupa.core.Database;
import edu.wcupa.resources.FetcherResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class AppService extends Application<AppConfig> {

    public static void main(String[] args) throws Exception{
        new AppService().run(args);
    }

    public void run(AppConfig appConfig, Environment environment) throws Exception {
        environment.jersey().register(FetcherResource.class);
        System.out.println("INFO: " + environment.jersey().getProperty("baseuri"));
        Database.initDB();

    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {

    }

}
