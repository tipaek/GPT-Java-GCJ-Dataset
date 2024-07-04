import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
	  Scanner scan = new Scanner(System.in);
	  int testcases = scan.nextInt();
	  scan.nextLine();
      String[] result = new String[testcases];
      
       for(int t=0; t<testcases; t++){
    	   result[t]="";
    	   
    	   String s= scan.nextLine();
    	      int str_len = s.length();
    	      
    	      int curr_opening = -1;
    	  	  int curr_closing = -1;
    	  	  int next_opening = -1;
    		  int next_closing = -1;
    	  	  
    	  	  if(str_len>0) {
    	  		 curr_opening = Integer.parseInt(String.valueOf(s.charAt(0)));
    	    	 curr_closing = Integer.parseInt(String.valueOf(s.charAt(0)));
    		  }
    	  	
    	      
    	      for(int ctr=0;ctr<str_len-1;ctr++) {
    	    	next_opening = Integer.parseInt(String.valueOf(s.charAt(ctr+1)));
    	      	next_closing = Integer.parseInt(String.valueOf(s.charAt(ctr+1)));
    	      	
    	    	  while(next_opening > 0 && curr_closing > 0) {

    	      		next_opening = next_opening-1;
    	      		curr_closing = curr_closing -1;
    	      	}
    	    	  
    	    	for(int i=0;i<curr_opening;i++) {
    	    		result[t] += "(";
    	    	}
    	    	result[t] += Integer.parseInt(String.valueOf(s.charAt(ctr)));
    	    	
    	    	for(int i=0;i<curr_closing;i++) {
    	    		result[t] += ")";
    	    	}
    	    	curr_opening = next_opening;
    	    	curr_closing = next_closing;
    		    
    	      }
    	      
    	     
    	      
    	      for(int i=0;i<curr_opening;i++) {
    	    	  result[t] += "(";
    	  	  }
    	      result[t] += String.valueOf(s.charAt(str_len-1));
    		  	
    		  	for(int i=0;i<curr_closing;i++) {
    		  		result[t] += ")";
    		  	}
       
       }
       scan.close();
       
       for(int t=0;t<testcases;t++) {
    	   System.out.println("Case #"+(t+1)+": " + result[t]);
       }
	  
	}
}
