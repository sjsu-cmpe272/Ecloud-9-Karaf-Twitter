package com.twitexample.controller;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import twitter4j.Friendship;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
//import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.DirectMessage;


public class CreateFriendshipTest {

	static String consumerKeyStr = "xxxxxxxxxxxxx";
	static String consumerSecretStr = "xxxxxxxxxxxxxxxx";
	static String accessTokenStr = "xxxxxxxxxxx-xxxxxxxxxxxxxxxxxxx";
	static String accessTokenSecretStr = "xxxxxxxxxxxxxxxxxx";
	
	
	//private static Twitter twitter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Starting the test Twitter Rest API v1.1...");
		Twitter twitter = new TwitterFactory().getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Finished testing the class!");
	}

	@Test
	public void testStatus() throws Exception {
		Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);
		twitter.setOAuthAccessToken(accessToken);
		
		String twitterName = "realDonaldTrump";

	        twitter4j.User user = twitter.createFriendship(twitterName);
	          
	           ResponseList<Friendship> friendships = twitter.lookupFriendships("realDonaldTrump");
	           for (Friendship friendship : friendships) {
	        	   System.out.println("@" + friendship.getScreenName()
                   + " following: " + friendship.isFollowing());
                    
                    assertTrue("Donald J Trump is followed", friendship.isFollowing());
	           }
		
	}
	
	
	public void onUnfollow(User source, User unfollowedUser) {
        System.out.println("onunfollow");
        this.source = source;
        this.target = unfollowedUser;
        received.add(new Object[]{DESTROY_FRIENDSHIP, source, unfollowedUser});
        Assert.assertNotNull(TwitterObjectFactory.getRawJSON(source));
        Assert.assertNotNull(TwitterObjectFactory.getRawJSON(unfollowedUser));
        notifyResponse();
    }
	
}




