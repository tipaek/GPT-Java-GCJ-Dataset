import java.util.ArrayList;
import java.util.Collections; 
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
       
       boolean check = true;
       
       for (int i = 0; i < inputVersion.length(); i++) {
    	   if (inputVersion.charAt(i) != '0') {
    		   check = false;
    		   break;
    	   }
       }
       
       if (check == true) {
    	   return inputVersion;
       }
       
       int length = inputVersion.length();
              
       int[] array = new int[length];
       List<Integer> arrayList = new ArrayList<>();
       
       for (int i = 0; i < length; i++) {
    	   array[i] = Integer.parseInt(inputVersion.substring(i, i+1));
    	   arrayList.add(i, Integer.parseInt(inputVersion.substring(i, i+1)));
       }
              
       int max = Collections.max(arrayList);
              
       int[][] decomposition = new int[max][length];
       
       for(int i = 0; i < decomposition.length; i++) {
    	   for (int j = 0; j < decomposition[0].length; j++) {
    		   if(arrayList.get(j) != 0) {
    			   decomposition[i][j] = 1;
    			   arrayList.set(j, arrayList.get(j) - 1);
    		   }
    		   else {
    			   decomposition[i][j] = 0;
    		   }
    	   }
       }
       
       List<String> decompositions = new ArrayList<String>();
       
       for(int i = 0; i < decomposition.length; i++) {
		   String temp = "";
    	   for (int j = 0; j < decomposition[0].length; j++) {
    		   temp += decomposition[i][j];
    	   }
    	   decompositions.add(i, temp);
       }
       
       int beginIndex = 0;
       int endIndex = 0;
       int count = 0;
       
       int[] subArray = new int[length];
       
       for (int i = 0; i < max; i++) {
    	   subArray = decomposition[i];
    	   
    	   while(endIndex < length) {
        	   if (subArray[endIndex] == 0) {
        		   
        		   if (beginIndex != endIndex) {
        			   if (beginIndex == 0) {
        				   decompositions.set(i, "(" + decompositions.get(i).substring(0, endIndex + 2*count) + ")" + decompositions.get(i).substring(endIndex+2*count));
        				   beginIndex = endIndex;
        				   count++;
        			   }
        			   else if (endIndex == length) {
        				   decompositions.set(i, decompositions.get(i).substring(0, beginIndex + 2*count) +"(" + decompositions.get(i).substring(beginIndex + 2*count, endIndex + 2*count) + ")");
        				   beginIndex = endIndex;
        				   count++;
        			   }
        			   else {
        				   decompositions.set(i, decompositions.get(i).substring(0, beginIndex + 2*count) +"(" + decompositions.get(i).substring(beginIndex + 2*count, endIndex + 2*count) + ")" + decompositions.get(i).substring(endIndex + 2*count));
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
           
           if (subArray[length - 1] == 1) {
        	    decompositions.set(i, decompositions.get(i).substring(0, beginIndex + 2*count) +"(" + decompositions.get(i).substring(beginIndex + 2*count, endIndex + 2*count) + ")");
        		beginIndex = endIndex;
        		count++;
           }
           
           beginIndex = 0;
           endIndex = 0;
           count = 0;
       }
         
       String result = "";
       String[] indices = new String[max];
       
       for (int i = 0; i < max; i++) {
    	   indices[i] = "0";
       }
       
       int maxLength = 0;
       
       int[] maxLengths = new int[max];
       
       for (int i = 0; i < decompositions.size();i++) {
    	   if (decompositions.get(i).length() > maxLength) {
    		   maxLength = decompositions.get(i).length();
    		   maxLengths[i] = decompositions.get(i).length();
    	   }
       }
       
       int counter = 0;
       
       boolean proceed = true;
       
       while(proceed) {
    	   proceed = false;
    	   String[] currentCharacters = new String[max];
    	   
    	   for(int i = 0; i < decompositions.size(); i++) {
    		   if (Integer.parseInt(indices[i]) < decompositions.get(i).length()) {
    			   currentCharacters[i] = decompositions.get(i).substring(Integer.parseInt(indices[i]), Integer.parseInt(indices[i]) + 1);
    		   }
    	   }
    	   
    	   boolean contains = false;
    	   
    	   for (int i = 0; i < currentCharacters.length; i++) {
    		   if (currentCharacters[i] != null) {
    			   if(currentCharacters[i].equals("(") || currentCharacters[i].equals(")")) {
    				   result+= currentCharacters[i];
    				   contains = true;
    				   indices[i] = Integer.toString(Integer.parseInt(indices[i]) + 1);
    			   }
    		   }
    	   }
    	   
    	   if (contains == false) {
    		   int sum = 0;
    		   for (int i = 0; i < currentCharacters.length;i++) {
    			   if (currentCharacters[i] != null) {
    				   sum+= Integer.parseInt(currentCharacters[i]);
    				   indices[i] = Integer.toString(Integer.parseInt(indices[i]) + 1);
    			   }
    		   }
    		   result += Integer.toString(sum);
    	   }
    	   
    	   for (int l = 0; l < indices.length; l++) {
    		   if (Integer.parseInt(indices[l]) < maxLengths[l]) {
    			   proceed = true;
    			   break;
    		   }
    	   }
       }

       return result;
}
}

	
