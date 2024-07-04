import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
	    
	   Scanner scnr = new Scanner(System.in);
	   int numEntries = Integer.parseInt(scnr.nextLine());
	   String retVal;
	   for(int i=0;i<numEntries;i++){
	       char[] entries = scnr.nextLine().toCharArray();
	       retVal = "Case #" +(i+1) + ": ";
	       int currParenthesis= 0;
	       for(int j=0; j<entries.length;j++){
	    	   int entry=Integer.parseInt(String.valueOf(entries[j]))	;
        	   int toChange = currParenthesis-entry;
	           if(toChange !=0) {
	        	   while(toChange!=0) {
	        		   if(toChange<0) {
	        			   retVal= retVal + "(";
	        			   currParenthesis++;
	        			   toChange++;
	        		   }else {
	        			   retVal = retVal + ")";
	        			   currParenthesis--;
	        			   toChange--;
	        		   }
	        	   }

	           }
	           retVal = retVal+ entry;
	       }
	       while(currParenthesis!=0) {
	    	   retVal = retVal + ")";
			   currParenthesis--;
	       }
	       System.out.println(retVal);
	       
	   }
}
		
}
