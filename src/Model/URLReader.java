package Model;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
	public static String GetFullHTMLFromURL(String url) {
		
		
		try {
			URLConnection connection = new URL(url).openConnection();
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
	
	public static URLConnection GetConnection(String url) {
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
		
		connection.setReadTimeout(5000);
		connection.setDoOutput(true);
		return connection;
	}
	
	public static boolean WriteToConnection (URLConnection connection, String data) {
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
