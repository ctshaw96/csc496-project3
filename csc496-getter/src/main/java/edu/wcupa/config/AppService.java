package edu.wcupa.config;

import edu.wcupa.resources.PersonResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class AppService extends Application<AppConfig> {

    public static void main(String[] args) throws Exception{
        new AppService().run(args);
    }

    public void run(AppConfig appConfig, Environment environment) throws Exception {
        environment.jersey().register(PersonResource.class);
        System.out.println("INFO: " + environment.jersey().getProperty("baseuri"));
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {

    }

}
