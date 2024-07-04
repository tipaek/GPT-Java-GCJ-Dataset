import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int cou = 0;
		while(t-- > 0)
		{
			int trace=0;
			int row=0;
			int col=0;
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			for(int i=0;i<n;i++)
			{	
				for(int j=0;j<n;j++)
				{
					a[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if (i == j)
						trace += a[i][j];
				}
			}
			for(int i=0;i<n;i++)
			{
				int temp=0;
				HashMap<Integer,Integer> hs = new HashMap<>();
				for(int j=0;j<n;j++)
				{
					hs.put(a[i][j],1);
					if(hs.size() == n)
						temp=1;
				}
				if(temp != 1)
					row++;
			}
			for(int i=0;i<n;i++)
			{
				int temp=0;
				HashMap<Integer,Integer> hs = new HashMap<>();
				for(int j=0;j<n;j++)
				{
					hs.put(a[j][i],1);
					if(hs.size() == n)
						temp=1;
				}
				if(temp != 1)
					col++;
			}
			System.out.println("Case #" + (cou+1) + ": " + trace + " " + row + " " + col);
			cou++;
		}
	}
}