import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
	static int t, n;
	static int[][] buffer;
	static int[] c, j;
	static String[] result;
	static boolean bb;
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    t = input.nextInt();
	    for(int a = 1; a<=t; a++)
	    {
	    	n = input.nextInt();
	    	buffer = new int[n][2];
	    	result = new String[n];
	    	bb=false;
	    	for(int s = 0; s<n; s++)
	    	{
	    		buffer[s][0] = input.nextInt();
	    		buffer[s][1] = input.nextInt();
	    	}
	    	System.out.print("Case #"+a+": ");
	    	c = new int[1440];
	    	j = new int[1440];
	    	for(int s = 0; s<n; s++)
	    	{
	    		if(fill_c(buffer[s][0], buffer[s][1]))
	    			result[s]="C";
	    		else
	    			if(fill_j(buffer[s][0], buffer[s][1]))
	    				result[s]="J";
	    			else
	    			{
	    				bb=true;
	    				break;
	    			}
	    	}
	    	if(bb)
	    		System.out.print("IMPOSSIBLE");
	    	else
	    		for(String temp:result)
	    			System.out.print(temp);
	    	System.out.println();
	    }
	}
	static boolean fill_c(int s, int e)
	{
		for(int start = s; start<e; start++)
		{
			c[start]+=1;
			if(c[start]>=2)
			{
				for(int rev = start; rev>=s; rev--)
					c[rev]-=1;
				return false;
			}
		}
		return true;
	}
	static boolean fill_j(int s, int e)
	{
		for(int start = s; start<e; start++)
		{
			j[start]+=1;
			if(j[start]>=2)
			{
				for(int rev = start; rev>=s; rev--)
					j[rev]-=1;
				return false;
			}
		}
		return true;
	}
}
