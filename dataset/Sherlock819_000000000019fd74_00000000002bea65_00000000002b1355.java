import java.util.*;
import java.io.*;

class Solution
{
	public static int check(int a[][])
	{
		
			int r=a.length;
			int c=a[0].length;
			int ar[][]=new int[r][c];
			int s=0;
			int f=0;
			for(int i=0;i<r;i++)
			{
				for(int j=0;j<c;j++)
				{
					ar[i][j]=a[i][j];
				if(a[i][j]!=-1)
				{
					int x=i;
					int y=j;
					s+=a[i][j];
					int n=0,t=0;
					while(i-1>=0)
					{
						if(i-1>=0 && a[i-1][j]!=-1)
						{
							t+=a[i-1][j];
							n++;
							break;
						}
						i--;
					}
					i=x;
					
					while(j-1>=0)
					{
						if(j-1>=0 && a[i][j-1]!=-1)
						{
							t+=a[i][j-1];
							n++;
							break;
						}
						j--;
					}
					j=y;
					
					while(i+1<r)
					{
						if(i+1<r && a[i+1][j]!=-1)
						{
							t+=a[i+1][j];
							n++;
							break;
						}
						i++;
					}
					i=x;
					
					while(j+1<c)
					{
						if(j+1<c && a[i][j+1]!=-1)
						{
							t+=a[i][j+1];
							n++;
							break;
						}
						j++;
					}
					j=y;
					double avg=0;
					//System.out.println("i="+i+" j="+j+" n="+n+" t="+t);
					if(n>0)
					{
						avg=(double)t/(double)n;
						double z=a[i][j];
						if(z<avg)
						{
							ar[i][j]=-1;
							f=1;
						}
					}
				}
				
				}
			}
			//System.out.println("s="+s+" f="+f);
			if(f==1)
				return s+check(ar);
			return s;
	}
	
	public static void main(String args[])
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int T=Integer.parseInt(br.readLine());
			for(int t=0;t<T;t++)
			{
				String st[]=br.readLine().split(" ");
				
				int r=Integer.parseInt(st[0]);
				int c=Integer.parseInt(st[1]);
				int a[][]=new int[r][c];
				String s[][]=new String[r][];
				for(int i=0;i<r;i++)
				{
					s[i]=br.readLine().split(" ");
				}
				for(int i=0;i<r;i++)
				{
					for(int j=0;j<c;j++)
					{
						a[i][j]=Integer.parseInt(s[i][j]);
					}
				}
				
				
				System.out.println("Case #"+(t+1)+": "+check(a));
			}
		}
		catch(Exception e)
		{
				System.out.println(e);
		}
	}
}