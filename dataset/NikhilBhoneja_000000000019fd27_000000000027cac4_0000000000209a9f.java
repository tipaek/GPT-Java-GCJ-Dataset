import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[])
	{	
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		sc.nextLine();
		String res1[]=new String[t];
		
		for(int i=0;i<t;i++)
		{
			String res="";
			int c=0,flag=0;
			String s=sc.nextLine();
			for(int j=0;j<s.length();j++)
			{
				char ch=s.charAt(j);
				if(ch=='1')
				{
					if(flag==0)
					{
						res+="(1";
						flag=1;
					}
					else
					{
						res+=1;
					}
				}
				else 
				{
					if(flag==1)
					{
						res+=")0";
						flag=0;
					}
					else
					{
						res+="0";
					}
				}	
			}
			if(flag==1)
			{
				res+=")";
			}
			res1[i]=res;
		}
		for(int i=0;i<t;i++)
		{
			System.out.println("Case #"+(i+1)+": "+res1[i]);
		}
	}
}