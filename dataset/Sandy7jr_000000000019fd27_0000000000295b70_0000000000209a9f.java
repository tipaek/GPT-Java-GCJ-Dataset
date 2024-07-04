import java.util.*;
import java.io.*;


  public class Solution{
      
	
	  
	   public static BufferedReader ob;
	   
    public static void main (String args[])throws IOException{
  
	

	  ob = new BufferedReader(new InputStreamReader(System.in));
	  int t = Integer.parseInt(ob.readLine());
	    
	    int cas = 1;
	    while(t --> 0) {
	    	 String s = ob.readLine();
	    	 
	    	 StringBuilder sb = new StringBuilder();
	    	
	    	boolean start = false;
	    	
	    	
	    	for(char c : s.toCharArray()) {
	    		   if(c == '0' && start == true) {
	    			   start = false;
	    			   sb.append(')');
	    			   sb.append('0');
	    		   }else if(c == '0' && start == false) {
	    			   sb.append('0');
	    		   }else if(c == '1' && start == false) {
	    			      sb.append('(');
	    			      sb.append('1');
	    			      start = true;
	    		   }else {
	    			   sb.append('1');
	    		   }
	    			    		  
	    	}
	    	if(s.charAt(s.length()-1) == '1') {
	    		sb.append(')');
	    	}
	    	String ans = sb.toString();
	    	System.out.println("Case"+" "+"#"+cas+""+":"+" "+ans);
	    	cas++;
	    }
    }
  }