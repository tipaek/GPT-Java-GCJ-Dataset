import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
        	int n = in.nextInt();
        	List<int[]> activityTime = new ArrayList<>();
        	boolean[] actJ = new boolean[1441];
        	boolean[] actC = new boolean[1441];
        	String result = "";
        	
        	for (int j = 0; j < n; j++)
        	{
				int[] time = new int[2];
				time[0] = in.nextInt();
				time[1] = in.nextInt();
				activityTime.add(time);
			
				
			}
        
        	
        	for (int j = 0; j < n; j++) {
        		
        		int[] interval = activityTime.get(j);
        		if( isAssignmentPossible(interval, actC) )
            	{
            		for(int k = interval[0]; k < interval[1]; k++ ) {
            				actC[k] = true;
            		}
            		result = result + "C";
            			
            		
            	}
            		else if( isAssignmentPossible(interval, actJ) )
            		{
            			for (int k = interval[0]; k < interval[1]; k++) {
							actJ[k] = true;
						}
            			result = result + "J";
            			
            			
            		}
            		else 
            		{
            			result = "IMPOSSIBLE";
            			break;
    				}
        		
        		
				
        		
        		
			}
        	
         
                   
       
          System.out.println("Case #"+i+": " + result);  
        }
        in.close();
      }
      
      private static boolean isAssignmentPossible(int[] activity, boolean[] schedule)
      {
    	  
    	 boolean flag = schedule[activity[0]];
    	 
    	 for (int i = activity[0]+1; i < activity[1]; i++) {
			flag = flag || schedule[i];
		}
    	 
    	 return !flag;
    	
      }
      
    
      
    }
