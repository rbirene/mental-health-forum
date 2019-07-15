package views;

import java.util.ArrayList;
import java.util.List;

import org.h2.mvstore.MVMap;

import model.Comment;
import model.Forum;
import model.Post;
import model.Profile;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class IndexView extends DynamicWebPage{

	public IndexView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
		// TODO Auto-generated constructor stub
	}
	
	public boolean process(WebRequest toProcess) {
		
		//call head for all pages
		String stringToSendToWebBrowser = HeaderFooter.head();
				
		//if homepage...
		if(toProcess.path.equalsIgnoreCase("index")) {
			
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			stringToSendToWebBrowser +=
					"    <!--BANNER-->\r\n" + 
					"	<section id=\"banner\" style=\"background-image: url('img/banner-img.jpg');\">\r\n" + 
					"    <div class=\"overlay\"></div>\r\n" + 
					"		<div class=\"container-fluid\">\r\n" + 
					"		  <div class=\"row\">\r\n" + 
					"        <div class=\"offset-1\"></div>\r\n" + 
					"  			<div class=\"col-6\">\r\n" + 
					"  			  <div class=\"text\">\r\n" + 
					"  				<h1>Connect with others who understand</h1>\r\n" + 
					"  				<p>Interact with thousands of supportive people who have been through the same thing</p>\r\n" + 
					"  				<a href=\"#\"><button class=\"button pink-bg\">Register</button></a>\r\n" + 
					"  			  </div>\r\n" + 
					"  			</div>\r\n" + 
					"		  </div>\r\n" + 
					"		</div>\r\n" + 
					"	</section>\r\n" + 
					"\r\n" + 
					"    <!--INFO-->\r\n" + 
					"	<section id=\"info\">\r\n" + 
					"		<div class=\"container\">\r\n" + 
					"		  <div class=\"row d-flex justify-content-center\">\r\n" + 
					"  			<div class=\"col-3 text-center\">\r\n" + 
					"  			  <span><i class=\"fa fa-globe fa-3x\" aria-hidden=\"true\"></i></span>\r\n" + 
					"  			  <h4>Join a Community</h4>\r\n" + 
					"  			  <p>Access support and advice 24/7</p>\r\n" + 
					"  			</div>\r\n" + 
					"  			<div class=\"col-3 text-center\">\r\n" + 
					"  			  <span><i class=\"fa fa-comments fa-3x\" aria-hidden=\"true\"></i></span>\r\n" + 
					"  			  <h4>Ask Questions</h4>\r\n" + 
					"  			  <p>Get answers from those who understand</p>\r\n" + 
					"  			</div>\r\n" + 
					"  			<div class=\"col-3 text-center\">\r\n" + 
					"  			  <span><i class=\"fa fa-users fa-3x\" aria-hidden=\"true\"></i></span>\r\n" + 
					"  			  <h4>Find New Friends</h4>\r\n" + 
					"  			  <p>Find others like you, near to you</p>\r\n" + 
					"  			</div>\r\n" + 
					"		  </div>\r\n" + 
					"		</div>\r\n" + 
					"	</section>\r\n" + 
					"\r\n" + 
					"    <!--FORUMS-->\r\n" + 
					"	<section id=\"forums\">\r\n" + 
					"		<div class=\"container-fluid\">\r\n" + 
					"		  <div class=\"row d-flex align-items-center\">\r\n" + 
					"            	<div class=\"col-12\">\r\n" + 
					"            	  <h2 class=\"text-center\">Popular Forums</h2>\r\n" + 
					"            	</div>\r\n" + 
					"            </div>\r\n" + 
					"			<br>" +
					"          	<div class=\"row d-flex justify-content-center\">\r\n";
			
			MVMap<String, Forum> forums = db.s.openMap("Forums");

			List<String> forumKeys = forums.keyList();

			//add forums to database if there are none already
			if(forumKeys.size()==0)
			{
				
				Forum addiction = new Forum();
				addiction.uniqueid = ""+System.currentTimeMillis();
				addiction.title = "Addiction";
				forums.put(addiction.uniqueid, addiction);
				db.commit();
				
				Forum anxiety = new Forum();
				anxiety.uniqueid = ""+System.currentTimeMillis();
				anxiety.title = "Anxiety Disorders";
				forums.put(anxiety.uniqueid, anxiety);
				db.commit();
				
				Forum bipolar = new Forum();
				bipolar.uniqueid = ""+System.currentTimeMillis();
				bipolar.title = "Bipolar Disorder";
				forums.put(bipolar.uniqueid, bipolar);
				db.commit();
				
				Forum dysmorphia = new Forum();
				dysmorphia.uniqueid = ""+System.currentTimeMillis();
				dysmorphia.title = "Body Dysmorphic Disorder";
				forums.put(dysmorphia.uniqueid, dysmorphia);
				db.commit();
				
				Forum dementia = new Forum();
				dementia.uniqueid = ""+System.currentTimeMillis();
				dementia.title = "Dementia";
				forums.put(dementia.uniqueid, dementia);
				db.commit();
				
				Forum depression = new Forum();
				depression.uniqueid = ""+System.currentTimeMillis();
				depression.title = "Depression";
				forums.put(depression.uniqueid, depression);
				db.commit();
				
				Forum eating = new Forum();
				eating.uniqueid = ""+System.currentTimeMillis();
				eating.title = "Eating Disorders";
				forums.put(eating.uniqueid, eating);
				db.commit();
				
				Forum general = new Forum();
				general.uniqueid = ""+System.currentTimeMillis();
				general.title = "General Discussion";
				forums.put(general.uniqueid, general);
				db.commit();
				
				Forum ocd = new Forum();
				ocd.uniqueid = ""+System.currentTimeMillis();
				ocd.title = "OCD";
				forums.put(ocd.uniqueid, ocd);
				db.commit();
				
				Forum paranoia = new Forum();
				paranoia.uniqueid = ""+System.currentTimeMillis();
				paranoia.title = "Paranoia";
				forums.put(paranoia.uniqueid, paranoia);
				db.commit();

				Forum psychosis = new Forum();
				psychosis.uniqueid = ""+System.currentTimeMillis();
				psychosis.title = "Psychosis";
				forums.put(psychosis.uniqueid, psychosis);
				db.commit();
				
				Forum schizophrenia = new Forum();
				schizophrenia.uniqueid = ""+System.currentTimeMillis();
				schizophrenia.title = "Schizophrenia";
				forums.put(schizophrenia.uniqueid, schizophrenia);
				db.commit();
				
				Forum sleeping = new Forum();
				sleeping.uniqueid = ""+System.currentTimeMillis();
				sleeping.title = "Sleep Problems";
				forums.put(sleeping.uniqueid, sleeping);
				db.commit();
				
				Forum stress = new Forum();
				stress.uniqueid = ""+System.currentTimeMillis();
				stress.title = "Stress";
				forums.put(stress.uniqueid, stress);
				db.commit();
				
				forumKeys = forums.keyList();
			}
			
			//for every forum...
			for(int forumKeyIndex=0;forumKeyIndex<forumKeys.size();forumKeyIndex++)
			{
				String forumUniqueID = forumKeys.get(forumKeyIndex);
				Forum forum = forums.get(forumUniqueID);
				
				//get how many posts each forum has
				int counter = 0;
				for (String p : forum.posts) {
					counter++;
				}
				
				stringToSendToWebBrowser +=
						"          		<div class=\"col-lg-4 col-md-6 col-sm-12\">\r\n" + 
						"    				<a href=\"forum-"+forum.uniqueid+"\">\r\n" + 
						"            		  <div class=\"forum-tile\">\r\n" + 
						"             			 <h4>"+ forum.title +"</h4>\r\n" + 
						"            				<span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>" + counter + " posts</span>\r\n" + 
						"            		  </div>\r\n" + 
						"                </a>\r\n" + 
						"          		</div>\r\n";
			}

			stringToSendToWebBrowser +=
					"			<br>" +
					"          	</div>\r\n" + 
					"          	<div class=\"row\">\r\n" + 
					"          		<div class=\"col-12 d-flex justify-content-center\">\r\n" + 
					"          		  <a href=\"category\"><button class=\"button pink-bg\">View All</button></a>\r\n" + 
					"          		</div>\r\n" + 
					"            </div>\r\n" + 
					"		  </div>\r\n" + 
					"		</div>\r\n" + 
					"	</section>\r\n" + 
					"\r\n" + 
					"    <!--HELPLINE & SUPPORT-->\r\n" + 
					"    <section id=\"helpline-support\">\r\n" + 
					"      <div class=\"container-fluid\">\r\n" + 
					"        <div class=\"row d-flex align-items-center\">\r\n" + 
					"          <div class=\"col-lg-4 col-md-12\">\r\n" + 
					"      			<section id=\"helplines\">\r\n" + 
					"      				<div class=\"row\">\r\n" + 
					"      					<div class=\"col-12\">\r\n" + 
					"      					  <h2 class=\"text-center\">Helplines</h2>\r\n" + 
					"      					  <p>Do you need urgent help? These helplines can offer expert advice.</p>\r\n" + 
					"      					  <div class=\"helpline-tile\">\r\n" + 
					"        						<h4>Samaritans</h4>\r\n" + 
					"        						<h4 class=\"phoneno\">116 123</h4>\r\n" + 
					"        						<span></span><span>24-hour, free</span>\r\n" + 
					"      					  </div>\r\n" + 
					"                  <div class=\"helpline-tile\">\r\n" + 
					"        						<h4>Lifeline</h4>\r\n" + 
					"        						<h4 class=\"phoneno\">0808 808 8000</h4>\r\n" + 
					"        						<span></span><span>24-hour, free</span>\r\n" + 
					"      					  </div>\r\n" + 
					"      					</div>\r\n" + 
					"      				</div>\r\n" + 
					"      				<div class=\"row\">\r\n" + 
					"      					<div class=\"col-12 d-flex justify-content-center\">\r\n" + 
					"      						<a href=\"support\"><button class=\"button pink-bg\">View All</button></a>\r\n" + 
					"      					</div>\r\n" + 
					"      				</div>\r\n" + 
					"      			</section>\r\n" + 
					"          </div>\r\n" + 
					"          <div class=\"col-lg-8 col-md-12\">\r\n" + 
					"            <section id=\"support\">\r\n" + 
					"              <div class=\"row\">\r\n" + 
					"        				<div class=\"col-12\">\r\n" + 
					"        					<h2 class=\"text-center\">Support Groups</h2>\r\n" + 
					"                  <p>Whether you're concerned about yourself or a loved one, help is available through these support groups.</p>\r\n" + 
					"                </div>\r\n" + 
					"              </div>\r\n" + 
					"              <div class=\"row\">\r\n" + 
					"                <div class=\"col-12 d-flex justify-content-center flex-wrap\">\r\n" + 
					"                    <a href=\"https://www.aware-ni.org/\" target=\"_blank\"><img src=\"https://www.aware-ni.org/templates/yootheme/cache/aware_logo_hires-409cb53d.png\" alt=\"Aware NI logo\"></a>\r\n" + 
					"                    <a href=\"https://www.rcpsych.ac.uk/mental-health\" target=\"_blank\"><img src=\"https://www.rcpsych.ac.uk/ResourcePackages/Rcpsych/assets/dist/images/logo.svg\" alt=\"Royal College of Psychiatrists in Northern Ireland logo\"></a>\r\n" + 
					"                    <a href=\"http://addictionni.com/\" target=\"_blank\"><img src=\"http://addictionni.com/wordpress/wp-content/themes/ani/images/logo.png\" alt=\"Addiction NI logo\"></a>\r\n" + 
					"                    <a href=\"https://www.amh.org.uk/\" target=\"_blank\"><img src=\"https://www.amh.org.uk/wp-content/themes/amh_2018/img/amh-logo.svg?v=2\" alt=\"Action Mental Health logo\" style=\"filter: invert(0.6);\"></a>\r\n" + 
					"                    <a href=\"http://www.cause.org.uk/\" target=\"_blank\"><img src=\"http://www.cause.org.uk/site/img/branding@2x.png\" alt=\"Cause logo\"></a>\r\n" + 
					"                    <a href=\"https://www.praxisprovides.com/\" target=\"_blank\"><img src=\"https://www.praxisprovides.com/cms/wp-content/uploads/2016/09/praxlogomain.png\" alt=\"Praxis Care logo\"></a>\r\n" + 
					"                    <a href=\"https://www.inspirewellbeing.org/mentalhealth\" target=\"_blank\"><img src=\"https://www.inspirewellbeing.org/media/5178/mentalhealthwebhomepng.png\" alt=\"Inspire Wellbeing Mental Health logo\"></a>\r\n" + 
					"                    <a href=\"http://newlifecounselling.net/\" target=\"_blank\"><img src=\"http://dev.newlifecounselling.net/wp-content/uploads/2016/05/sdNEWLIFE-MASTER-LOGO-3.png\" alt=\"New Life Counselling logo\"></a>\r\n" + 
					"                </div>\r\n" + 
					"              </div>\r\n" + 
					"        			<div class=\"row\">\r\n" + 
					"        				<div class=\"col-12 d-flex justify-content-center\">\r\n" + 
					"        					<a href=\"support\"><button class=\"button pink-bg\">View All</button></a>\r\n" + 
					"        				</div>\r\n" + 
					"        			</div>\r\n" + 
					"            </section>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </section>\r\n" + 
					"\r\n";

			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
			
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		//if category page...
		else if(toProcess.path.equalsIgnoreCase("category"))
		{
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			stringToSendToWebBrowser +=
					"  <section class=\"category\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>Category Page</h1>\r\n" +
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"row\">\r\n";

			MVMap<String, Forum> forums = db.s.openMap("Forums");

			List<String> forumKeys = forums.keyList();
			
			//for every forum...
			for(int forumKeyIndex=0; forumKeyIndex<forumKeys.size(); forumKeyIndex++)
			{
				String forumUniqueID = forumKeys.get(forumKeyIndex);
				Forum forum = forums.get(forumUniqueID);
				
				//get how many posts each forum has
				int counter = 0;
				for (String p : forum.posts) {
					counter++;
				}
				
				stringToSendToWebBrowser +=
						"        <div class=\"col-md-6 col-sm-12\">\r\n" + 
						"    		<a href=\"forum-"+forum.uniqueid+"\">\r\n" + 
						"            <div class=\"forum-tile\">\r\n" + 
						"              <h4>"+ forum.title +"</h4>\r\n" + 
						"              <span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>" + counter + " posts</span>\r\n" + 
						"            </div>\r\n" + 
						"          </a>\r\n" + 
						"        </div>\r\n";
			}

			stringToSendToWebBrowser += "      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <br>\r\n" + 
					"    <br>\r\n" + 
					"  </section>\r\n" + 
					"\r\n";
			
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
			
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		//if adding post...
		else if(toProcess.path.startsWith("addPost")) {

			//create new post
			Post post = new Post();
			
			//input post details from form
			post.uniqueid = ""+System.currentTimeMillis();
			post.title = toProcess.params.get("title");
			post.description = toProcess.params.get("description");
			
			//add new post to database
			MVMap<String, Post> posts = db.s.openMap("Posts");
			posts.put(post.uniqueid, post);

			//get the forum from the database
			MVMap<String, Forum> forums = db.s.openMap("Forums");
			Forum forum = forums.get(toProcess.params.get("forum-choice"));

			//add post to forum
			forum.posts.add(post.uniqueid);

			//place forum back to database after change
			forums.put(forum.uniqueid, forum);

			//commit changes
			db.commit();
			
			String url = toProcess.header.get("referer");
			toProcess.r = new WebResponse( WebResponse.HTTP_REDIRECT, WebResponse.MIME_HTML,
									   "<html><body>Redirected: <a href=\"" + url + "\">" +
									   url + "</a></body></html>");
			toProcess.r.addHeader( "Location", url );
			
			return true;
		}
		//if forum page...
		else if(toProcess.path.startsWith("forum-")){
			String forumUniqueID = toProcess.path.substring("forum-".length());
			
			MVMap<String, Forum> forums = db.s.openMap("Forums");
			Forum forum = forums.get(forumUniqueID);
			
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			stringToSendToWebBrowser +=
					"  <section class=\"forum\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>" + forum.title + "</h1>\r\n" + 
					"          <p>forum</p>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </section>\r\n" + 
					"  <section class=\"forum-featured\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row d-flex justify-content-center\">\r\n" + 
					"        <div class=\"col-md-8 col-sm-12\">\r\n" + 
					"          <br>\r\n" + 
					"          <h2 class=\"text-center\">Latest Posts</h2>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"row d-flex justify-content-center\">\r\n" + 
					"        <div class=\"col-md-8 col-sm-12\">\r\n" + 
					"          <br>\r\n";
			
			MVMap<String, Post> posts = db.s.openMap("Posts");

			List<String> postKeys = posts.keyList();

			//add sample post to forum if there are none already
			if((forum.posts).size()==0)
			{
				
				//add new sample post
				Post post = new Post();
				post.uniqueid = ""+System.currentTimeMillis();
				post.title = "New here? Take a look at our forum rules.";
				post.description = "Welcome to the community! Take a look at some of the forums, read through posts, add your own posts, and talk to others by commenting on posts!";
				posts.put(post.uniqueid, post);

				//add post to forum
				forum.posts.add(post.uniqueid);

				//place forum back to database after change
				forums.put(forum.uniqueid, forum);

				//commit changes
				db.commit();

			}

			//for every post...
			for(int i=0;i<forum.posts.size();i++){
				String postName = forum.posts.get(i);
				
				Post post = posts.get(postName);
				
				//get how many comments each post has
				int counter = 0;
				for (String c : post.comments) {
					counter++;
				}
				
				stringToSendToWebBrowser +=
						"    <a href=\"post-"+post.uniqueid+"\">\r\n" + 
						"            <div class=\"post-tile\">\r\n" + 
						"              <h4>"+ post.title +"</h4>\r\n" + 
						"              <span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span>&nbsp;&nbsp;<span>by username</span>\r\n" + 
						"              <br>\r\n" + 
						"              <span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>" + counter + " comments</span>\r\n" + 
						"            </div>\r\n" + 
						"          </a>\r\n";
			}
				
			stringToSendToWebBrowser +=
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <br>\r\n" + 
					"    <br>\r\n" + 
					"  </section>\r\n" + 
					"\r\n" + 
					"	<!--USER INPUT-->\r\n" + 
					"	<section class=\"input\">\r\n" + 
					"		<div class=\"container\">\r\n" + 
					"			<div class=\"row\">\r\n" + 
					"				<div class=\"col-12\">\r\n" + 
					"				<br>\r\n" + 
					"					<h2 class=\"text-center\">Create a New Post</h2>\r\n" + 
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"			<div class=\"row\">\r\n" + 
					"				<div class=\"col-12\">\r\n" + 
					"					<br>\r\n" + 
					"						<form action=\"addPost\" method=\"GET\">\r\n" + 
					"							<input type=\"text\" name=\"title\" placeholder=\"Post Title\"><br><br>\r\n" + 
					"							<textarea name=\"description\" placeholder=\"Enter your post here...\"></textarea>\r\n" + 
					"              				<span>You are posting to: </span><select name=\"forum-choice\">\r\n" + 
					"               				<option value=\"" + forum.uniqueid + "\">" + forum.title + "</option>\r\n" + 
					"             				</select>\r\n" + 
					"							<input class=\"button purple-bg\" type=\"submit\" style=\"width: 100px;\">\r\n" + 
					"						</form>" + 
					"					</br>\r\n" + 
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"		</div>\r\n" + 
					"	</section>\r\n" + 
					"\r\n";
			
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
			
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		
		//if adding comment...
		else if(toProcess.path.startsWith("addComment")) {

			//create new post
			Comment comment = new Comment();
			
			//input comment details from form
			comment.uniqueid = ""+System.currentTimeMillis();
			comment.description = toProcess.params.get("description");
			
			//add new comment to database
			MVMap<String, Comment> comments = db.s.openMap("Comments");
			comments.put(comment.uniqueid, comment);

			//get the post from the database
			MVMap<String, Post> posts = db.s.openMap("Posts");
			Post post = posts.get(toProcess.params.get("post"));

			//add comment to post
			post.comments.add(comment.uniqueid);

			//place post back to database after change
			posts.put(post.uniqueid, post);

			//commit changes
			db.commit();
			
			//return back to previous page
			String url = toProcess.header.get("referer");
			toProcess.r = new WebResponse( WebResponse.HTTP_REDIRECT, WebResponse.MIME_HTML,
									   "<html><body>Redirected: <a href=\"" + url + "\">" +
									   url + "</a></body></html>");
			toProcess.r.addHeader( "Location", url );
			
			return true;
		}
		
		//if post page...
		else if(toProcess.path.startsWith("post-")){
			String postUniqueID = toProcess.path.substring("post-".length());
			
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			stringToSendToWebBrowser +=
					"  <section class=\"post\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>Anxiety Disorders</h1>\r\n" + 
					"          <p>forum</p>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </section>\r\n";
			
			MVMap<String, Post> posts = db.s.openMap("Posts");

			//for every post
			Post post = posts.get(postUniqueID);
			
			stringToSendToWebBrowser +=
					"  <section class=\"post-original\">\r\n" + 
					"    <br>\r\n" + 
					"    <br>\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row d-flex justify-content-center\">\r\n" + 
					"        <div class=\"col-md-8 col-sm-12\">\r\n" + 
					"          <h4>" + post.title + "</h4>\r\n" + 
					"          <br>\r\n" + 
					"          <div class=\"post-tile\">\r\n" + 
					"            <p>" + post.description + "</p>\r\n" +
					"            <br>\r\n" + 
					"            <span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span>&nbsp;&nbsp;<span>by <a href=\"profilepage\">username</a></span>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <br>\r\n" + 
					"    <br>\r\n" + 
					"  </section>\r\n" + 
					"  <section class=\"post\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row d-flex justify-content-center\">\r\n" + 
					"        <div class=\"col-md-8 col-sm-12\">\r\n" + 
					"          <br>\r\n" + 
					"          <h4>Comments</h4>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"row d-flex justify-content-center\">\r\n" + 
					"        <div class=\"col-md-8 col-sm-12\">\r\n" + 
					"          <br>\r\n";
			
			//for every post...
			MVMap<String, Comment> comments = db.s.openMap("Comments");

			List<String> commentKeys = comments.keyList();
			
			for(int i=0; i<post.comments.size(); i++){
				
				String postComment = post.comments.get(i);
				
				Comment comment = comments.get(postComment);
				
				stringToSendToWebBrowser +=
						"          <div class=\"post-tile\">\r\n" + 
						"            <p>" + comment.description + "</p>\r\n" + 
						"            <span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span>&nbsp;&nbsp;<span>by <a href=\"profilepage\">username</a></span>\r\n" + 
						"          </div>\r\n";
			}
			
			stringToSendToWebBrowser +=
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <br>\r\n" + 
					"    <br>\r\n" + 
					"  </section>\r\n" + 
					"\r\n" + 
					"	<section class=\"input\">\r\n" + 
					"		<div class=\"container\">\r\n" + 
					"			<div class=\"row\">\r\n" + 
					"				<div class=\"col-12\">\r\n" + 
					"				<br>\r\n" + 
					"					<h2 class=\"text-center\">Add a Comment</h2>\r\n" + 
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"			<div class=\"row\">\r\n" + 
					"				<div class=\"col-12\">\r\n" + 
					"					<br>\r\n" + 
					"						<form action=\"addComment\" method=\"GET\">\r\n" + 
					"							<textarea name=\"description\" placeholder=\"Enter your comment here...\"></textarea>\r\n" + 
					"              <input type=\"hidden\" name=\"post\" value=\"" + post.uniqueid + "\">\r\n" + 
					"							<input class=\"button purple-bg\" type=\"submit\" style=\"width: 100px;\">\r\n" + 
					"						</form>\r\n" + 
					"					</br>\r\n" + 
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"		</div>\r\n" + 
					"	</section>\r\n" + 
					"\r\n";
			
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
			
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		
		//if support page...
		else if(toProcess.path.equalsIgnoreCase("support"))
		{
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			stringToSendToWebBrowser +=
					"	<section class=\"support\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>Support</h1>\r\n" + 
					"          <p>These charities and telephone lines will provide advice and insight with what you are struggling with.</p>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n" +
					"	<section class=\"support-helplines\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h2 class=\"text-center\">Helplines</h2>   \r\n" + 
					"          <p>Do you need urgent help? These helplines can offer expert advice.</p> \r\n" + 
					"      	</div>\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-6 col-sm-12 text-center\">\r\n" + 
					"			<div class=\"helpline-tile\">\r\n" + 
					"				<h4>Samaritans</h4>\r\n" + 
					"				<h4 class=\"phoneno\">116 123</h4>\r\n" + 
					"				<span></span><span>24-hour, free</span>\r\n" + 
					"			</div>\r\n" +  
					"		</div>\r\n" +  
					"        <div class=\"col-md-6 col-sm-12 text-center\">\r\n" + 
					"			<div class=\"helpline-tile\">\r\n" + 
					"				<h4>Lifeline</h4>\r\n" + 
					"				<h4 class=\"phoneno\">0808 808 8000</h4>\r\n" + 
					"				<span></span><span>24-hour, free</span>\r\n" + 
					"			</div>\r\n" +  
					"		</div>\r\n" +  
					"        <div class=\"col-md-6 col-sm-12 text-center\">\r\n" + 
					"			<div class=\"helpline-tile\">\r\n" + 
					"				<h4>Aware NI</h4>\r\n" + 
					"				<h4 class=\"phoneno\">0845 120 2961</h4>\r\n" + 
					"				<span></span><span>Mon-Frid, 9am-1pm</span>\r\n" + 
					"			</div>\r\n" +  
					"		</div>\r\n" +  
					"        <div class=\"col-md-6 col-sm-12 text-center\">\r\n" + 
					"			<div class=\"helpline-tile\">\r\n" + 
					"				<h4>Childline (under 19s)</h4>\r\n" + 
					"				<h4 class=\"phoneno\">0800 1111</h4>\r\n" + 
					"				<span></span><span>24-hour, free</span>\r\n" + 
					"			</div>\r\n" +  
					"		</div>\r\n" +  
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"	<br>" +
					"	<br>" +
					"   </section>\r\n" +
					"	<section class=\"support-groups\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h2 class=\"text-center\">Support Groups</h2>\r\n" + 
					"             <p>Whether you're concerned about yourself or a loved one, help is available through these support groups.</p> \r\n" + 
					"             <br> \r\n" + 
					"             <div class=\"support-img\">\r\n" + 
					"              <div class=\"row\">\r\n" + 
					"                <div class=\"col-12 d-flex justify-content-center flex-wrap\">\r\n" + 
					"                    <a href=\"https://www.aware-ni.org/\" target=\"_blank\"><img src=\"https://www.aware-ni.org/templates/yootheme/cache/aware_logo_hires-409cb53d.png\" alt=\"Aware NI logo\"></a>\r\n" + 
					"                    <a href=\"https://www.rcpsych.ac.uk/mental-health\" target=\"_blank\"><img src=\"https://www.rcpsych.ac.uk/ResourcePackages/Rcpsych/assets/dist/images/logo.svg\" alt=\"Royal College of Psychiatrists in Northern Ireland logo\"></a>\r\n" + 
					"                    <a href=\"http://addictionni.com/\" target=\"_blank\"><img src=\"http://addictionni.com/wordpress/wp-content/themes/ani/images/logo.png\" alt=\"Addiction NI logo\"></a>\r\n" + 
					"                    <a href=\"https://www.amh.org.uk/\" target=\"_blank\"><img src=\"https://www.amh.org.uk/wp-content/themes/amh_2018/img/amh-logo.svg?v=2\" alt=\"Action Mental Health logo\" style=\"filter: invert(0.6);\"></a>\r\n" + 
					"                    <a href=\"http://www.cause.org.uk/\" target=\"_blank\"><img src=\"http://www.cause.org.uk/site/img/branding@2x.png\" alt=\"Cause logo\"></a>\r\n" + 
					"                    <a href=\"https://www.praxisprovides.com/\" target=\"_blank\"><img src=\"https://www.praxisprovides.com/cms/wp-content/uploads/2016/09/praxlogomain.png\" alt=\"Praxis Care logo\"></a>\r\n" + 
					"                    <a href=\"https://www.inspirewellbeing.org/mentalhealth\" target=\"_blank\"><img src=\"https://www.inspirewellbeing.org/media/5178/mentalhealthwebhomepng.png\" alt=\"Inspire Wellbeing Mental Health logo\"></a>\r\n" + 
					"                    <a href=\"http://newlifecounselling.net/\" target=\"_blank\"><img src=\"http://dev.newlifecounselling.net/wp-content/uploads/2016/05/sdNEWLIFE-MASTER-LOGO-3.png\" alt=\"New Life Counselling logo\"></a>\r\n" + 
					"                </div>\r\n" + 
					"              </div>\r\n" + 
					"            </div>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n";
					
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
				 
			toProcess.r = new WebResponse ( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		
		//if contact page...
		else if(toProcess.path.equalsIgnoreCase("contact"))
		{
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			stringToSendToWebBrowser +=
					"	<section class=\"contact\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>Contact Us</h1>\r\n" + 
					"          <p>Get in touch with us by filling in the form below.</p>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n" +
					"	<section class=\"contact-form\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"			<form action=\"contactsubmit\" method=\"post\">\r\n" + 
					"      			<input type=\"text\" name=\"contact-name\" placeholder=\"Name\"><br><br>\r\n" + 
					"      			<input type=\"email\" name=\"contact-email\" placeholder=\"E-mail Address\"><br><br>\r\n" + 
					"     			<textarea name=\"contact-message\" placeholder=\"Enter your message here...\"></textarea>\r\n" +
					"				<input class=\"button purple-bg\" type=\"submit\" style=\"width: 100px;\">\r\n" +
					"    		</form>" +
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n";
					
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
				 
			toProcess.r = new WebResponse ( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		
		//if contact submit page...
		else if(toProcess.path.equalsIgnoreCase("contactsubmit"))
		{
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			String name = toProcess.params.get("contact-name");
			stringToSendToWebBrowser +=
					"	<section class=\"contact\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>Contact Us</h1>\r\n" +  
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n" +
					"	<section class=\"contact-form\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"			<p>Thanks, " + name + "! We'll be in touch with you soon.</p>" +
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n";
					
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
				 
			toProcess.r = new WebResponse ( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		
		//if registration page...
		else if(toProcess.path.equalsIgnoreCase("register")) {
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			stringToSendToWebBrowser +=
					"	<section class=\"contact\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>Register</h1>\r\n" + 
					"          <p>Register an account with us! Please enter your details below.</p>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n" +
					"	<section class=\"contact-form\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"			<form action=\"registersubmit\" method=\"post\">\r\n" + 
					"      			<input type=\"email\" name=\"register-email\" placeholder=\"E-mail Address\"><br><br>\r\n" + 
					"      			<input type=\"text\" name=\"register-username\" placeholder=\"Username\"><br><br>\r\n" + 
					"      			<input type=\"password\" name=\"register-password\" placeholder=\"Password\"><br><br>\r\n" +
					"				<input class=\"button purple-bg\" type=\"submit\" style=\"width: 100px;\">\r\n" +
					"    		</form>" +
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n";
					
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
				 
			toProcess.r = new WebResponse ( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		
		//if registration submit page...
		else if(toProcess.path.equalsIgnoreCase("registersubmit")) {
			
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			
			//get username to use in this page
			String username = toProcess.params.get("register-username");
			
			//get new user's details
			Profile profile = new Profile();
			profile.email = toProcess.params.get("register-email");
			profile.username = toProcess.params.get("register-username");
			profile.password = toProcess.params.get("register-password");

			MVMap<String, Profile> profiles = db.s.openMap("Profiles");
			
			stringToSendToWebBrowser +=
					"	<section class=\"contact\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n";
			
			//if that username already exists, then let user try registering again
			if(profiles.containsKey(profile.username)) {
				stringToSendToWebBrowser +=
					"          <h1>Registeration Error</h1>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n" +
					"	<section class=\"contact-form\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"			<p>Sorry! It looks like the username, " + username + " already exists. <a href=\"register\">Click here</a> to try again!</p>";
			}
			//otherwise, acknowledge successful registration and add user
			else {
				stringToSendToWebBrowser +=
						"          <h1>Registration Successful</h1>\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"        </div>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"   </section>\r\n" +
						"	<section class=\"contact-form\">\r\n" + 
						"    <div class=\"container\">\r\n" + 
						"      <div class=\"row\">\r\n" + 
						"        <div class=\"col-12 text-center\">\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"			<p>Thanks, " + username + "! You have successfully registered an account.</p><br>" +
						"			<p>Welcome to Mental Health NI forum! <a href=\"login\">Click here</a> to login with your new account!</p>";
				
				//add new user to profiles
				profiles.put(profile.username, profile);
				db.commit();
			}
			
			stringToSendToWebBrowser +=
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n";
					
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
				 
			toProcess.r = new WebResponse ( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		
		//if login page...
		else if(toProcess.path.equalsIgnoreCase("login")) {
			stringToSendToWebBrowser +=
					"  </head>\r\n" + 
					"  <body>\r\n";
			//call header (navbar)
			stringToSendToWebBrowser += HeaderFooter.header();
			stringToSendToWebBrowser +=
					"	<section class=\"contact\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>Login</h1>\r\n" + 
					"          <p>Login by entering your account details below.</p>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n" +
					"	<section class=\"contact-form\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"			<form action=\"loginsubmit\" method=\"post\">\r\n" + 
					"      			<input type=\"text\" name=\"login-username\" placeholder=\"Username\"><br><br>\r\n" + 
					"      			<input type=\"password\" name=\"login-password\" placeholder=\"Password\"><br><br>\r\n" +
					"				<input class=\"button purple-bg\" type=\"submit\" style=\"width: 100px;\">\r\n" +
					"    		</form>" +
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"   </section>\r\n";
					
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
				 
			toProcess.r = new WebResponse ( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		
		//if login submit page...
		else if(toProcess.path.equalsIgnoreCase("loginsubmit")) {
			
			String username = toProcess.params.get("login-username");
			String password = toProcess.params.get("login-password");

			MVMap<String, Profile> profiles = db.s.openMap("Profiles");
			
			//if that username doesn't exist, then give user option to register
			if(!profiles.containsKey(username)) {
				stringToSendToWebBrowser +=
						"  </head>\r\n" + 
						"  <body>\r\n";
				//call header (navbar)
				stringToSendToWebBrowser += HeaderFooter.header();
				
				stringToSendToWebBrowser +=
						"	<section class=\"contact\">\r\n" + 
						"    <div class=\"container\">\r\n" + 
						"      <div class=\"row\">\r\n" + 
						"        <div class=\"col-12 text-center\">\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" +
						"          <h1>Login Error</h1>\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"        </div>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"   </section>\r\n" +
						"	<section class=\"contact-form\">\r\n" + 
						"    <div class=\"container\">\r\n" + 
						"      <div class=\"row\">\r\n" + 
						"        <div class=\"col-12 text-center\">\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"			<p>Oops! We don't recognise the username, " + username + ". <a href=\"register\">Click here</a> to try again!</p><br><br>" +
						"			<p>Are you new here? <a href=\"register\">Click here</a> to register an account with us.</p>" +
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"        </div>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"   </section>\r\n";
			}
			
			//get user's details
			Profile profile = profiles.get(username);
			
			//if user's password is incorrect
			if(!profile.password.contentEquals(password)) {
				stringToSendToWebBrowser +=
						"  </head>\r\n" + 
						"  <body>\r\n";
				//call header (navbar)
				stringToSendToWebBrowser += HeaderFooter.header();
				
				stringToSendToWebBrowser +=
						"	<section class=\"contact\">\r\n" + 
						"    <div class=\"container\">\r\n" + 
						"      <div class=\"row\">\r\n" + 
						"        <div class=\"col-12 text-center\">\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" +
						"          <h1>Login Error</h1>\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"        </div>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"   </section>\r\n" +
						"	<section class=\"contact-form\">\r\n" + 
						"    <div class=\"container\">\r\n" + 
						"      <div class=\"row\">\r\n" + 
						"        <div class=\"col-12 text-center\">\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"			<p>Hi, " + username + ". The password you entered is incorrect. <a href=\"login\">Click here</a> to try again.</p>" +
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"        </div>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"   </section>\r\n";
			}
			
			//otherwise, login user successfully
			else{
				stringToSendToWebBrowser +=
						"  <script>\n" +
						"      function setCookie(cname, cvalue, exdays)\n" +
						"      {\n" +
						"          var d = new Date();\n" +
						"          d.setTime(d.getTime() + (exdays*24*60*60*1000));\n" +
						"          var expires = 'expires='+d.toUTCString();\n" +
						"          document.cookie = cname + '=' + cvalue + ';' + expires + ';path=/';\n" +
						"      }\n" +
						"      function saveLoginCookie()\n" +
						"      {\n" +
						"          setCookie('username','"+username+"',365);\n" +
						"          setCookie('password','"+password+"',365);\n" +
						"      }\n" +
						"  </script>\n" +
						"  </head>\r\n" + 
						"  <body onload='saveLoginCookie()'>\n";
				//call header (navbar)
				stringToSendToWebBrowser += HeaderFooter.header();
				
				stringToSendToWebBrowser +=
						"	<section class=\"contact\">\r\n" + 
						"    <div class=\"container\">\r\n" + 
						"      <div class=\"row\">\r\n" + 
						"        <div class=\"col-12 text-center\">\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" +
						"          <h1>Login Successful</h1>\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"        </div>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"   </section>\r\n" +
						"	<section class=\"contact-form\">\r\n" + 
						"    <div class=\"container\">\r\n" + 
						"      <div class=\"row\">\r\n" + 
						"        <div class=\"col-12 text-center\">\r\n" + 
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"			<p>Welcome back, " + username + "! You have successfully logged in.</p><br><br>" +
						"			<p><a href=\"profilepage\">Click here</a> to visit your profile.</p>" +
						"          <br>\r\n" + 
						"          <br>\r\n" + 
						"        </div>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"   </section>\r\n";
			}
					
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
				 
			toProcess.r = new WebResponse ( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		
		//if search page...
		else if(toProcess.path.equalsIgnoreCase("search")) {
			
			//get keyword from search input
			String keyword = toProcess.params.get("keyword").toLowerCase();
			
			stringToSendToWebBrowser +=
					"  <section class=\"search\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>Search</h1>\r\n" + 
					"          <p>Showing search results for: <strong>" + keyword + "</strong></p>\r\n" + 
					"          <a href=\"#forum-results\"><button class=\"button pink-bg\">Forum Results</button></a>&nbsp;&nbsp;\r\n" + 
					"          <a href=\"#post-results\"><button class=\"button pink-bg\">Post Results</button></a>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </section>\r\n" + 
					"  <section class=\"search-results\">\r\n" + 
					"    <div class=\"container\">\r\n" +
					"      <!--Forum Results-->\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12\">\r\n" + 
					"          <h2 id=\"forum-results\">Forums</h2>\r\n" + 
					"          <p>Showing forums containing: <strong>" + keyword + "</strong></p>\r\n" + 
					"          <div class=\"row\">\r\n";
			
			//forum search results
			MVMap<String, Forum> forums = db.s.openMap("Forums");

			List<String> forumKeys = forums.keyList();
			for(int i = 0; i<forumKeys.size(); i++)
			{
				String forumKey = forumKeys.get(i);
				Forum forum = forums.get(forumKey);
				
				//get how many posts each forum has
				int counter = 0;
				for (String p : forum.posts) {
					counter++;
				}
				
				if(forum.title.toLowerCase().contains(keyword))
				{
					stringToSendToWebBrowser +=
							"            <div class=\"col-lg-4 col-md-6 col-sm-12\">\r\n" + 
							"    			<a href=\"forum-"+forum.uniqueid+"\">\r\n" + 
							"                <div class=\"forum-tile\">\r\n" + 
							"             		<h4>"+ forum.title +"</h4>\r\n" + 
							"					<span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>" + counter + " posts</span>\r\n" + 
							"                </div>\r\n" + 
							"              </a>\r\n" + 
							"            </div>\r\n";
					
				}
			}
			stringToSendToWebBrowser +=
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <br>\r\n" + 
					"      <!--Forum Results End-->\r\n" +
					"      <!--Post Results-->\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12\">\r\n" + 
					"          <h2 id=\"post-results\">Posts</h2>\r\n" + 
					"          <p>Showing posts containing: <strong>" + keyword + "</strong></p>\r\n" + 
					"          <div class=\"row\">\r\n";
			
			//post search results
			MVMap<String, Post> posts = db.s.openMap("Posts");

			List<String> postKeys = posts.keyList();
			for(int i = 0; i<postKeys.size(); i++)
			{
				String postKey = postKeys.get(i);
				Post post = posts.get(postKey);
				
				//get how many comments each post has
				int counter = 0;
				for (String c : post.comments) {
					counter++;
				}
				
				if(post.title.toLowerCase().contains(keyword))
				{
					stringToSendToWebBrowser +=
							"            <div class=\"col-12\">\r\n" + 
							"    			<a href=\"post-"+post.uniqueid+"\">\r\n" + 
							"                <div class=\"post-tile\">\r\n" + 
							"        	      <h4>"+ post.title +"</h4>\r\n" + 
							"                  <span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span> <span>by username</span><br>\r\n" + 
							"					<span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>" + counter + " comments</span>\r\n" + 
							"                </div>\r\n" + 
							"              </a>\r\n" + 
							"            </div>\r\n";
					
				}
			}
					
			stringToSendToWebBrowser +=
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <!--Post Results End-->\r\n" +
					"    </div>\r\n" + 
					"  </section>\r\n" + 
					"\r\n";
			
			//call footer
			stringToSendToWebBrowser += HeaderFooter.footer();
		
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        	return true;
		}
		return false;
	}

}
