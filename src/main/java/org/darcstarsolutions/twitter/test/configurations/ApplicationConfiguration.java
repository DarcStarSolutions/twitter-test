package org.darcstarsolutions.twitter.test.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.TweetData;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * Created by mharris on 6/7/15.
 */

@Configuration
@EnableConfigurationProperties(TwitterConfiguration.class)
public class ApplicationConfiguration {

    @Autowired
    private TwitterConfiguration configuration;

    @Bean
    public Twitter twitter() {
        Twitter twitter = new TwitterTemplate(configuration.getConsumerKey(), configuration.getConsumerSecret(), configuration.getAccessToken(), configuration.getAccessTokenSecret());
        return twitter;
    }

    @Bean
    public TweetData tweetData() {
        TweetData tweetData = new TweetData("This is a test of Spring Social");
        return tweetData;
    }
}
