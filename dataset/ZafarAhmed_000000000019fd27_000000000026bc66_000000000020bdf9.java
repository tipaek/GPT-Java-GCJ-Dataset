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
        	int[][] activityTime = new int[n][2];
        	List<int[]> actJ = new ArrayList<>();
        	List<int[]> actC = new ArrayList<>();
        	String result = "";
        	
        	for (int j = 0; j < n; j++)
        	{
				int[] time = new int[2];
				time[0] = in.nextInt();
				time[1] = in.nextInt();
				activityTime[j] = time;
				
			}
        	
        	for (int j = 0; j < n; j++) {
				
        		if( isAssignmentPossible(activityTime[j], actC) )
        		{
        			actC.add(activityTime[j]);
        			result = result + "C";
        		}
        		else if( isAssignmentPossible(activityTime[j], actJ) )
        		{
        			actJ.add(activityTime[j]);
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
      
      private static boolean isAssignmentPossible(int[] activity, List<int[]> schedule)
      {
    	  for( int[] sh : schedule ) 
    	  {
    		  if( (activity[0] >= sh[0] && activity[0] < sh[1]) || (activity[1] > sh[0] && activity[1] <= sh[1]) )
    		  {
        			  return false;
        		}
    		  
    		  else if( (sh[0] >= activity[0] && sh[0] < activity[1]) || (sh[1] > activity[0] && sh[1] <= activity[1]) ) 
    		  {
        			  return false;
        	  }
    		  
    		  
    	  }
    	  return true;
      }
      
    }
