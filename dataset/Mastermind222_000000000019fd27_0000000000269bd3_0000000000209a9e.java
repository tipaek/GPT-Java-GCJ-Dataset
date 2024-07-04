/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
	while(t-->0)
	{
	    int b=sc.nextInt();
	   
	    int q=1;
	    int a[]=new int[10];
	    int  pos=1;
	    while(q<=150)
	    {
	       System.out.println(pos);
	       int n=sc.nextInt();
	       a[pos-1]=n;
	       pos++;
	       if(pos>10)
	       pos=1;
	       q++;
	    }
	    for(int i=0;i<10;i++)
	    System.out.print(a[i]);
	    System.out.println();
	    
	}
	}
}
