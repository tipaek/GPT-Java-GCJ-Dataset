import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
	static int t, n, k, r, c;
	static boolean[] check_r;
	static boolean[][] check_c;
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    t = input.nextInt();
	    for(int a = 1; a<=t; a++)
	    {
	    	k = 0;
	    	r = 0;
	    	c = 0;
	    	n = input.nextInt();
	    	check_c = new boolean[n+1][n+1];
	    	for(int u = 1; u<=n; u++)
	    	{
	    		check_r = new boolean[n+1];
		    	for(int i = 1; i<=n; i++)
	    		{
		    		int temp = input.nextInt();
		    		if(check_r[0]==false)
		    		{
		    			if(check_r[temp]==true)
		    			{
		    				//System.out.println("r_bloen");
		    				check_r[0] = true;
		    				r+=1;
		    			}
		    			else check_r[temp]=true;
		    		}
	    			if(check_c[i][0]==false)
	    			{
	    				//System.out.println("c_good");
	    				if(check_c[i][temp]==true)
	    				{
	    					//System.out.println("c_bloen");
	    					check_c[i][0]=true;
	    					c+=1;
	    				}
	    				else check_c[i][temp]=true;
	    			}
	    			if(u==i) k+=temp;
	    		}
	    	}
	    	System.out.println("Case #"+a+": "+k+" "+r+" "+c);
	    }
    }
}
