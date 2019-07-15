package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Forum implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//forum unique id
	public String uniqueid;
	
	//forum title
	public String title;
	
	//forum's posts
	public ArrayList<String> posts = new ArrayList<String>();
	  
}