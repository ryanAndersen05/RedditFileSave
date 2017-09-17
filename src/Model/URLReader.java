package Model;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;


public class URLReader {
	
	/**
	 * This method will attempt to fetch the HTML from the provided url string
	 * that is provided. If it fails to fetch anything, it will simple return null
	 * @param url
	 * @return
	 */
	public static String GetFullHTMLFromURL(String url, String cookie) {
		
		
		try {
			URLConnection connection = GetConnection(url, cookie);
			InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(inputStream);
			String fullHTMLText = "";
			String line = br.readLine();
			while (line != null) {
				fullHTMLText += (line + "\n");
				line = br.readLine();
			}
			br.close();
			return fullHTMLText;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String GetFullHTMLFromURL(String url) {
		return GetFullHTMLFromURL(url, "");
	}
	
	public static URLConnection GetConnection(String url) {
		return GetConnection(url, "");
	}
	
	public static URLConnection GetConnection(String url, String cookie) {
		URL u = null;
		try {
			u = new URL(url);
			
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		URLConnection connection = null;
		try {
			connection = u.openConnection();
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		connection.setReadTimeout(5000);
		connection.setDoOutput(true);
		connection.setRequestProperty("Cookie", cookie);
		return connection;
	}
	
	public static boolean WriteToConnection (HttpURLConnection connection, String data) {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
			pw.write(data);
			pw.close();
			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
