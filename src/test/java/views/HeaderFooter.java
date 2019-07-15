package views;

public class HeaderFooter {
	
	public static String head() {
		return
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
		"	<!--favicon-->\r\n" + 
		"    <link rel=\"shortcut icon\" href=\"img/favicon.png\">" +
		"    <title>Mental Health NI</title>\r\n";
	}
	
	public static String header() {
		return
		"  <!--HEADER-->\r\n" + 
		"	<header>\r\n" + 
		"		<nav>\r\n" + 
		"      <div class=\"container-fluid\">\r\n" + 
		"        <div class=\"row d-flex align-items-center\">\r\n" + 
		"          <div class=\"col-3 d-flex justify-content-start\">\r\n" + 
		"            <div class=\"logo\"><a href=\"index\"><img src=\"img/logo.png\" alt=\"mental health ni logo\"></a></div>\r\n" + 
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
		"            <a href=\"login\"><button class=\"button purple-bg\">Login</button></a>&nbsp;&nbsp;\r\n" + 
		"  			<a href=\"register\"><button class=\"button pink-bg\">Register</button></a>\r\n" + 
		"          </div>\r\n" + 
		"        </div>\r\n" + 
		"      </div>\r\n" + 
		"		</nav>\r\n" + 
		"	</header>\r\n" + 
		"\r\n";
	}
	
	public static String footer() {
		return
		"<!--FOOTER-->\r\n" + 
				"    <footer class=\"d-flex align-items-center\">\r\n" + 
				"      <div class=\"container-fluid\">\r\n" + 
				"        <div class=\"row d-flex justify-content-center align-items-center text-center\">\r\n" + 
				"          <div class=\"col-3\">\r\n" + 
				"            <small>&copy; MENTAL HEALTH NI 2019</small>\r\n" + 
				"          </div>\r\n" + 
				"          <div class=\"col-4\">\r\n" + 
				"            <a href=\"https://www.facebook.com/\" target=\"_blank\"><span><i class=\"fa fa-3x fa-facebook\" aria-hidden=\"true\"></i></span></a>&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
				"            <a href=\"https://twitter.com/\" target=\"_blank\"><span><i class=\"fa fa-3x fa-twitter\" aria-hidden=\"true\"></i></span></a>&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
				"            <a href=\"https://www.instagram.com/\" target=\"_blank\"><span><i class=\"fa fa-3x fa-instagram\" aria-hidden=\"true\"></i></span></a>\r\n" + 
				"          </div>\r\n" + 
				"          <div class=\"col-3\">\r\n" + 
				"            <form method=\"GET\" action=\"search\"><input type=\"search\" name=\"keyword\" placeholder=\"Search\" results=0></form>\r\n" + 
				"          </div>\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </footer>\r\n" + 
				"	\r\n" + 
				"  </body>\r\n" + 
				"</html>";
	}

}
