package Model;
import java.net.URLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


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
				fullHTMLText += line;
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

}
