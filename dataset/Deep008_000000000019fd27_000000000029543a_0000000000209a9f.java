import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
class Solution {
	
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int test = in.nextInt();  
	    for (int t = 1; t <= test; ++t) {
   	      String  digits = in.next();
	
   	      int length = digits.length();
	      char []arr = digits.toCharArray();
	      String ans="";
	      int depth=0;
	      int integerValue=0;
	      
	      for(int i=0;i<length;i++)
	      {
	    	  integerValue=arr[i]-'0';
	    	  if(integerValue>depth)
	    	  {
	    		  while(integerValue>depth)
	    			  {
	    			    ans+=("(");
	    			    depth++;
	    			  }
	    	  }
	    	  if(integerValue<depth)
	    	  {
	    		  while(integerValue<depth)
	    			  {
	    			    ans+=(")");
	    			    depth--;
	    			  }
	    	  }
	    	  ans+=(integerValue);
	      }
	      System.out.println("Case #" + t + ": "+ans );
	    }
	  }
}