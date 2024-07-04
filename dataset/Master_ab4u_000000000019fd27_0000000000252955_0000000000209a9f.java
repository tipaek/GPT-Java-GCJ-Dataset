import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		String a=sc.nextLine();
		int tt=1;
		while(t-->0)
		{
			String s;
			s=sc.nextLine();
			int len=s.length();
			int i,d,m=0,j;String s1="";
			for(i=0;i<len;i++)
			{
				d=s.charAt(i)-48;
				for(j=1;j<=(int)(Math.abs(m-d));j++)
				{
					if(m>d)
					s1+=")";
					else
					s1+="(";
				}
				m=d;
				s1+=s.charAt(i);
			}
			for(i=1;i<=m;i++)
			s1+=")";
			System.out.println("Case #"+tt+": "+s1);
			tt++;
		}
	}
}