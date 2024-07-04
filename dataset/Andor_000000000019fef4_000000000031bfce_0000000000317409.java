import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
	static int t, x, y, min;
	static String[] moves;
	static int[] x_list, y_list;
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    t = input.nextInt();
	    for(int a = 1; a<=t; a++)
	    {
	    	x = input.nextInt();
	    	y = input.nextInt();
	    	moves = input.next().split("");
	    	//System.out.println(moves);
	    	x_list = new int[moves.length+1];
	    	y_list = new int[moves.length+1];
	    	x_list[0] = x;
	    	y_list[0] = y;
	    	for(int count = 1; count<=moves.length; count++)
	    	{
	    		String k = moves[count-1];
	    		//System.out.print(k+" ");
	    		if(k.equals("N"))
	    		{
	    			x_list[count] =  x_list[count-1];
	    			y_list[count] =  y_list[count-1]+1;
	   			}
	    		else
	    			if (k.equals("S"))
	    			{
	    				x_list[count] =  x_list[count-1];
	    				y_list[count] =  y_list[count-1]-1;
	    			}
	    			else
		    			if (k.equals("W"))
		    			{
		    				x_list[count] =  x_list[count-1]-1;
		    				y_list[count] =  y_list[count-1];
		    			}
		    			else
			    			if (k.equals("E"))
			    			{
		    					x_list[count] =  x_list[count-1]+1;
	    						y_list[count] =  y_list[count-1];
			    			}
	    		
	    	}
	    	min = moves.length+2;
    		for(int look = 0; look<x_list.length; look++)
    		{
    			//System.out.println(x_list[look]+" "+y_list[look]+" "+look);
    			if(Math.abs(x_list[look])+Math.abs(y_list[look])<=look)
    				min = Math.min(min, look);
    		}
	    	if(min==moves.length+2) System.out.println("Case #"+a+": IMPOSSIBLE");
    		else System.out.println("Case #"+a+": "+min);
	    }

	}
}