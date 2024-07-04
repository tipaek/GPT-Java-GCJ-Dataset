/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		 Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i =1;i<=t;i++){
		     int x = sc.nextInt();
		     int y = sc.nextInt();
		     //sc.nextLine();
		     String m= sc.nextLine();
		 //   System.out.println(m);
 	        int ind =1;
 	        int dis = x + y;
 	        int time = 0;
		     while(m.length()>ind && dis >time){
		       char c = m.charAt(ind);
		        ind++;
		        if(c=='N')
		         y++;
		        
		        if(c=='S')
		         y--;
		         
		        if(c=='E')
		        x++;
		        
		        if(c=='W')
		        x--;
		        
		        dis = Math.abs(x) + Math.abs(y);
		        time++;
		        
		             
		             
		             
		         }
		         
		         if(dis <= time)
		         System.out.println("Case #" + i + ": " +time);
		         else
		         System.out.println("Case #" + i + ": IMPOSSIBLE");
		         
		         
		         
		         
		     }
		     
		     
		     
		     
		    
		    
		}
	}

