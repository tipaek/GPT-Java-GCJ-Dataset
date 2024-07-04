import java.util.*;

class Solution
{
	ArrayList<Integer> list=new ArrayList<Integer>();
	
	public void check(int m[][],int t)
	{ 
		int r=0,c=0,sum=0,temp=0,i=0;
		
		for(i=0;i<m.length;i++)
		{
			for(int j=0;j<m.length;j++)
			{
				if(i==j)
				{
					sum+=m[i][j];
				}
			}
		}
		list.add(sum);
		
		
	}
}

public class Vestigium
{
	public static void main(String args[])
	{
		int t,n,i,j;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt(); //test case 
		Solution s=new Solution();

		while(t>0)
		{
			n=sc.nextInt();//size of array
			int m[][]=new int[n][n];

			for (i=0;i<n;i++)
			{
				for (j=0;j<n ;j++ )
				{
					m[i][j]=sc.nextInt();
				}
			}
			s.check(m,t);
			t--;
		}
	}
}