
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
       
        for (int i = 1; i <= t; i++) {
        	 String output = "";
          int N = in.nextInt();
           int [][] inputTimes = new int [N][2];
           
           //to keep track of current
         
           List<List<Integer>> j_schedule = new ArrayList<List<Integer>>();
           List<List<Integer>> c_schedule = new ArrayList<List<Integer>>(); 

            
           
          for(int j = 0; j< N; j++ ) {
        	  for(int k = 0; k< 2; k++) {
        		  inputTimes[j][k] = in.nextInt();
        	  }
          }
          
          for(int j = 0; j<N; j++) {
        	  int start = inputTimes[j][0]; // start of 1
        	  int end = inputTimes[j][1]; //end of 1
        	  if(j == 0) {
        		  
            	  // assign to j automatically
            	  
        		  List<Integer> list = new ArrayList<Integer>(); 
			        list.add(start); 
			        list.add(end); 
				  c_schedule.add(list);
            	  
            	  output += "C";
        	  } else{
        		  int flag = 0; //haven't found a slot yet
        		  //check J's activities
        		  for(int g = 0; g<c_schedule.size(); g++) {
        			  
        			  int min = c_schedule.get(0).get(0);
        			  int max = 0;
        			  for(int z = 0; z < c_schedule.size(); z++)
        			  {
        				  if (c_schedule.get(z).get(0) < min) min = c_schedule.get(z).get(0);
        				  if (c_schedule.get(z).get(1) > max) max = c_schedule.get(z).get(1);
        			  }
        			  if((start < min && end <= min)||(start >= max && end > max)) {	  
	        				  flag = 1;
        			  }
        		  }
        		  if(flag == 1) {
        			  output += "C";
   				  List<Integer> list = new ArrayList<Integer>(); 
    			        list.add(start); 
    			        list.add(end); 
    				  c_schedule.add(list);
        		  } else if(flag == 0) {
        			  if (j_schedule.isEmpty()) {
        				  output += "J";
        				  List<Integer> list = new ArrayList<Integer>(); 
      			        list.add(start); 
      			        list.add(end); 
      				  j_schedule.add(list);
      				  flag = 1;
        			  } else {
        				  for(int g = 0; g<j_schedule.size(); g++) {
        					  int min = j_schedule.get(0).get(0);
                			  int max = 0;
                			  for(int z = 0; z < j_schedule.size(); z++)
                			  {
                				  if (j_schedule.get(z).get(0) < min) min = j_schedule.get(z).get(0);
                				  if (j_schedule.get(z).get(1) > max) max = j_schedule.get(z).get(1);
                			  }
                			  if((start < min && end <= min)||(start >= max && end > max)) {	  
        	        				  flag = 1;
                			  }
        				  }
        				  if(flag == 1) {
                			  output += "J";
               				  List<Integer> list = new ArrayList<Integer>(); 
                			        list.add(start); 
                			        list.add(end); 
                				  j_schedule.add(list);
                    		  }
        			  }
        		  }
        		  if (flag == 0) {
        			  output = "IMPOSSIBLE";
        			  break;
        		  }
        	  }      	  
          }
        		  
          System.out.println("Case #" + i + ": " + output );		  
        }
	}

}
