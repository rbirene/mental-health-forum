package views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.h2.mvstore.MVMap;

import model.Post;
import model.Profile;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;
import views.HeaderFooter;

public class ProfilePageview extends DynamicWebPage{

	public ProfilePageview(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
		// TODO Auto-generated constructor stub
	}

	public boolean process(WebRequest toProcess) {
		if(toProcess.path.equalsIgnoreCase("profilepage")) {

			String username = toProcess.cookies.get("username"); 

			MVMap<String, Profile> profiles = db.s.openMap("Profile");
			Profile profile;

			if((username != null) && (profiles.containsKey(username))) {

				profile = profiles.get(username);
			}
			else {
				// Replace with link to login and sign up page

				// Temp profiles for testing
				profile = new Profile();

				profile.username = "Bob";
				profile.email = "bob@gmail.com";
				profile.numOfForumsFollowed = 7;
				profile.numOfPostsMade = 3;
				profile.numOfPostsLiked = 11;

				profiles.put(profile.username, profile);
				db.commit();

				Profile profile2 = new Profile();

				profile2.username = "Jim";
				profile2.email = "Jim@gmail.com";
				profile2.numOfForumsFollowed = 6;
				profile2.numOfPostsMade = 4;
				profile2.numOfPostsLiked = 10;

				profiles.put(profile2.username, profile);
				db.commit();

				toProcess.cookies.put("username", profile.username);
			}

			String image = null;
			if(profile.profileImage == null) {
				image = "userProfilePics/default.png";
			}
			else {
				image = profile.profileImage;
			}

			System.out.println(profile.profileImage);

			String stringToSendToWebBrowser = 
					HeaderFooter.head()+
					HeaderFooter.header() +
					"  <script>\r\n" +
					"      function setCookie(cname, cvalue, exdays)\r\n" +
					"      {\r\n" +
					"          var d = new Date();\r\n" +
					"          d.setTime(d.getTime() + (exdays*24*60*60*1000));\r\n" +
					"          var expires = 'expires='+d.toUTCString();\r\n" +
					"          document.cookie = cname + '=' + cvalue + ';' + expires + ';path=/';\r\n" +
					"      }\r\n" +
					"          setCookie('username','"+profile.username+"',365);\r\n" +
					"          setCookie('password','"+profile.password+"',365);\r\n" +
					"  </script>\r\n"+
					"  <meta charset=\"utf-8\">\r\n" +
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\r\n" + 
				"  <script type=\"text/javascript\" src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\r\n" + 
				"  <link href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
				"  <link href=\"ProfilePageCSS.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"  <div class=\"container\">\r\n" + 
"    <div class=\"row\">\r\n" + 
"      <div class=\"col-md-12\">\r\n" + 
"        <h1 class=\"display-3\">Your profile</h1>\r\n" + 
"      </div>\r\n" + 
"    </div>\r\n" + 
"  </div>\r\n";

			stringToSendToWebBrowser += "  <div class=\"section\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-4\">\r\n" + 
					"          <div class=\"thumbnail\">\r\n" + 
					"            <img src=\""+image+"\" class=\"img-responsive\">\r\n" + 
					"            <div class=\"caption\">\r\n" + 
					"              <h3>Username: "+profile.username+"</h3>\r\n" + 
					"              <h4>Date joined: "+profile.dateJoined+"</h4>\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"          <a href=\"/editProfile\" class=\"button pink-bg\" style=\"padding:8px 46%\">Edit</a>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"col-md-8\">\r\n" + 
					"          <h1>Your details</h1>\r\n" + 
					"          <div class=\"table-responsive\">\r\n" + 
					"            <table class=\"table table-striped table-borderless\">\r\n" + 
					"              <thead>\r\n" + 
					"                <tr>\r\n" + 
					"                  <th scope=\"col\">Email address:</th>\r\n" + 
					"                  <td>"+profile.email+"</td>\r\n" + 
					"                </tr>\r\n" + 
					"              </thead>\r\n" + 
					"              <tbody>\r\n" + 
					"                <tr>\r\n" +

					"                  <th scope=\"col\">Number of forums followed:</th>\r\n" + 
					"                  <td>"+profile.numOfForumsFollowed+"</td>\r\n" + 
					"                </tr>\r\n" + 
					"                <tr>\r\n" + 
					"                  <th scope=\"col\">Number of posts liked:</th>\r\n" + 
					"                  <td>"+profile.numOfPostsLiked+"</td>\r\n" + 
					"                </tr>\r\n" + 
					"                <tr>\r\n" + 
					"                  <th scope=\"col\">Number of posts made:</th>\r\n" + 
					"                  <td>"+profile.numOfPostsMade+"</td>\r\n" + 
					"                </tr>\r\n" + 
					"              </tbody>\r\n" + 
					"            </table>\r\n" + 
					"          </div>\r\n" + 
					"          <h1>Latest posts</h1>\r\n"+
					"          <div class=\"list-group\">\r\n";

			MVMap<String, Post> posts = db.s.openMap("Posts");
			ArrayList keys = new ArrayList(posts.keySet());

			for(int i = keys.size() - 1; i >= 0; i--) {
				Object key = keys.get(i);
				Post post = posts.get(key);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");    
				Date resultdate = new Date(Long.parseLong(post.uniqueid));
				String date = sdf.format(resultdate);

				int numOfComments = post.comments.size();

				stringToSendToWebBrowser +=
						"<div class=\"post-tile\">"+
						"            <a href=\"/post-"+post.uniqueid+"\" class=\"list-group-item list-group-item-action flex-column align-items-start active\">\r\n" + 
								"              <div class=\"d-flex w-100 justify-content-between\">\r\n" +
								"                <h5 class=\"mb-1\">"+post.title+"</h5> <small>"+date+"</small>\r\n" + 
								"              </div>\r\n" + 
								"              <p class=\"mb-1\">"+post.description+"</p> <small>"+numOfComments+" Comments</small>\r\n" + 
								"            </a>\r\n</div>";
			}


			stringToSendToWebBrowser +=
					"          </div>\r\n" + 
							"        </div>\r\n" + 
							"      </div>\r\n" + 
							"    </div>\r\n" + 
							"  </div>\r\n";

			stringToSendToWebBrowser +=
					HeaderFooter.footer();
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser);
			return true;
		}

		return false;
	}
}





