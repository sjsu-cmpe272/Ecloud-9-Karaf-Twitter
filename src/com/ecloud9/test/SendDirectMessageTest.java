package com.twitexample.controller;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import twitter4j.Friendship;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
//import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.DirectMessage;


public class SendDirectMessageTest {

	static String consumerKeyStr = "xxxxxxxxxxxxxx";
	static String consumerSecretStr = "xxxxxxxxxxxxxxxxxxxxx";
	static String accessTokenStr = "xxxxxxxxxxxxxxx-xxxxxxxxxxxxxxxxxxxx";
	static String accessTokenSecretStr = "xxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	
	

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
		
		String message = "Hello creating a new test message for your inbox";
		String senderScreenName = "name";
		DirectMessage directMessage = null;
		
     	directMessage = twitter.sendDirectMessage(senderScreenName, message);
	    assertEquals(message, directMessage.getText());
		         
		
	}
}




