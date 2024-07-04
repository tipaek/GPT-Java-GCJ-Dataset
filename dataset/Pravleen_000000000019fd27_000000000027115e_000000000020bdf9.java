import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		int a;
		for(int i=0;i<t;i++)
		{
			
			a=sc.nextInt();
			int ar[][]=new int[2][a];
			for(int j=0;j<a;j++)
			{
				for(int k=0;k<2;k++)
					ar[k][j]=sc.nextInt();
				
			}
			String m=activity(ar,a);
				System.out.println("Case #"+(i+1)+": "+m);
		}
		
	}
	static String activity(int ar[][],int a)
	{
		boolean b=timecheck(ar,a);
		if(b==false)
			return "IMPOSSIBLE";
		
		int c=0,j=0;
		String s="";
		int start=ar[0][0],end=ar[0][a-1];
		
		for(int i=1;i<a;i++)
		{	
			for(int k=0;k<=1;k++)
			{
				if(c==0)
				{
					s=s+"C";
					c=1;
				}
				else if(j==0 && c==1)
				{
					s=s+"J";
					j=1;
					
				}
				else if(end < ar[i][k])
				{
					s=s+"C";
				}
				
				
				
					
		}
		
		
		
		}
		return s;
	}
	static boolean timecheck(int ar[][],int a)
	{
		int start=ar[0][0],end=ar[0][1];
		int c=1;
		for(int i=1;i<a;i++)
		{
			for(int j=0;j<=1;j++)
			{
				if(ar[i][j]<start)
				{
					c=0;
					start=ar[i][j];
				}
				else
				{
					c=1;
					start=ar[i][j];
				}
			
			}
		}
		if(c==0)
			return false;
		else 
			return true;
	}
}