import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
	static int t, dep;
	static String[] buffer;
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    t = input.nextInt();
	    for(int a = 1; a<=t; a++)
	    {
	    	buffer = input.next().split("");
	    	System.out.print("Case #"+a+": ");
	    	dep = 0;
	    	for(int q = 0; q<buffer.length; q++)
	    	{
	    		int temp = Integer.parseInt(buffer[q]);
	    		if(dep<temp)
	    		{
	    			left(Math.abs(temp-dep));
	    			dep=temp;
	    		}
	    		else
	    		{
	    			right(Math.abs(temp-dep));
	    			dep=temp;
	    		}
	    		System.out.print(temp);
	    	}
	    	right(dep);
	    	System.out.println();
	    }
	}
	static void left(int a)
	{
		for(int k=0; k<a; k++)
			System.out.print("(");
	}
	static void right(int a)
	{
		for(int k=0; k<a; k++)
			System.out.print(")");
	}
}
