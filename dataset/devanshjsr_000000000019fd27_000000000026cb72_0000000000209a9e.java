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
		int b=sc.nextInt();
		//int st=1;
		
		while(t>0)
		{
		    String s="";
		    int x=1;
		    
		    while(x<=b)
		    {
		       System.out.println(x);
		       System.out.flush();
		        s+=sc.next(); 
		        x++;
		    }
		    
		    System.out.println(s);
		    System.out.flush();
		    
		    String ans=sc.next();
		    
		    if(ans.equals("N")==true)
		    {
		        break;
		    }
		    
		    
		    
		    
		   t--;
		    
		}
	}
}
