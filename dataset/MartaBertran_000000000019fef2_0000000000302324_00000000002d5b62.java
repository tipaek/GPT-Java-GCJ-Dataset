import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Expogo {
	
	static char[] calculate_pos_x(int goal, int exp)
	{ 
	    int x = 0;
	    char[] result = new char[exp];
	   
	    if (goal % 2 != 0) {
		    if (goal == 1 || goal == -3 && exp == 3 || goal == 3 && exp == 2) {
				  result[0] = 'E';
				  x = x+1;
			  } else {
				  result[0] = 'W';
				  x = x - 1;
			  }
	    }
	    
	    for (int ii = 1; ii < exp; ii++) {
	    	 if (x + Math.pow(2,ii) == goal) {
    			  x = x + (2 ^ ii);
    			  result[ii] = 'E';
	    	  } else if (x - Math.pow(2,ii) == goal) {
    			  x = x - (2 ^ ii);
    			  result[ii] = 'W';
	    	  }
	    	  if (x == goal) break;
	      }
	    
	    return result;
	}
	
	static char[] calculate_pos_y(int goal, int exp)
	{ 
	    int x = 0;
	    char[] result = new char[exp];
	    
	    if (goal % 2 != 0) {
		    if (goal == 1 || goal == -3 && exp == 3 || goal == 3 && exp == 2) {
				  result[0] = 'N';
				  x = x+1;
			  } else {
				  result[0] = 'S';
				  x = x - 1;
			  }
	    }
	    
	    for (int ii = 1; ii < exp; ii++) {
	    	 if (x + Math.pow(2,ii) == goal) {
    			  x = x + (2 ^ ii);
    			  result[ii] = 'N';
	    	  } else if (x - Math.pow(2,ii) == goal) {
    			  x = x - (2 ^ ii);
    			  result[ii] = 'S';
	    	  }
	    	  if (x == goal) break;
	      }
	    
	    return result;
	}
	
	
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    
	    for (int i = 1; i <= t; ++i) {
	      int goal_x = in.nextInt();
	      int goal_y = in.nextInt();
	    
	      if (goal_x % 2 == 0 && goal_y % 2 == 0 || goal_x % 2 != 0 && goal_y % 2 != 0) {
    		  System.out.println("Case #" + i + ": IMPOSSIBLE");
    		  continue;
    	  }
	      
	      int exp_max = 0; 
    	  if (goal_x + goal_y < 4 && goal_x + goal_y > -4) {
    		  exp_max = 2; 
    	  } else {
    		  exp_max = 3; 
    	  }
    		  
	      char[] res_x = calculate_pos_x(goal_x, exp_max);
	      char[] res_y = calculate_pos_y(goal_y, exp_max);
	      
	      StringBuilder s = new StringBuilder();
	      for (int ii = 0; ii < exp_max; ii++) {
	    	  if (res_x[ii] != 0) {
	    		  s.append(res_x[ii]);
	    	  } else if (res_y[ii] != 0) {
	    		  s.append(res_y[ii]);
	    	  }
	      }
	      
	      System.out.println("Case #" + i + ": " + s.toString());
	    }
	}
}