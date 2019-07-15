package views;

import java.util.List;

import org.h2.mvstore.MVMap;

import model.Comment;
import model.Forum;
import model.Post;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class TestView extends DynamicWebPage
{

	public TestView(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		//if homepage...
		if(toProcess.path.equalsIgnoreCase("index")) {
			
			String stringToSendToWebBrowser =
					"<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\" dir=\"ltr\">\r\n" + 
					"  <head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
					"	<!--bootstrap stylesheet-->\r\n" + 
					"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
					"	<!--google font stylesheet-->\r\n" + 
					"    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700\" rel=\"stylesheet\">\r\n" + 
					"	<!--fontawesome stylesheet-->\r\n" + 
					"	<link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n" + 
					"	<!--regular stylesheet-->\r\n" + 
					"    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/index-style.css\">\r\n" + 
					"    <title>Mental Health NI</title>\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"  <!--HEADER-->\r\n" + 
					"	<header>\r\n" + 
					"		<div class=\"container-fluid\">\r\n" + 
					"			<div class=\"row\">\r\n" + 
					"				<div class=\"col-12 d-flex justify-content-end\">\r\n" + 
					"					<a href=\"profilepage\"><button class=\"purple-bg\">Login</button></a>\r\n" + 
					"					<a href=\"profilepage\"><button class=\"pink-bg\">Register</button></a>\r\n" + 
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"		</div>\r\n" + 
					"		<nav>\r\n" + 
					"      <div class=\"container-fluid\">\r\n" + 
					"        <div class=\"row d-flex align-items-center\">\r\n" + 
					"          <div class=\"col-3 d-flex justify-content-start\">\r\n" + 
					"            <div class=\"logo\"><a href=\"index\"><strong>Mental Health Forum</strong></a></div>\r\n" + 
					"          </div>\r\n" + 
					"          <div class=\"col-6\">\r\n" + 
					"            <div class=\"d-flex justify-content-around\">\r\n" + 
					"              <span><a href=\"index\">Home</a></span>\r\n" + 
					"              <span><a href=\"category\">Forums</a></span>\r\n" + 
					"              <span><a href=\"support\">Support</a></span>\r\n" + 
					"              <span><a href=\"contact\">Contact</a></span>\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"          <div class=\"col-3 d-flex justify-content-end\">\r\n" + 
					"            <input type=\"text\" placeholder=\"Search\">\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"		</nav>\r\n" + 
					"	</header>\r\n" + 
					"\r\n" + 
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
					"  				<a href=\"#\"><button class=\"pink-bg\">Register</button></a>\r\n" + 
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
					"    <!--FORUMS & POSTS-->\r\n" + 
					"	<section id=\"forum-posts\">\r\n" + 
					"		<div class=\"container-fluid\">\r\n" + 
					"		  <div class=\"row d-flex align-items-center\">\r\n" + 
					"  			<!--FORUMS-->\r\n" + 
					"  			<div class=\"col-lg-8 col-md-12\">\r\n" + 
					"  			  <section id=\"forums\">\r\n" + 
					"            <div class=\"row\">\r\n" + 
					"            	<div class=\"col-12\">\r\n" + 
					"            	  <h2 class=\"text-center\">Popular Forums</h2>\r\n" + 
					"            	</div>\r\n" + 
					"            </div>\r\n" + 
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
				
				stringToSendToWebBrowser +=
						"          		<div class=\"col-lg-4 col-md-6 col-sm-12\">\r\n" + 
						"                <a href=\"forum\">\r\n" + 
						"            		  <div class=\"forum-tile\">\r\n" + 
						"            				<h4>General Discussion</h4>\r\n" + 
						"            				<span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>528 posts</span>\r\n" + 
						"            		  </div>\r\n" + 
						"                </a>\r\n" + 
						"          		</div>\r\n";
			}

			stringToSendToWebBrowser +=
					"          	</div>\r\n" + 
					"          	<div class=\"row\">\r\n" + 
					"          		<div class=\"col-12 d-flex justify-content-center\">\r\n" + 
					"          		  <a href=\"category\"><button class=\"pink-bg\">View All</button></a>\r\n" + 
					"          		</div>\r\n" + 
					"            </div>\r\n" + 
					"  			  </section>\r\n" + 
					"  			</div>\r\n" + 
					"  			<!--POSTS-->\r\n" + 
					"  			<div class=\"col-lg-4 col-md-12\">\r\n" + 
					"  				<section id=\"posts\">\r\n" + 
					"  				  <div class=\"row\">\r\n" + 
					"    					<div class=\"col-12\">\r\n" + 
					"    					  <h2 class=\"text-center\">Latest Posts</h2>\r\n" + 
					"    					</div>\r\n" + 
					"  				  </div>\r\n" + 
					"  				  <div class=\"row\">\r\n" + 
					"    					<div class=\"col-12\">\r\n" + 
					"                <a href=\"post\">\r\n" + 
					"      					  <div class=\"post-tile\">\r\n" + 
					"        						<h4>Example post</h4>\r\n" + 
					"        						<span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span> <span>by username</span><br>\r\n" + 
					"        						<span><i class=\"fa fa-comments\" aria-hidden=\"true\"></i></span> <span>0 comments</span>\r\n" + 
					"      					  </div>\r\n" + 
					"                </a>\r\n" + 
					"    					</div>\r\n" + 
					"              <div class=\"col-12\">\r\n" + 
					"                <a href=\"post\">\r\n" + 
					"      					  <div class=\"post-tile\">\r\n" + 
					"        						<h4>Example post</h4>\r\n" + 
					"        						<span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span> <span>by username</span><br>\r\n" + 
					"        						<span><i class=\"fa fa-comments\" aria-hidden=\"true\"></i></span> <span>0 comments</span>\r\n" + 
					"      					  </div>\r\n" + 
					"                </a>\r\n" + 
					"    					</div>\r\n" + 
					"              <div class=\"col-12\">\r\n" + 
					"                <a href=\"post\">\r\n" + 
					"      					  <div class=\"post-tile\">\r\n" + 
					"        						<h4>Example post</h4>\r\n" + 
					"        						<span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span> <span>by username</span><br>\r\n" + 
					"        						<span><i class=\"fa fa-comments\" aria-hidden=\"true\"></i></span> <span>0 comments</span>\r\n" + 
					"      					  </div>\r\n" + 
					"                </a>\r\n" + 
					"    					</div>\r\n" + 
					"  				  </div>\r\n" + 
					"  				</section>\r\n" + 
					"  			</div>\r\n" + 
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
					"        						<h4>Samaritans</h4>\r\n" + 
					"        						<h4 class=\"phoneno\">116 123</h4>\r\n" + 
					"        						<span></span><span>24-hour, free</span>\r\n" + 
					"      					  </div>\r\n" + 
					"      					</div>\r\n" + 
					"      				</div>\r\n" + 
					"      				<div class=\"row\">\r\n" + 
					"      					<div class=\"col-12 d-flex justify-content-center\">\r\n" + 
					"      						<a href=\"support\"><button class=\"pink-bg\">View All</button></a>\r\n" + 
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
					"        					<a href=\"support\"><button class=\"pink-bg\">View All</button></a>\r\n" + 
					"        				</div>\r\n" + 
					"        			</div>\r\n" + 
					"            </section>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </section>\r\n" + 
					"\r\n" + 
					"    <!--FOOTER-->\r\n" + 
					"    <footer class=\"d-flex align-items-center\">\r\n" + 
					"      <div class=\"container d-flex justify-content-center\">\r\n" + 
					"        <div class=\"row\">\r\n" + 
					"          <div class=\"col-12\">\r\n" + 
					"            <small>&copy; MENTAL HEALTH NI 2019</small>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </footer>\r\n" + 
					"\r\n" + 
					"  </body>\r\n" + 
					"</html>\r\n";
			
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		//if category page...
		else if(toProcess.path.equalsIgnoreCase("category"))
		{
			String stringToSendToWebBrowser =
					"<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\" dir=\"ltr\">\r\n" + 
					"  <head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
					"    <!--bootstrap stylesheet-->\r\n" + 
					"      <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
					"  	<!--google font stylesheet-->\r\n" + 
					"      <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700\" rel=\"stylesheet\">\r\n" + 
					"  	<!--fontawesome stylesheet-->\r\n" + 
					"  	<link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n" + 
					"    <!--regular stylesheet-->\r\n" + 
					"      <link rel=\"stylesheet\" type=\"text/css\" href=\"css/category-style.css\">\r\n" + 
					"  </head><body>\r\n" + 
					"    <!--HEADER-->\r\n" + 
					"  	<header>\r\n" + 
					"  		<div class=\"container-fluid\">\r\n" + 
					"  			<div class=\"row\">\r\n" + 
					"  				<div class=\"col-12 d-flex justify-content-end\">\r\n" + 
					"  					<a href=\"profilepage\"><button class=\"purple-bg\">Login</button></a>\r\n" + 
					"  					<a href=\"profilepage\"><button class=\"pink-bg\">Register</button></a>\r\n" + 
					"  				</div>\r\n" + 
					"  			</div>\r\n" + 
					"  		</div>\r\n" + 
					"  		<nav>\r\n" + 
					"        <div class=\"container-fluid\">\r\n" + 
					"          <div class=\"row d-flex align-items-center\">\r\n" + 
					"            <div class=\"col-3 d-flex justify-content-start\">\r\n" + 
					"              <div class=\"logo\"><a href=\"index\"><strong>Mental Health Forum</strong></a></div>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"col-6\">\r\n" + 
					"              <div class=\"d-flex justify-content-around\">\r\n" + 
					"                <span><a href=\"index\">Home</a></span>\r\n" + 
					"                <span><a href=\"category\">Forums</a></span>\r\n" + 
					"                <span><a href=\"support\">Support</a></span>\r\n" + 
					"                <span><a href=\"contact\">Contact</a></span>\r\n" + 
					"              </div>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"col-3 d-flex justify-content-end\">\r\n" + 
					"              <input type=\"text\" placeholder=\"Search\">\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"  		</nav>\r\n" + 
					"  	</header>\r\n" + 
					"\r\n" + 
					"  <section class=\"category\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12 text-center\">\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"          <h1>Category Page</h1>\r\n" + 
					"          <p>This page will display all of the different types of forms we have to\r\n" + 
					"            offer</p>\r\n" + 
					"          <br>\r\n" + 
					"          <br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"row\">\r\n";

			MVMap<String, Forum> forums = db.s.openMap("Forums");

			List<String> forumKeys = forums.keyList();
			
			//for every forum...
			for(int forumKeyIndex=0;forumKeyIndex<forumKeys.size();forumKeyIndex++)
			{
				String forumUniqueID = forumKeys.get(forumKeyIndex);
				Forum forum = forums.get(forumUniqueID);
				
				stringToSendToWebBrowser +=
						"        <div class=\"col-md-6 col-sm-12\">\r\n" + 
						"    		<a href=\"forum-"+forum.uniqueid+"\">\r\n" + 
						"            <div class=\"forum-tile\">\r\n" + 
						"              <h4>"+ forum.title +"</h4>\r\n" + 
						"              <span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>528 posts</span>\r\n" + 
						"            </div>\r\n" + 
						"          </a>\r\n" + 
						"        </div>\r\n";
			}

			stringToSendToWebBrowser += "      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <br>\r\n" + 
					"    <br>\r\n" + 
					"  </section>\r\n" + 
					"\r\n" + 
					"  <!--FOOTER-->\r\n" + 
					"  <footer class=\"d-flex align-items-center\">\r\n" + 
					"    <div class=\"container d-flex justify-content-center\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12\">\r\n" + 
					"          <small>&copy; MENTAL HEALTH NI 2019</small>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </footer>\r\n" + 
					"\r\n" + 
					"    </body>\r\n" + 
					"    </html>\r\n";
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
			
			//String stringToSendToWebBrowser = "<html><body><p>Post added</p><a href=\"category\">Return to Forum</a></body></html>";
			//toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			
			return true;
		}
		//if forum page...
		else if(toProcess.path.startsWith("forum-")){
			String forumUniqueID = toProcess.path.substring("forum-".length());
			
			String stringToSendToWebBrowser =
					"<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\" dir=\"ltr\">\r\n" + 
					"  <head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
					"    <!--bootstrap stylesheet-->\r\n" + 
					"      <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
					"  	<!--google font stylesheet-->\r\n" + 
					"      <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700\" rel=\"stylesheet\">\r\n" + 
					"  	<!--fontawesome stylesheet-->\r\n" + 
					"  	<link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n" + 
					"    <!--regular stylesheet-->\r\n" + 
					"      <link rel=\"stylesheet\" type=\"text/css\" href=\"css/forum-style.css\">\r\n" + 
					"  </head><body>\r\n" + 
					"  <!--HEADER-->\r\n" + 
					"	<header>\r\n" + 
					"		<div class=\"container-fluid\">\r\n" + 
					"			<div class=\"row\">\r\n" + 
					"				<div class=\"col-12 d-flex justify-content-end\">\r\n" + 
					"					<a href=\"profilepage\"><button class=\"purple-bg\">Login</button></a>\r\n" + 
					"					<a href=\"profilepage\"><button class=\"pink-bg\">Register</button></a>\r\n" + 
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"		</div>\r\n" + 
					"		<nav>\r\n" + 
					"      <div class=\"container-fluid\">\r\n" + 
					"        <div class=\"row d-flex align-items-center\">\r\n" + 
					"          <div class=\"col-3 d-flex justify-content-start\">\r\n" + 
					"            <div class=\"logo\"><a href=\"index\"><strong>Mental Health Forum</strong></a></div>\r\n" + 
					"          </div>\r\n" + 
					"          <div class=\"col-6\">\r\n" + 
					"            <div class=\"d-flex justify-content-around\">\r\n" + 
					"              <span><a href=\"index\">Home</a></span>\r\n" + 
					"              <span><a href=\"category\">Forums</a></span>\r\n" + 
					"              <span><a href=\"support\">Support</a></span>\r\n" + 
					"              <span><a href=\"contact\">Contact</a></span>\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"          <div class=\"col-3 d-flex justify-content-end\">\r\n" + 
					"            <input type=\"text\" placeholder=\"Search\">\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"		</nav>\r\n" + 
					"	</header>\r\n" + 
					"\r\n";

			MVMap<String, Forum> forums = db.s.openMap("Forums");

			//for every forum
			Forum forum = forums.get(forumUniqueID);
			
			stringToSendToWebBrowser +=
					"  <section class=\"forum\">\r\n" + 
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
					"  </section>\r\n" + 
					"  <section class=\"forum-featured\">\r\n" + 
					"    <br>\r\n" + 
					"    <br>\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row d-flex justify-content-center\">\r\n" + 
					"        <div class=\"col-md-8 col-sm-12\">\r\n" + 
					"          <h2 class=\"text-center\">Featured Posts</h2>\r\n" + 
					"          <br>\r\n" + 
					"          <a href=\"post\">\r\n" + 
					"            <div class=\"post-tile\">\r\n" + 
					"              <h4>Forum Rules</h4>\r\n" + 
					"              <span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span>&nbsp;&nbsp;<span>by username</span>\r\n" + 
					"              <br>\r\n" + 
					"              <span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>0 comments</span>\r\n" + 
					"            </div>\r\n" + 
					"          </a>\r\n" + 
					"          <a href=\"post\">\r\n" + 
					"            <div class=\"post-tile\">\r\n" + 
					"              <h4>New here? Introduce yourself! (weekly post)</h4>\r\n" + 
					"              <span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span>&nbsp;&nbsp;<span>by username</span>\r\n" + 
					"              <br>\r\n" + 
					"              <span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>34 comments</span>\r\n" + 
					"            </div>\r\n" + 
					"          </a>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <br>\r\n" + 
					"    <br>\r\n" + 
					"  </section>\r\n" + 
					"  <section class=\"forum\">\r\n" + 
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
			
			for(int i=0;i<forum.posts.size();i++){
				String postName = forum.posts.get(i);
				
				MVMap<String, Post> posts = db.s.openMap("Posts");
				
				Post post = posts.get(postName);
				
				stringToSendToWebBrowser +=
						"    <a href=\"post-"+post.uniqueid+"\">\r\n" + 
						"            <div class=\"post-tile\">\r\n" + 
						"              <h4>"+ post.title +"</h4>\r\n" + 
						"              <span><i class=\"fa fa-user\" aria-hidden=\"true\"></i></span>&nbsp;&nbsp;<span>by username</span>\r\n" + 
						"              <br>\r\n" + 
						"              <span><i class=\"fa fa-comment\" aria-hidden=\"true\"></i></span> <span>0 comments</span>\r\n" + 
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
					"\r\n" + 
					"  <!--FOOTER-->\r\n" + 
					"  <footer class=\"d-flex align-items-center\">\r\n" + 
					"    <div class=\"container d-flex justify-content-center\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12\">\r\n" + 
					"          <small>&copy; MENTAL HEALTH NI 2019</small>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </footer>\r\n" + 
					"\r\n" + 
					"  </body>\r\n" + 
					"  </html>\r\n";
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
			
			//String stringToSendToWebBrowser = "<html><body><p>Post added</p><a href=\"category\">Return to Forum</a></body></html>";
			//toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			
			return true;
		}
		//if post page...
		else if(toProcess.path.startsWith("post-")){
			String postUniqueID = toProcess.path.substring("post-".length());
			
			String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\" dir=\"ltr\">\r\n" + 
					"  <head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
					"    <!--bootstrap stylesheet-->\r\n" + 
					"      <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
					"  	<!--google font stylesheet-->\r\n" + 
					"      <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700\" rel=\"stylesheet\">\r\n" + 
					"  	<!--fontawesome stylesheet-->\r\n" + 
					"  	<link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n" + 
					"    <!--regular stylesheet-->\r\n" + 
					"      <link rel=\"stylesheet\" type=\"text/css\" href=\"css/post-style.css\">\r\n" + 
					"  </head><body>\r\n" + 
					"    <!--HEADER-->\r\n" + 
					"  	<header>\r\n" + 
					"  		<div class=\"container-fluid\">\r\n" + 
					"  			<div class=\"row\">\r\n" + 
					"  				<div class=\"col-12 d-flex justify-content-end\">\r\n" + 
					"  					<a href=\"profilepage\"><button class=\"purple-bg\">Login</button></a>\r\n" + 
					"  					<a href=\"profilepage\"><button class=\"pink-bg\">Register</button></a>\r\n" + 
					"  				</div>\r\n" + 
					"  			</div>\r\n" + 
					"  		</div>\r\n" + 
					"  		<nav>\r\n" + 
					"        <div class=\"container-fluid\">\r\n" + 
					"          <div class=\"row d-flex align-items-center\">\r\n" + 
					"            <div class=\"col-3 d-flex justify-content-start\">\r\n" + 
					"              <div class=\"logo\"><a href=\"index\"><strong>Mental Health Forum</strong></a></div>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"col-6\">\r\n" + 
					"              <div class=\"d-flex justify-content-around\">\r\n" + 
					"                <span><a href=\"index\">Home</a></span>\r\n" + 
					"                <span><a href=\"category\">Forums</a></span>\r\n" + 
					"                <span><a href=\"support\">Support</a></span>\r\n" + 
					"                <span><a href=\"contact\">Contact</a></span>\r\n" + 
					"              </div>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"col-3 d-flex justify-content-end\">\r\n" + 
					"              <input type=\"text\" placeholder=\"Search\">\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"  		</nav>\r\n" + 
					"  	</header>\r\n" + 
					"\r\n" + 
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
					"          <h4>Post Title</h4>\r\n" + 
					"          <br>\r\n" + 
					"          <div class=\"post-tile\">\r\n" + 
					"            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>\r\n" + 
					"            <p>Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Duis ut diam quam nulla porttitor massa id neque. Cursus in hac habitasse platea dictumst quisque sagittis purus sit. Etiam tempor orci eu lobortis elementum nibh. Nibh nisl condimentum id venenatis a condimentum vitae sapien pellentesque. Cras ornare arcu dui vivamus arcu felis.</p>\r\n" + 
					"            <p>Fames ac turpis egestas integer eget aliquet nibh praesent.</p>\r\n" + 
					"            <p>Diam volutpat commodo sed egestas egestas fringilla. Eu feugiat pretium nibh ipsum consequat nisl. Lacus viverra vitae congue eu consequat. Condimentum mattis pellentesque id nibh tortor id aliquet lectus. In aliquam sem fringilla ut morbi tincidunt augue. Ornare arcu dui vivamus arcu felis.</p>\r\n" + 
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
			
					for(int i=0;i<post.comments.size();i++){
						String commentDesc = post.comments.get(i);
						
						MVMap<String, Comment> comments = db.s.openMap("Comments");
						
						Comment comment = comments.get(commentDesc);
						
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
					"							<textarea name=\"comment\" placeholder=\"Enter your comment here...\"></textarea>\r\n" + 
					"              <input type=\"hidden\" name=\"post\" value=\"" + post.uniqueid + "\">\r\n" + 
					"							<input class=\"button purple-bg\" type=\"submit\" style=\"width: 100px;\">\r\n" + 
					"						</form>\r\n" + 
					"					</br>\r\n" + 
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"		</div>\r\n" + 
					"	</section>\r\n" + 
					"\r\n" + 
					"  <!--FOOTER-->\r\n" + 
					"  <footer class=\"d-flex align-items-center\">\r\n" + 
					"    <div class=\"container d-flex justify-content-center\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-12\">\r\n" + 
					"          <small>&copy; MENTAL HEALTH NI 2019</small>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </footer>\r\n" + 
					"\r\n" + 
					"  </body>\r\n" + 
					"  </html>\r\n" + 
					"";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
			/*stringToSendToWebBrowser += "";
			
			//add 
			{
			stringToSendToWebBrowser += "";
			
			MVMap<String, Comment> comments = db.s.openMap("Comments");

			List<String> commentKeys = comments.keyList();

			//To test add a debug news event if there are none in the database
			if(comments.size()==0)
			{
				Comment comment = new Comment();
				comment.uniqueid = ""+System.currentTimeMillis();
				comment.description = "Sample comment blah blah blah.";
				comments.put(comment.uniqueid, comment);

				db.commit();
				
				commentKeys = comments.keyList();
			}
			
			for(int commentKeyIndex=0;commentKeyIndex<commentKeys.size();commentKeyIndex++)
			{
				String commentUniqueID = commentKeys.get(commentKeyIndex);
				Comment comment = comments.get(commentUniqueID);

				stringToSendToWebBrowser += "";

			}
			stringToSendToWebBrowser += "";
			}
			stringToSendToWebBrowser += "";
		}*/
		return false;
	}

}