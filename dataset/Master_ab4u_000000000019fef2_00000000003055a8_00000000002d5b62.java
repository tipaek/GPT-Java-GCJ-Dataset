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
		int d=1;
		while(t-->0)
		{
		    int x1,y1;
		    String s="";
		    x1=sc.nextInt();
		    y1=sc.nextInt();
		    int a=x1,b=y1;
		    x1=(int)Math.abs(x1);
		    y1=(int)Math.abs(y1);
		    if((x1+y1)%2==1)
		    {
		        int p=(int)(Math.log(x1+y1)/Math.log(2));
		        while(p>-1)
		        {
		        if(Math.abs(a)>Math.abs(b))
		        {
		            if(a>0)
		            {
		                s="E"+s;
		                a=a-(int)Math.pow(2,p);
		            }
		            else
		            {
		                s="W"+s;
		                a=a+(int)Math.pow(2,p);
		            }
		        }
		        else
		        {
		            if(b>0)
		            {
		                s="N"+s;
		                b=b-(int)Math.pow(2,p);
		            }
		            else
		            {
		                s="S"+s;
		                b=b+(int)Math.pow(2,p);
		            }
		        }
		        p--;
		        }
		        
		        
		    }
		    else
		    s="IMPOSSIBLE";
		    System.out.println("Case #"+d+": "+s);
		    d++;
		}
	}
}