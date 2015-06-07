package org.darcstarsolutions.twitter.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.social.twitter.api.TweetData;
import org.springframework.social.twitter.api.Twitter;

/**
 * Created by mharris on 6/7/15.
 */

@SpringBootApplication
@EnableConfigurationProperties
public class Application implements CommandLineRunner {

    @Autowired
    private Twitter twitter;

    @Autowired
    private TweetData tweetData;

    @Autowired
    private EmbeddedWebApplicationContext server;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application authorization is: " + twitter.isAuthorized());
        twitter.timelineOperations().updateStatus(tweetData);
        server.getEmbeddedServletContainer().stop();
    }
}
