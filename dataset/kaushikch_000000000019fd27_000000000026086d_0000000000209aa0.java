import java.util.*;
class Solution
{
static int k=0,n=0;
    public static boolean issafe(int a[][],int i,int j,int num)
	{
		for(int i1=0;i1<a.length;i1++)
		{
			if(a[i][i1]==num)
			{
				return false;
			}
			if(a[i1][j]==num)
			{
				return false;
			}
		}
		return true;
	}
     public static boolean method(int a[][],int i,int j)
      {
	  if(i>=a.length)
	  {
	  	return true;
	  }
	  if(j>=a.length)
	  {
		if(method(a,i+1,0))
		{
			return true;
		}
		return false;
	  }
	      for(int i1=1;i1<=a.length;i1++)
		  {
		  	 if(issafe(a,i,j,i1))
			 {
			 	a[i][j]=i1;
				if(method(a,i,j+1))
				{
				       int tr=0;
						for(int j1=0,k1=0;j1<n&&k1<n;j1++,k1++)
						{
							tr=tr+a[j1][k1];
						}
						if(tr==k)
						{
							return true;
						}
				}
				a[i][j]=0;
			 }
		  }
		  return false;
       }
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int c=0;
		while(t-->0)
		{
		c++;
			 n=sc.nextInt();
			 k=sc.nextInt();
			    int a[][]=new int[n][n];
				int flag=0;
					if(method(a,0,0))
					{
					   System.out.println("Case #"+c+": "+"POSSIBLE");
				 for(int j1=0;j1<a.length;j1++)
				        {
					for(int k1=0;k1<a.length;k1++)
					{
						System.out.print(a[j1][k1]+" ");
					}
					System.out.println();
				      }
					}
					else
					{
						System.out.println("Case #"+c+": "+"IMPOSSIBLE");
					}
		}
	}
}