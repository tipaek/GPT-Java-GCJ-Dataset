import java.util.*;
import java.io.*;
class Solution
{
	static final long mod=(long)1e18;
	public static void main(String [] args)
	{
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int t=1;t<=T;t++)
		{
			int N=s.nextInt();
			s.nextLine();
			String A[]=new String[N];
			int l=0,m=Integer.MIN_VALUE;
			String S="";
			for(int i=0;i<N;i++)
			{
				A[i]=s.nextLine();
				String S1="";
				for(int j=0;j<A[i].length();j++)
				{
					if(A[i].charAt(j)!='*')
					{
						S1=S1+A[i].charAt(j);
					}
				}
				A[i]=S1;
				l=A[i].length();
				if(m<l)
				{
					m=l;
					S=A[i];
				}
			}
			//System.out.println(S);
			int c=0;
			for(int i=0;i<N;i++)
			{
				//System.out.println(S.indexOf(A[i])+" "+S+" "+A[i]);
				if(S.indexOf(A[i])!=-1)
				{
					c++;
				}
			}
			//System.out.println(c);
			System.out.print("Case #"+t+": ");
			if(c==N)
			{
				System.out.println(S);
			}else
			{
				System.out.println("*");
				
			}
			
		}
		
	}
}

