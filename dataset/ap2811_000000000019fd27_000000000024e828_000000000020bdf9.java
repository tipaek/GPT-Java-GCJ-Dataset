import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int o=1;o<=t;o++)
		{
			int n=sc.nextInt();
			int start[]=new int[n];
			int end[]=new int[n];
			int index[]=new int[n];
			char ch[]=new char[n];
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
					if(end[j]>end[j+1])
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
			int e=end[0];int k=0;
			ch[0]='C';
			for(int i=1;i<n;i++)
			{
				if(start[i]>=e)
				{
					ch[i]='C';
					e=end[i];
				}
			}
			for(int i=0;i<n;i++)
			{
				if(ch[i]=='x'){ k=i; break;}
			}
			ch[k]='J';
			e=end[k];
			for(int i=k+1;i<n;i++)
			{
				if(start[i]>=e && ch[i]=='x')
				{
					ch[i]='J';
					e=end[i];
				}
			}
			if(n==2)
			{
				if((ch[0]=='C' && ch[1]=='J')||(ch[0]=='J' && ch[1]=='C'))
				{
					if(end[0]<=start[1])
					{
						ch[0]='C';
						ch[1]='C';
					}
				}
			}
			int flag=0;
			for(int i=0;i<n;i++)
			{
				if(ch[i]=='x'){ flag=1;break; }
			}
			if(flag==1) System.out.println("Case #"+o+": "+"IMPOSSIBLE");
			else
			{
				int m=1;
				System.out.print("Case #"+o+": ");
				while(m<=n)
				{
					for(int i=0;i<n;i++)
					{
						if(index[i]==m)System.out.print(ch[i]);
					}
					m++;
				}
				System.out.println();
			}
		}
	}
}