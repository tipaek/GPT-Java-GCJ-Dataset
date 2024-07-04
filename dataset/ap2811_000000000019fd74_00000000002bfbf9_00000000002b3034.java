import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=sc.nextInt();
		for(int o=1;o<=t;o++)
		{
			int n=sc.nextInt();
			String str[]=new String[n];
			for(int i=0;i<n;i++)
			{
				str[i]=sc.next();
				str[i]=str[i].replace("*","");
			}
			int max=0;
			int k=0;
			for(int i=0;i<n;i++)
			{
				if(str[i].length()>=max)
				{
					k=i;
					max=str[i].length();
				}
			}
			int flag=0;	
			for(int i=0;i<n;i++)
			{
				if(str[k].contains(str[i])) continue;
				else
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
			{
				System.out.println("Case #"+o+": "+"*");
			}
			else
			{
				System.out.println("Case #"+o+": "+str[k]);
			}
		}
	}
}