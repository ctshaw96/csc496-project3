package edu.wcupa.config;

import edu.wcupa.core.Database;
import edu.wcupa.resources.FetcherResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;


public class AppService extends Application<AppConfig> {

    public static void main(String[] args) throws Exception{
        new AppService().run(args);
    }

    public void run(AppConfig appConfig, Environment environment) throws Exception {
        environment.jersey().register(FetcherResource.class);

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        Database.initDB();

    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {

    }

}
