package views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.h2.mvstore.MVMap;

import model.Profile;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class ProfileEditPageView extends DynamicWebPage{

	public ProfileEditPageView(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
		// TODO Auto-generated constructor stub
	}

	public boolean process(WebRequest toProcess) {
		if(toProcess.path.equalsIgnoreCase("editprofile")) {

			String oldUsername = toProcess.cookies.get("username");

			MVMap<String, Profile> profiles = db.s.openMap("Profile");
			Profile profile = profiles.get(oldUsername);

			String username = profile.username;
			String email = profile.email;
			String password = profile.password;
			String imagePath = profile.profileImage;
			System.out.println(imagePath);

			if(imagePath == null) {
				imagePath = "userProfilePics/default.png";
			}


			System.out.println(imagePath);

			String stringToSendToWebBrowser = 
					HeaderFooter.head()+
					HeaderFooter.header()+
					"  <meta charset=\"utf-8\">\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"  <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\r\n" + 
					"  <script type=\"text/javascript\" src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\r\n" + 
					"  <link href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
					"  <link href=\"ProfileEditPageCSS.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"ProfileEditPageCSS.css\">\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body onload='check();'>\r\n" + 

					"  <div class=\"container\">\r\n" + 
					"    <div class=\"row\">\r\n" + 
					"      <div class=\"col-md-12\">\r\n" + 
					"        <h1 class=\"display-3\">Edit profile</h1>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"section\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-4\">\r\n" + 
					"          <div class=\"thumbnail\">\r\n" +
					"<script>\r\n"+
					"submitForm1 = function(){\r\n" + 
					"    document.getElementById(\"form1\").submit();\r\n" +
					"	 window.location.replace(\"/editprofile\");"+	
					"}"+
					"</script>\r\n"+
					"<script>\r\n"+
					"submitForm2 = function(){\r\n" + 
					"    document.getElementById(\"form2\").submit();\r\n" + 
					"}"+
					"</script>\r\n"+
					"            <img src=\""+imagePath+"\" class=\"img-responsive\">\r\n" + 
					"          </div>\r\n" + 
					"          <form action=\"/updateProfilePicture\" method=\"POST\" id=\"form1\"> Select a file:<input type=\"file\" name=\"image\" id=\"image\" class=\".form-control:hover\">\r\n" + 
					"          </form>\r\n" +
					"<input type=\"button\" class=\"button pink-bg\" style=\"width:50%\"  onclick=\"submitForm1()\" value=\"Upload photo\"/>"+
					"        </div>\r\n" + 
					"        <div class=\"col-md-8\">\r\n" + 
					"          <h1>Your details</h1>\r\n" + 
					"<script>\r\n"+
					"var check = function() {\r\n" + 
					"  if (document.getElementById('password').value ==\r\n" + 
					"    document.getElementById('confirmPassword').value) {\r\n" +  
					"    document.getElementById('message').innerHTML = '<input type=\"button\" class=\"button pink-bg\" style=\"width:15%\"  onclick=\"submitForm2()\" value=\"Submit\"/>';\r\n" + 
					"  } else {\r\n" + 
					"    document.getElementById('message').style.color = '#de4f4f';\r\n" + 
					"    document.getElementById('message').innerHTML = '<label>Passwords are not matching!</label>';\r\n" + 
					"  }\r\n" + 
					"}"+
					"</script>\r\n"+
					"          <form  action=\"/updateProfileProcess\" method=\"POST\" id=\"form2\">\r\n" + 
					"            <div class=\"form-group\"> <label>Change Username</label> <input type=\"text\" class=\"form-control\" placeholder=\"Enter username\" name=\"username\" value=\""+username+"\" required=\"required\"> </div>\r\n" + 
					"            <div class=\"form-group\"> <label>Change Email address</label> <input type=\"email\" class=\"form-control\" placeholder=\"Enter email\" name=\"email\" value=\""+email+"\" required=\"required\"> <small class=\"form-text text-muted\">We'll never share your email with anyone else.</small> </div>\r\n" + 
					"            <div class=\"form-group\"> <label>Change Password</label> <input type=\"password\" class=\"form-control\" placeholder=\"Password\" name=\"password\" id=\"password\" value=\""+password+"\" required=\"required\" onkeyup='check();'> </div>\r\n" + 
					"            <div class=\"form-group\"> <label>Confirm Password</label> <input type=\"password\" class=\"form-control\" placeholder=\"Password\" name=\"confirmPassword\" id=\"confirmPassword\" value=\""+password+"\" required=\"required\" onkeyup='check();'> "+

					"</div>"
					+"<span id='message'></span>"
					+ 
					"          </form>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					HeaderFooter.footer();
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

		}
		else if(toProcess.path.equalsIgnoreCase("updateProfileProcess")) {

			String oldUsername = toProcess.cookies.get("username");


			MVMap<String, Profile> profiles = db.s.openMap("Profile");

			if((!(profiles.containsKey(toProcess.params.get("username"))) || oldUsername.equals(toProcess.params.get("username")))){

				Profile oldProfile = profiles.get(oldUsername);

				profiles.remove(oldUsername);
				System.out.println(toProcess.params.get("username"));
				System.out.println(toProcess.params.get("image"));
				Profile updateProfile = new Profile();
				updateProfile.username = toProcess.params.get("username");
				updateProfile.email = toProcess.params.get("email");
				updateProfile.password = toProcess.params.get("password");
				updateProfile.dateJoined = oldProfile.dateJoined;
				updateProfile.profileImage = oldProfile.profileImage;
				updateProfile.numOfForumsFollowed = oldProfile.numOfForumsFollowed;
				updateProfile.numOfPostsMade = oldProfile.numOfPostsMade;
				updateProfile.numOfPostsLiked = oldProfile.numOfPostsLiked;

				if(toProcess.params.get("image") != null) {

					if(!(oldProfile.username.equals(updateProfile.username))) {

						System.out.println("error "+oldProfile.profileImage);

						File oldNameOfFile = new File("httpdocs/"+oldProfile.profileImage);
						int ind = oldProfile.profileImage.lastIndexOf('.');
						String extension = oldProfile.profileImage.substring(ind);

						updateProfile.profileImage = "userProfilePics/"+updateProfile.username+extension;



						InputStream inStream = null;
						try {
							inStream = new FileInputStream(oldNameOfFile);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						OutputStream outStream = null;
						try {
							File ofile = new File("httpdocs/"+updateProfile.profileImage);
							try {
								ofile.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							outStream = new FileOutputStream("httpdocs/userProfilePics/"+updateProfile.username+extension);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						byte[] buffer = new byte[1024];

						int length;

						try {
							while ((length = inStream.read(buffer)) > 0){

								outStream.write(buffer, 0, length);

							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							inStream.close();
							outStream.close();

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("exists: "+oldNameOfFile.exists());
						System.out.println("deleted: "+oldNameOfFile.delete());
					}

				}

				System.out.println(toProcess.params.get("image"));

				profiles.put(updateProfile.username, updateProfile);
				db.commit();

				toProcess.cookies.clear();

				toProcess.cookies.put("username", updateProfile.username);

				return true;
			}
			else {
				String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
						"<html>\r\n" + 
						"<head>\r\n" + 
						"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
						"<style>\r\n" + 
						"body {font-family: Arial, Helvetica, sans-serif;}\r\n" + 
						"\r\n" + 

						".popUp {\r\n" + 
						"  display: none;\r\n" + 
						"  position: fixed;\r\n" + 
						"  z-index: 1;\r\n" + 
						"  padding-top: 100px;\r\n" + 
						"  left: 0;\r\n" + 
						"  top: 0;\r\n" + 
						"  width: 100%;\r\n" + 
						"  height: 100%;\r\n" + 
						"  overflow: auto;\r\n" + 
						"  background-color: rgb(0,0,0);\r\n" + 
						"  background-color: rgba(0,0,0,0.4);\r\n" + 
						"}\r\n" + 
						"\r\n" + 

						".popUp-content {\r\n" + 
						"  background-color: #fefefe;\r\n" + 
						"  margin: auto;\r\n" + 
						"  padding: 20px;\r\n" + 
						"  border: 1px solid #888;\r\n" + 
						"  width: 80%;\r\n" + 
						"}\r\n" + 
						"\r\n" + 

						".close {\r\n" + 
						"  color: #aaaaaa;\r\n" + 
						"  float: right;\r\n" + 
						"  font-size: 28px;\r\n" + 
						"  font-weight: bold;\r\n" + 
						"}\r\n" + 
						"\r\n" + 
						".close:hover,\r\n" + 
						".close:focus {\r\n" + 
						"  color: #000;\r\n" + 
						"  text-decoration: none;\r\n" + 
						"  cursor: pointer;\r\n" + 
						"}\r\n" + 
						"</style>\r\n" + 

						"</head>\r\n" + 
						"<body onload= 'popUp.style.display = \"block\";'>\r\n" + 

						"<div id=\"thePopUp\" class=\"popUp\">\r\n" + 
						"\r\n" + 

						"  <div class=\"popUp-content\">\r\n" + 
						"    <span class=\"close\">&times;</span>\r\n" + 
						"    <p>SORRY!!! This username has already been taken!</p>\r\n" + 
						"  </div>\r\n" + 
						"\r\n" + 
						"</div>\r\n" + 
						"\r\n" + 
						"<script>\r\n" + 

						"var popUp = document.getElementById('thePopUp');\r\n" + 
						"\r\n" + 

						"var span = document.getElementsByClassName(\"close\")[0];\r\n" + 
						"\r\n" + 

						"span.onclick = function() {\r\n" + 
						"  popUp.style.display = \"none\";\r\n" +
						"	 window.location.replace(\"/editprofile\");"+
						"}\r\n" + 
						"\r\n" + 

						"window.onclick = function(event) {\r\n" + 
						"  if (event.target == popUp) {\r\n" + 
						"    popUp.style.display = \"none\";\r\n" + 
						"	 window.location.replace(\"/editprofile\");"+
						"  }\r\n" + 
						"}\r\n" + 
						"</script>\r\n" + 
						"\r\n" + 
						"</body>\r\n" + 
						"</html>";


				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );


			}
		}


		else if(toProcess.path.equalsIgnoreCase("updateProfilePicture")) {
			String username = toProcess.cookies.get("username");

			MVMap<String, Profile> profiles = db.s.openMap("Profile");
			Profile profile = profiles.get(username);

			System.out.println(toProcess.params.get("image"));

			if(toProcess.params.get("image") != null) {
				try {
					try {
						File file = new File(profile.profileImage);
						file.delete();
					}
					catch(NullPointerException e) {
						e.printStackTrace();
					}
					profile.profileImage = toProcess.params.get("image");

					System.out.println(profile.profileImage);

					File uploaded = new File(profile.profileImage);
					int ind = profile.profileImage.lastIndexOf('.');
					String extension = profile.profileImage.substring(ind);

					profile.profileImage = "userProfilePics/"+profile.username+extension;

					InputStream inStream = null;
					try {
						inStream = new FileInputStream(uploaded);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					OutputStream outStream = null;
					try {
						File ofile = new File("httpdocs/userProfilePics/"+profile.username+extension);
						try {
							ofile.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						outStream = new FileOutputStream("httpdocs/userProfilePics/"+profile.username+extension);

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					byte[] buffer = new byte[1024];

					int length;

					try {
						while ((length = inStream.read(buffer)) > 0){

							outStream.write(buffer, 0, length);

						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					inStream.close();
					outStream.close();

				}
				catch(Exception e) {
					profile.profileImage = null;
				}


				System.out.println(profile.profileImage);
			}

			return true;


		}
		return false;
	}


}
