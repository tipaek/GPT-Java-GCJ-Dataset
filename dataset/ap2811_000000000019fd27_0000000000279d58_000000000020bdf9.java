import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=sc.nextInt();
		for(int o=1;o<=t;o++)
		{
			int n=sc.nextInt();
			int start[]=new int[n];
			int end[]=new int[n];
			int index[]=new int[n];
			char ch[]=new char[n];
			StringBuffer s=new StringBuffer();
			for(int i=0;i<n;i++)
			{
				start[i]=sc.nextInt();
				end[i]=sc.nextInt();
				index[i]=i+1;
				ch[i]='x';
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n-i-1;j++)
				{
					if(start[j]>start[j+1])
					{
						int temp=end[j];
						end[j]=end[j+1];
						end[j+1]=temp;
						
						temp=start[j];
						start[j]=start[j+1];
						start[j+1]=temp;
						
						temp=index[j];
						index[j]=index[j+1];
						index[j+1]=temp;
					}
				}
			}
			int c=end[0];int j=0;
			ch[0]='C';
			for(int i=1;i<n;i++)
			{
				if(start[i]>=c)
				{
					c=end[i];ch[i]='C';
				}
				else if(start[i]>=j)
				{
					j=end[i];ch[i]='J';
				}
			}
			int flag=0;
			for(int i=0;i<n;i++)
			{
				if(ch[i]=='x'){ flag=1; break; }
			}
			if(flag==1) s.append("IMPOSSIBLE");
			else
			{
				int m=1;
				//System.out.print("Case #"+o+": ");
				while(m<=n)
				{
					for(int i=0;i<n;i++)
					{
						if(index[i]==m) s.append(ch[i]);
					}
					m++;
				}
			}	
			if(o<t)
				System.out.println("Case #"+o+": "+s);
			else
				System.out.print("Case #"+o+": "+s);
		}
	}
}