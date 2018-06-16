package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("user1");
        User user2 = new YGeneration("user2");
        User user3 = new ZGeneration("user3");
        //When
        String user1shouldPublish = user1.sharePost();
        String user2shouldPublish = user2.sharePost();
        String user3shouldPublish = user3.sharePost();
        //Then
        Assert.assertEquals("Shared on Twitter.", user1shouldPublish);
        Assert.assertEquals("Shared on Snapchat.", user2shouldPublish);
        Assert.assertEquals("Shared on Facebook.", user3shouldPublish);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User user = new Millenials("user");
        //When
        user.setSocialPublisher(new FacebookPublisher());
        String userShouldPublish = user.sharePost();
        //Then
        Assert.assertEquals("Shared on Facebook.", userShouldPublish);
    }

}