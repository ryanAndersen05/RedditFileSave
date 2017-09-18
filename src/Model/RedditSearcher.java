package Model;

import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.lang.Thread;

public class RedditSearcher {
	public final String REDDIT_LOGIN_URL = "https://ssl.reddit.com/api/login";
	private final String userName = "RedditSaveFileBot";
	private final String password = "rsfb123";
	
	private String redditCookie = "";
	
	/**
	 * Logs us into reddit so that we can access areas related to our user
	 * @return
	 */
	public boolean loginToReddit() {
		URLConnection connection = URLReader.GetConnection(REDDIT_LOGIN_URL);
		System.out.println("Step 1");
		if (connection == null) return false;
		System.out.println("Step 2");
		String data = "user=" + userName + "&passwd=" + password;
		if (!URLReader.WriteToConnection((HttpURLConnection)connection, data))
			return false;
		System.out.println("Step 3");
		String cookie = connection.getHeaderField("set-cookie");
		
		if (cookie == null) return false;
		System.out.println("Step 4");
		System.out.println(cookie);
		cookie = cookie.split(";")[0];
		System.out.println("Cookie: " + cookie);
		if (cookie.startsWith("reddit_first")) {
			System.out.println("Unable to Login");
			return false;
		}
		else if (cookie.startsWith("reddit_session")) {
			System.out.print("Successful login");
			redditCookie = cookie;
			return true;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
