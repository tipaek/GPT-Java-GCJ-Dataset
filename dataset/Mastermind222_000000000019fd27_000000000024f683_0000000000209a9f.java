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
		int t;
		t=sc.nextInt();
		int d=1;
		while(t-->0)
		{
			String s;
			s=sc.next();
			int l=s.length();
			int c,m=0;
			String ans="";
			for(int i=0;i<l;i++)
			{
				c=s.charAt(i)-48;
				for(int j=1;j<=(int)(Math.abs(m-c));j++)
				{
					if(m>c)
					ans+=")";
					else
					ans+="(";
				}
				m=c;
				ans+=s.charAt(i);
			}
			for(int i=1;i<=m;i++)
			ans+=")";
			System.out.println("Case #"+d+": "+ans);
			d++;
	}
}
}
