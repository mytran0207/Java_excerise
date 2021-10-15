package Excerise1;

//import java.util.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import java.io.File;
import java.io.FileNotFoundException;



public class Course {
	
	String courseId;
	String courseName;
	String instructor;
	String startDate ;
	int lessons;
	int level;
	
	public void setData(String a, String b, String c, String d, int e, int f ){
		courseId=a;
		
		courseName = b;
		instructor = c;
		startDate = d;
		lessons = e;
		level = f;
		 }
	
public static Course[] readJsonFile(String path) throws JSONException
{        
	Course[] a = null;
	
	try {
        	
			//Course[] a = null;
			File myObj = new File(path);
        	//File myObj = new File("src/Excerise1/JSON.json");
        	Scanner myReader = new Scanner(myObj);
        	
        	while(myReader.hasNextLine())
        	{
        		String data = myReader.nextLine();
        		//System.out.println(data);

	  	        
	  	        JSONObject obj = new JSONObject(data);

	  	        
	  	      JSONArray arr = obj.getJSONArray("courses");
	  	    //  n = arr.length();
	  	    a = new Course[arr.length()]; 
	  	    
	  	    for  (int i = 0; i < arr.length(); i++)
	  	    {
	  	    	a[i] = new Course();
	  	    }
	  	 
	  	      for (int i = 0; i < arr.length(); i++)
	  	    	{
	  	      String courseId = arr.getJSONObject(i).getString("courseId");	  
	  	      
	  	      //System.out.println("courseId: " + courseId);
	  	      
	  	     
	  	    String courseName = arr.getJSONObject(i).getString("courseName");	  	      
	  	      //System.out.println("courseName: " + courseName);
	  	     
	  	    
	  	     String instructor = arr.getJSONObject(i).getString("instructor");	  	      
	  	     //System.out.println("instructor: " + instructor);
	  	   
	  	    
	  	      String startDate = arr.getJSONObject(i).getString("startDate");	  	      
	  	    //System.out.println("startDate: " + startDate);
	  	    
	  	      
	  	      int lessons = arr.getJSONObject(i).getInt("lessons");	  	      
	  	     //System.out.println("lessons: " + lessons);
	  	   
	  	      
	  	      int level = arr.getJSONObject(i).getInt("level");	  	      
	  	      //System.out.println("level: " + level);
	  	      //System.out.print("\n");
	  	      
	  	     a[i].setData(courseId, courseName,instructor, startDate, lessons,level);
	  	    
	  	    	}

        	
        		}
        	  myReader.close(); 
        	  
        		}
        catch(FileNotFoundException e)
        {
        	System.out.println("An error occurred.");
        	e.printStackTrace();
        	}
	return a;
	
	
        
}

public static void filterByLevel(Course[] a, int level)
{
	boolean isNoAnyItemMatching = true;

	for(int i=0;i < a.length;i++)
	{
		if (a[i].level == level)
		{	
			
			  isNoAnyItemMatching = false;
			  System.out.println("THE MATCHING COURESES WITH INPUT LEVEL: ");
			  
	  	      System.out.println("courseId: " + a[i].courseId);
	  	      
	  	      System.out.println("courseName: " + a[i].courseName);
	  	     
	  	      System.out.println("instructor: " + a[i].instructor);
	  	   
	  	      System.out.println("startDate: " + a[i].startDate);
	  	      	      
	  	      System.out.println("lessons: " + a[i].lessons);
	  	   	      
	  	      System.out.println("level: " + a[i].level);
	  	      System.out.print("\n");
		}
		
	}
	if(isNoAnyItemMatching)
	{
		System.out.println("No matching course with level");
	}
}

public static void filterByIntructor(Course[] a, String intructor)
{
	boolean isNoAnyItemMatching = true;
	for(int i=0;i < a.length;i++)
	{
		if (a[i].instructor.equalsIgnoreCase(intructor))
		{
			  isNoAnyItemMatching = false;
			  System.out.println("THE MATCHING COURESES WITH INPUT INSTRUCTOR: ");
			  
	  	      System.out.println("courseId: " + a[i].courseId);
	  	      
	  	      System.out.println("courseName: " + a[i].courseName);
	  	     
	  	      System.out.println("instructor: " + a[i].instructor);
	  	   
	  	      System.out.println("startDate: " + a[i].startDate);
	  	      	      
	  	      System.out.println("lessons: " + a[i].lessons);
	  	   	      
	  	      System.out.println("level: " + a[i].level);
	  	      System.out.print("\n");
		}	
		
	}
	if(isNoAnyItemMatching)
	{
		System.out.println("No matching course with intructor");
	}
		
}
public static void filterByLevelAndLesson(Course[] a, int l, int ls)
{
	boolean isNoAnyItemMatching = true;
	for(int i=0;i < a.length;i++)
	{
		if (a[i].level==l & a[i].lessons==ls)
		{
			isNoAnyItemMatching = false;
			
			  System.out.println("THE MATCHING COURESES WITH INPUT LEVEL AND LESSON: ");
			  
	  	      System.out.println("courseId: " + a[i].courseId);
	  	      
	  	      System.out.println("courseName: " + a[i].courseName);
	  	     
	  	      System.out.println("instructor: " + a[i].instructor);
	  	   
	  	      System.out.println("startDate: " + a[i].startDate);
	  	      	      
	  	      System.out.println("lessons: " + a[i].lessons);
	  	   	      
	  	      System.out.println("level: " + a[i].level);
	  	      System.out.print("\n");
		}
			
	}
	if(isNoAnyItemMatching)
	{
		System.out.println("No matching course with level and lesson");
	}
	
}
   
public static void filterByKeyword(Course[] a, String keyword)
{
	boolean isNoAnyItemMatching = true;
	for(int i=0;i < a.length;i++)
	{
		if (a[i].courseId.toLowerCase().contains(keyword.toLowerCase()) 
				| a[i].courseName.toLowerCase().contains(keyword.toLowerCase()) 
				| a[i].instructor.toLowerCase().contains(keyword.toLowerCase())
				| a[i].startDate.toLowerCase().contains(keyword.toLowerCase()))
		{
			isNoAnyItemMatching = false;
			  System.out.println("THE MATCHING COURESES WITH INPUT KEYWORD: ");
			  
	  	      System.out.println("courseId: " + a[i].courseId);
	  	      
	  	      System.out.println("courseName: " + a[i].courseName);
	  	     
	  	      System.out.println("instructor: " + a[i].instructor);
	  	   
	  	      System.out.println("startDate: " + a[i].startDate);
	  	      	      
	  	      System.out.println("lessons: " + a[i].lessons);
	  	   	      
	  	      System.out.println("level: " + a[i].level);
	  	      System.out.print("\n");
		}		
			
	}
	if(isNoAnyItemMatching)
	{
		System.out.println("No matching course with keyword");
	}
}

}


