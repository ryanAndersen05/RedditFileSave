package Model;

public class FileSaveMain {
	public static void main(String[] args) { 
		RedditSearcher rs = new RedditSearcher();
		
		System.out.println(URLReader.GetFullHTMLFromURL("https://www.reddit.com/r/gonewildaudio/"));
	}
}
