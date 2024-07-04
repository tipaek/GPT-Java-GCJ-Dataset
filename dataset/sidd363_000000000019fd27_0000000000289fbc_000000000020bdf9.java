

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
	   Solution[] activityArrc =   Arrays.copyOf(activityArr, n);
		  
	   Arrays.sort(activityArr, new Comparator<Solution>() { 
            @Override public int compare(Solution p1, Solution p2) 
            { 
                return p1.y - p2.y; 
            } 
        }); 
	   
	   int cetime = -1;
	   int jetime = -1;
       
	   char [] ch = new char[n];
	   //activityArrc
       for (int i = 0; i < n; i++) { 
    	       int st = activityArr[i].x;
    	       int index = 0; 
    	       for(int j=0;j<activityArrc.length;j++) {
    	    	       if(activityArrc[j].x==st && activityArrc[j].y==activityArr[i].y) {
    	    	    	      index = j;
    	    	    	      //System.out.println(" index "+ index);
    	    	    	      break;
    	    	       }
    	       }
    	       if(st <cetime && st <jetime) {
    	    			System.out.println("Case #"+test+": "+"IMPOSSIBLE");
    	    	        return;
    	       }
    	       
    	       if(st >= cetime) {
    	    	      cetime = activityArr[i].y;
    	    	      ch[index] = 'C';
    	    	      
    	       }else if(st >= jetime) {
    	    	      jetime  = activityArr[i].y;
    	    	      ch[index] = 'J';
    	       } 
       } 
       System.out.println("Case #"+test+": "+new String(ch));
		
	}

}
