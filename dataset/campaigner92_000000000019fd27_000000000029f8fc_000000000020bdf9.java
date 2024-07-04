import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		
	  Scanner scan = new Scanner(System.in);
	  int testcases = scan.nextInt();
      String[] result = new String[testcases];
      
       for(int t=0; t<testcases; t++){
    	   result[t]="";
    	   
    	   int turn = scan.nextInt();
    	   ArrayList<String> j_ts = new ArrayList<String>();
    	   ArrayList<String> c_ts = new ArrayList<String>();
    	      
    	   for(int k=0;k<turn;k++) {
	    	   int start_time = scan.nextInt();
	    	   int end_time = scan.nextInt();
	    	   
	    	   
	    	   
	    	   boolean j_busy=false;
	    	   boolean c_busy=false;
	    	   
	    	   //go through j's timeslot
	    	   for (int ctr = 0; ctr < j_ts.size(); ctr++) { 		      
	    	          String[] spliter = j_ts.get(ctr).split(",");
	    	          int st=Integer.parseInt(spliter[0]);
	    	          int et=Integer.parseInt(spliter[1]);
	    	          if(start_time==st && end_time==et) {
	    	        	  j_busy=true;
	    	          }
	    	          else    	          
	    	           if((start_time> st && start_time<et) ||
	    	        		  (end_time> st && end_time<et) ||
	    	        		  (st> start_time && st<end_time) ||
	    	        		  (et> start_time && et<end_time)) {
	    	        	 j_busy=true;
	    	          }
	    	          
	    	      }
	    	   
	    	   if(!j_busy) {
	    		   String tym = start_time+","+end_time;
	    		   j_ts.add(tym);
	    		   result[t]+="J";
	    	   }
	    	   else {
	    		   
	    		   
	    		 //go through c's timeslot
	        	   for (int ctr = 0; ctr < c_ts.size(); ctr++) { 		      
	        	          String[] spliter = c_ts.get(ctr).split(",");
	        	          int st=Integer.parseInt(spliter[0]);
	        	          int et=Integer.parseInt(spliter[1]);
	        	          
	        	          if(start_time==st && end_time==et) {
		    	        	  c_busy=true;
		    	          }
		    	          else 
	        	          if((start_time> st && start_time<et) ||
		    	        		  (end_time> st && end_time<et) ||
		    	        		  (st> start_time && st<end_time) ||
		    	        		  (et> start_time && et<end_time)) {
	        	        	 
	        	        	  c_busy=true;
	        	          }
	        	          
	        	      }
	        	   
	        	   if(c_busy) {
	        		   result[t]="IMPOSSIBLE";
	        
	        	   }else {
	        		   String tym = start_time+","+end_time;
		    		   c_ts.add(tym);
	        		   result[t]+="C";
	        	   }
	    		   
	    	   }
    	   
    	   }
    	      
       
       }

       for(int t=0;t<testcases;t++) {
    	   System.out.println("Case #"+(t+1)+": " + result[t]);
       }
	  
	}
}
