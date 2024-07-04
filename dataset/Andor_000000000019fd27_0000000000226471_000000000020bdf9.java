import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
	static int t, n;
	static act[] buffer;
	static int[] c, j;
	static String[] result;
	static boolean bb;
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    t = input.nextInt();
	    for(int a = 1; a<=t; a++)
	    {
	    	n = input.nextInt();
	    	buffer = new act[n];
	    	result = new String[n];
	    	bb=false;
	    	for(int s = 0; s<n; s++)
	    		buffer[s] = new act(s, input.nextInt(), input.nextInt());
	    	Arrays.parallelSort(buffer);
	    	System.out.print("Case #"+a+": ");
	    	c = new int[1440];
	    	j = new int[1440];
	    	for(int s = 0; s<n; s++)
	    	{
	    		if(fill_c(buffer[s].start, buffer[s].end))
	    			result[buffer[s].index]="C";
	    		else
	    			if(fill_j(buffer[s].start, buffer[s].end))
	    				result[buffer[s].index]="J";
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
class act implements Comparable<act> {
	int index, start, end;
	public act(int a, int b, int c)
	{
		index = a;
		start = b;
		end = c;
	}
	public int compareTo(act other)
	{
		return this.start-other.start;
	}
}
