import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=sc.nextInt();
		for(int o=1;o<=t;o++)
		{
			String s=sc.next();
			Integer n=Integer.parseInt(s);
			int ar[]=new int[s.length()];
			int k=s.length()-1;
			int l=s.length();
			StringBuffer s1=new StringBuffer("");
			while(n>0)
			{
				ar[k]=n%10;
				n=n/10;
				k--;
			}
			//System.out.print("Case #"+o+": ");
			for(int i=1;i<=ar[0];i++)
			{
				s1.append("(");
			}
			for(int i=0;i<l-1;i++)
			{
				s1.append(ar[i]);
				int diff=ar[i]-ar[i+1];
				if(diff>0)
				{
					for(int j=1;j<=diff;j++)
						s1.append(")");
				}
				else if(diff<0)
				{
					for(int j=1;j<=Math.abs(diff);j++)
						s1.append("(");
				}
			}
			s1.append(ar[l-1]);
			for(int i=1;i<=ar[l-1];i++)
			{
				s1.append(")");
			}
			System.out.print("Case #"+o+": "+s1);
		}
	}
}