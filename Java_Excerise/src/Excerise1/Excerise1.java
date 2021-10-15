package Excerise1;

import java.io.IOException;

import org.json.JSONException;

public class  Excerise1{

	   /* This is my first java program.
	    * This will print 'Hello World' as the output
	    */
	public static int getMaxValue(int[] numbers){
		
		  int maxValue = 0;
	
		  
		  for(int i=0;i < numbers.length;i++){
			  for (int j=i+1; j < numbers.length; j++) {
				  //maxValue = numbers[1] - numbers[0];
				  
				  int tampt = numbers[j] - numbers[i];
			  
				  if(tampt > maxValue)
				  {
					  maxValue = tampt;
				  }
		    
			  }
		  }
		  return maxValue;
		}

	public static String capitalizeFirstLetter(String str)
	{
		
        String words[]=str.split("\\s");
        String capitalizeStr="";
 
        for(String word:words){
        	if (word.length()>1) {
            // Capitalize first letter
            String firstLetter = word.substring(0,1);
            // Get remaining letter
            String remainingLetters = word.substring(1);
            capitalizeStr+=firstLetter.toUpperCase()+remainingLetters+" ";
        	}
        	else
        	{
        		
        		capitalizeStr+=word+" ";
        	}
        }
		return capitalizeStr.trim();
	}

	public static void main(String []args) throws JSONException, IOException {
	     	// Find maximum value
		   int[] A = {2,5,3,9,15,20,1,17};
		   int maxValue = getMaxValue(A);
		   System.out.print("Max value is " + maxValue);
		   System.out.print("\n");
		   
		   //Capitalize the first letter of word in String
		   String str = "This is a book";
		   String result;
		   result = capitalizeFirstLetter(str);
		   System.out.print(result);
		   System.out.print("\n");
		   System.out.print("\n");
		  
		   //testing for Course
		   Course[]  a = Course.readJsonFile("src/Excerise1/JSON.json");
		  
		   Course.filterByLevel(a, 1);
		   Course.filterByIntructor(a,"Mary");
		   Course.filterByLevelAndLesson(a,1,8);
		   Course.filterByKeyword(a,"sep");
	   
		   //testing for Product
		   Product.productBill("src/Excerise1/InputData.txt","src/Excerise1/Output.txt");
		 
		   

	   }
	}