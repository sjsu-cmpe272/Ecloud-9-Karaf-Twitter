package com.twitexample.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
import twitter4j.TwitterObjectFactory;
//import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.DirectMessage;


public class DestroyFriendshipTest {

	static String consumerKeyStr = "xxxxxxxxxx";
	static String consumerSecretStr = "xxxxxxxxxxxxx";
	static String accessTokenStr = "xxxxxxxxxx-xxxxxxxxxxxxx";
	static String accessTokenSecretStr = "xxxxxxxxxxxxxxxxxxx";
	
	
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
		 twitter4j.User source = twitter.destroyFriendship(twitterName);	 	           
		 ResponseList<Friendship> friendships = twitter.lookupFriendships("realDonaldTrump");
		 	 for (Friendship friendship : friendships) {
		 	  System.out.println("@" + friendship.getScreenName()
		           + " following: " + friendship.isFollowing());
		           assertFalse("Donald J Trump is followed",friendship.isFollowing());	                    
		 	 }
	}
	
	@Override
	public void onUnfollow(twitter4j.User source, twitter4j.User unfollowedUser) {
        System.out.println("onunfollow");
        assertNotNull(TwitterObjectFactory.getRawJSON(source));
        assertNotNull(TwitterObjectFactory.getRawJSON(unfollowedUser));
    }
	
}




