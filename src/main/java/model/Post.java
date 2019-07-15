package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//post unique id
	public String uniqueid;
	
	//post title
	public String title;
	
	//post description
	public String description;
	
	//post's comments
	public ArrayList<String> comments = new ArrayList<String>();
	  
}