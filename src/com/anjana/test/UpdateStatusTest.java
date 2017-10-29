package com.twitexample.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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


public class UpdateStatusTest {

	static String consumerKeyStr = "xxxxxxxxxxxxxxxxx";
	static String consumerSecretStr = "xxxxxxxxxxxxxxxxxxxxx";
	static String accessTokenStr = "xxxxxxxxxxxxxxx-xxxxxxxxxxxxxxxxxxx";
	static String accessTokenSecretStr = "xxxxxxxxxxxxxxxxxxxxxx";
	
	
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
		
		for (int c =28; c <=30; c++) {

			String statusActual = twitter.getScreenName()
					+ " Test- Update Status from Twitter4j API calls "+c +"app AuthTwitter"
					+ c + " e-cloud9";
			Status status = twitter.updateStatus(statusActual);
			assertNotNull(TwitterObjectFactory.getRawJSON(status));
			assertNotNull(TwitterObjectFactory.getRawJSON(status.getText()));
			assertEquals(statusActual, status.getText());

		}	
		
	}
	
	
}




