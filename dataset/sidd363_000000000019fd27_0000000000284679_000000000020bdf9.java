

import java.util.*;


public class Solution {
	//360 480
	//420 540
	//600 660
	//cjc
	
//	4
//	3
//	360 480
//	420 540
//	600 660
	 
	    int x; 
	    int y; 
	  
	    // Constructor 
	    public Solution(int x, int y) 
	    { 
	        this.x = x; 
	        this.y = y; 
	    } 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int test = 1;
		while(t-- >0) {
			
			int n = sc.nextInt();
			Solution [] activityArr = new Solution[n];
			
			for(int  i =0;i<n;i++) {
				    int x1 , y1;
					 x1 = sc.nextInt();
					 y1 = sc.nextInt();
					 activityArr[i]=new Solution(x1, y1);
				
			}
			compute(activityArr, n, test);
			test++;
		}
		
	}

	private static void compute(Solution[] activityArr, int n, int test) {
		// TODO Auto-generated method stub
	
		  
	   Arrays.sort(activityArr, new Comparator<Solution>() { 
            @Override public int compare(Solution p1, Solution p2) 
            { 
                return p1.y - p2.y; 
            } 
        }); 
	   
	   
	   int cetime = activityArr[0].y;
	   int jetime = activityArr[1].y;
       
	   StringBuilder sb = new StringBuilder("CJ");
	   if(activityArr.length==2) {
		   System.out.println("Case #"+test+": "+sb);
		   return;
	   }
	   
	   
       for (int i = 2; i < n; i++) { 
    	       int st = activityArr[i].x;
    	       if(st <cetime && st <jetime) {
    	    			System.out.println("Case #"+test+": "+new StringBuilder("IMPOSSIBLE"));
    	    	        return;
    	       }
    	       if(st >= cetime) {
    	    	      cetime = activityArr[i].y;
    	    	      sb.append("C");
    	    	      
    	       }else if(st >= jetime) {
    	    	      jetime  = activityArr[i].y;
    	    	      sb.append("J");
    	       } 
       } 
       System.out.println("Case #"+test+": "+sb);
		
	}

}
