package Model;

import java.util.Date;

public class XMLInterpreter {
	
	class XMLNode {
		//The specific reddit link that this file came from
		public String redditLink;
		//The reddit user that posted this specific link
		public String redditUser;
		//The date and time this link was posted
		public Date redditLinkDate;
		//If there are tags available for this file we will add them here
		public String[] tags;
		//The name of the file so we can reference it. NOTE: This should only include the file name and not the path. The path will be determined somewhere else
		public String fileName;
		//The amount of points that this post received
		public int totalKarma;
		
		
	}
}
