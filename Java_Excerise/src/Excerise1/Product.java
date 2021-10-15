package Excerise1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONObject;

public class Product {
	
	String productName;
	int quantity;
	int price;
	
	public void setData(String a, int b ){
		productName=a;
		
		quantity = b;
		
		
		if ( a.equalsIgnoreCase("Coca")) 
		{
			price = 5000;
		}
	
			if(a.equalsIgnoreCase("Noodle"))
			{
				price = 3000;
			}
				if(a.equalsIgnoreCase("Orange"))
				{
					price = 7000;
				}
		
		 }
	
	public static void productBill(String input, String output) throws JSONException, IOException
	{        
		Product[] a = null;
		
		try {
	        	

				File myObj = new File(input);

	        	Scanner myReader = new Scanner(myObj);
	        	
	        	FileOutputStream fos = new FileOutputStream(output);
		  	      DataOutputStream dos = new DataOutputStream(fos);
        		
	        	int sum = 0;
	        	
	        	while(myReader.hasNextLine())
	        		
	        	{
	        		String data = myReader.nextLine();

	        		String words[]=data.split(":\\s");
		  	      
	        		a = new Product[words.length]; 
			  	    
	        		for  (int i = 0; i < words.length; i++)
		  	    		{
	        				a[i] = new Product();
	        				
		  	    		}
	        		
	        		int total = 0;
	        		for (int i = 0; i < words.length; i++)
		  	    	  for (int j= i+1 ; j< words.length; j++)
		  	    	  {
		  	    		  {
		  	    	  
				  	    	String productName = words[i];
				  	    	
				  	    	int quantity = Integer.parseInt( words[j]);
				  	    	
				  	    	a[i].setData(productName,quantity);
				  	    	System.out.println(a[i].productName);
				  	    	System.out.println(a[i].quantity);
				  	    	

				  	    	if (a[i].quantity > 2 & a[i].productName.equalsIgnoreCase("Orange"))
				  	    	{
				  	    		total = a[i].quantity*a[i].price - 5000;
				  	    	}
				  	    	else total = a[i].quantity*a[i].price;
				  	    	 
				  	    	dos.writeBytes(a[i].productName+" ");
				  	    	dos.writeBytes(Integer.toString(a[i].quantity));
				  	    	dos.writeBytes(" ");
				  	    	dos.writeBytes(Integer.toString(total));
				  	    	dos.writeBytes("\n");
				  	    	
				  	    	sum = sum +total;
				  	    	System.out.println(total);
				  	    	
				  	    	System.out.println();
				  	    	
				  	      
		  	    		  }
		  	    		
		  	    		 
		  	    	  }

	        	
	        		}
	        	dos.writeBytes("---------");
	        	dos.writeBytes("\n");
	        	dos.writeBytes("Total ");
  	    		dos.writeBytes(Integer.toString(sum));
  	    		System.out.println(sum);

//		  	      fos.close();
		  	      dos.close();
	        	  myReader.close(); 
	        	  
	        		}
	        catch(FileNotFoundException e)
	        {
	        	System.out.println("An error occurred.");
	        	e.printStackTrace();
	        	}
		//return a;
	        
	}

	
}
