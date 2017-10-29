package com.ecloud9.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecloud9.forms.twitterFriendship;
import com.ecloud9.forms.twitterStatus;

import twitter4j.DirectMessage;
import twitter4j.Friendship;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

@Controller
public class twitterAPI {
	static String consumerKeyStr = "ctNiMacyHwi6J4qKigJ9dRIHc";
	static String consumerSecretStr = "f76HB2JobTqG11r06xTv3BtDh8YiIj1KsjqRP3Xc0ZKdX7cuQO";
	static String accessTokenStr = "918993529887637505-L0sHjh9XzC2PxHYdpm0yhwUdnCp68jW";
	static String accessTokenSecretStr = "UXgL1TpyXECQJetslkFi4B96qAcMyhx36whobfbm88FEX";

	@RequestMapping(method = RequestMethod.POST, value = "/updateTwitter")
	public String updateStatus(HttpServletRequest request, HttpSession session) throws TwitterException {

		TwitterFactory factory = new TwitterFactory();
		Twitter twitter = factory.getInstance();

		twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);

		twitter.setOAuthAccessToken(accessToken);
		// twitter4j.User user = twitter.createFriendship(twitterName);
		// System.out.println("Successfully following the user.");
		String status = request.getParameter("updateField");
		System.out.println("+++++++++" + status);
		twitter.updateStatus(status);
		request.setAttribute("status", "Status " + "" + "'" + status + "'" + "" + "updated successfully");
		return "UpdateSuccess";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/followUser")
	public String followUsers(HttpServletRequest request, HttpSession session) throws TwitterException {

		// String twitterName = "priyankachopra";
		TwitterFactory factory = new TwitterFactory();
		Twitter twitter = factory.getInstance();

		twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);

		twitter.setOAuthAccessToken(accessToken);
		//
		// System.out.println("Successfully following the user.");
		String followUser = request.getParameter("followUser");
		System.out.println("+++++++++" + followUser);
		twitter4j.User user = twitter.createFriendship(followUser);
		request.setAttribute("FollowUser", "Following " + "" + "'" + followUser + "'" + "" + " successfully");
		return "FollowUser";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/unfollowUser")
	public String unfollowUser(HttpServletRequest request, HttpSession session) throws TwitterException {

		// String twitterName = "priyankachopra";
		TwitterFactory factory = new TwitterFactory();
		Twitter twitter = factory.getInstance();

		twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);

		twitter.setOAuthAccessToken(accessToken);
		//
		// System.out.println("Successfully following the user.");
		String unfollowUser = request.getParameter("unfollowUser");
		System.out.println("+++++++++" + unfollowUser);
		twitter4j.User user = twitter.destroyFriendship(unfollowUser);
		request.setAttribute("unFollowUser", "UnFollowed " + "" + "'" + unfollowUser + "'" + "" + " successfully");
		return "unfollowUser";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getUserTimeline")
	public ModelAndView getUserTimeLine(HttpServletRequest request, HttpSession session) throws TwitterException {

		List<twitterStatus> twitterTimelineList = new ArrayList<twitterStatus>();
		ModelAndView view = new ModelAndView();
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);

		twitter.setOAuthAccessToken(accessToken);

		// gets Twitter instance with default credentials
		// Twitter twitter = new TwitterFactory().getInstance();
		User user = twitter.verifyCredentials();
		List<Status> statuses = twitter.getHomeTimeline();
		System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
		for (Status status : statuses) {
			System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
			twitterStatus twitterTimeline = new twitterStatus();
			twitterTimeline.setScreenName(status.getUser().getScreenName());
			twitterTimeline.setText(status.getText());
			twitterTimelineList.add(twitterTimeline);
		}

		view.addObject("status", twitterTimelineList);
		view.setViewName("getTimelineSuccess");
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/getMentionTimeline")
	public ModelAndView getMentionTimeLine(HttpServletRequest request, HttpSession session) throws TwitterException {

		List<twitterStatus> twitterMentionTimelineList = new ArrayList<twitterStatus>();
		ModelAndView view = new ModelAndView();
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);

		twitter.setOAuthAccessToken(accessToken);

		// gets Twitter instance with default credentials
		// Twitter twitter = new TwitterFactory().getInstance();
		User user = twitter.verifyCredentials();
		List<Status> statuses = twitter.getMentionsTimeline();
		System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
		for (Status status : statuses) {
			System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
			twitterStatus twitterTimeline = new twitterStatus();
			twitterTimeline.setScreenName(status.getUser().getScreenName());
			twitterTimeline.setText(status.getText());
			twitterMentionTimelineList.add(twitterTimeline);
		}

		view.addObject("twitterMentionTimelineList", twitterMentionTimelineList);
		view.setViewName("getMentionTimelineSuccess");
		return view;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getFavorites")
	public ModelAndView getFavorites(HttpServletRequest request, HttpSession session) throws TwitterException {

		List<twitterStatus> twitterFavorites = new ArrayList<twitterStatus>();
		ModelAndView view = new ModelAndView();
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);

		twitter.setOAuthAccessToken(accessToken);

		User user = twitter.verifyCredentials();
		List<Status> statuses = twitter.getFavorites();
		System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
		for (Status status : statuses) {
			System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
			twitterStatus twitterTimeline = new twitterStatus();
			twitterTimeline.setScreenName(status.getUser().getScreenName());
			twitterTimeline.setText(status.getText());
			twitterFavorites.add(twitterTimeline);
		}

		view.addObject("twitterFavorites", twitterFavorites);
		view.setViewName("getFavorites");
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/getFriendship")
	public ModelAndView getFriendship(HttpServletRequest request, HttpSession session) throws TwitterException {

		List<twitterFriendship> twitterFriendshipList = new ArrayList<twitterFriendship>();
		ModelAndView view = new ModelAndView();
		Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
        AccessToken accessToken = new AccessToken(accessTokenStr,
                accessTokenSecretStr);

       twitter.setOAuthAccessToken(accessToken);
        User user = twitter.verifyCredentials();
        
       ResponseList<Friendship> friendships = twitter.lookupFriendships("vdyacn");
        for (Friendship friendship : friendships) {
            System.out.println("@" + friendship.getScreenName()
                    + " following: " + friendship.isFollowing()
                    + " followed_by: " + friendship.isFollowedBy());
            twitterFriendship twitterFriendship = new twitterFriendship();
            twitterFriendship.setScreenName(friendship.getScreenName());
            twitterFriendship.setFollowing(friendship.isFollowing());
            twitterFriendship.setFollowedBy(friendship.isFollowedBy());
            twitterFriendshipList.add(twitterFriendship);
        }
        System.out.println("Successfully looked up friendships [" + user.getScreenName() + "].");

		view.addObject("twitterFriendshipList", twitterFriendshipList);
		view.setViewName("getFriendship");
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/sendDirectMessage")
	public String sendDirectMessage(HttpServletRequest request, HttpSession session) throws TwitterException {

		DirectMessage directMessage = null;
		Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
        AccessToken accessToken = new AccessToken(accessTokenStr,
                accessTokenSecretStr);
       String senderScreenName = request.getParameter("userName");
       String message = request.getParameter("message");
       
       twitter.setOAuthAccessToken(accessToken);
       directMessage = twitter.sendDirectMessage(senderScreenName, message);
       request.setAttribute("successMsg", "Direct Message Sent Successfully.");
		return "directMessage";
	}

}
