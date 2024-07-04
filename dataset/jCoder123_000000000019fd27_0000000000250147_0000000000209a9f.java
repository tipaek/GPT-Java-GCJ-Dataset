import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	
	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);	
	        
	        int T = input.nextInt();
	        
	        ArrayList<String> results = new ArrayList<String>();
	        
	        for (int ks = 1; ks <= T; ks++) {
	            results.add(String.format("Case #%d: %s", ks, solve(input)));
	        }
	        
	        for (int i = 0; i < results.size();i++) {
	        	System.out.println(results.get(i));
	        }
	}
	
	public static String solve(Scanner input) {
       String inputVersion = input.next();
       
       if (!(inputVersion.contains("1"))) {
    	   return inputVersion;
       }
       
       if (!(inputVersion.contains("0"))) {
    	   inputVersion = "(" + inputVersion + ")";
    	   return inputVersion;
       }
       int length = inputVersion.length();
              
       int[] array = new int[length];
       List<String> arrayList = new ArrayList<>();
       
       int beginIndex = 0;
       int endIndex = 0;
       int count = 0;
       
       for (int i = 0; i < length; i++) {
    	   array[i] = Integer.parseInt(inputVersion.substring(i, i+1));
    	   arrayList.add(i, inputVersion.substring(i, i+1));
       }
       
       while(endIndex < length) {
    	   if (array[endIndex] == 0) {
    		   
    		   if (beginIndex != endIndex) {
    			   if (beginIndex == 0) {
    				   inputVersion = "(" + inputVersion.substring(0, endIndex + 2*count) + ")" + inputVersion.substring(endIndex + 2*count);
    				   beginIndex = endIndex;
    				   count++;
    			   }
    			   else if (endIndex == length) {
    				   inputVersion = inputVersion.substring(0, beginIndex + 2*count) +"(" + inputVersion.substring(beginIndex + 2*count, endIndex + 2*count) + ")";
    				   beginIndex = endIndex;
    				   count++;
    			   }
    			   else {
    				   inputVersion = inputVersion.substring(0, beginIndex + 2*count) +"(" + inputVersion.substring(beginIndex + 2*count, endIndex + 2*count) + ")" + inputVersion.substring(endIndex + 2*count);
    				   beginIndex = endIndex;
    				   count++;
    			   }
    		   }
    		   else {
    			   beginIndex++;
        		   endIndex++;   
    		   }
    	   }
    	   else {
               endIndex = endIndex+1;
    	   }
       }
       
       if (array[length - 1] == 1) {
    	    inputVersion = inputVersion.substring(0, beginIndex + 2*count) +"(" + inputVersion.substring(beginIndex + 2*count, endIndex + 2*count) + ")";
    		beginIndex = endIndex;
    		count++;
       }
       
       return inputVersion;
	}	
	

}
