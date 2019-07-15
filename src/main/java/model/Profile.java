package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	public String username;
	Date date = new Date();  
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	public String dateJoined = formatter.format(date);
	public String email;
	public String password;
	public int numOfForumsFollowed = 0;
	public int numOfPostsMade = 0;
	public int numOfPostsLiked = 0;
	public String profileImage = null;
	public ArrayList<Post> latestPosts = new ArrayList<Post>();

}
