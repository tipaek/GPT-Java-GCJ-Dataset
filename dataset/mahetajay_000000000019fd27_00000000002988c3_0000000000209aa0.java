import java.util.Scanner;
public class Solution
{
	static int[][] matrix=new int[60][60];
	static int n,k,test;
	static boolean[][] rows=new boolean[60][60]; 
	static boolean[][] cols=new boolean[60][60]; 
	static boolean result;
	
	public static void func(int row, int col, int m)
	{
		if(row==n && col==n+1 && m==k && !result)
		{
			result=true;
			System.out.println("Case #"+test+": POSSIBLE");
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=n;j++)
				{
					System.out.print(matrix[i][j]+" ");
				}
				System.out.println();
			}
			return;
		}
		else if(row>n)
		{
			return;
		}
		else if(col>n)
		{
			func(row+1,1,m);
		}
		for (int i = 1; i <= n && !result; ++i) 
		{
			if (!rows[row][i] && !cols[col][i]) 
			{
				rows[row][i] = cols[col][i] = true;
				if (row == col) 
				{
					m = m + i;
				}
				matrix[row][col] = i;

				func(row, col + 1, m);

				rows[row][i] = cols[col][i] = false;
				if (row == col) 
				{
					m = m - i;
				}
				matrix[row][col] = 0;
			}
		}
	}
	
	public static void main(String args[])
	{ 
		Scanner sc=new Scanner(System.in);
		int temp;
		temp=sc.nextInt();
		for(test=1;test<=temp;test++)
		{
			n=sc.nextInt();
			k=sc.nextInt();
			func(1,1,0);
			if(!result)
			{
				System.out.println("Case #"+test+": IMPOSSIBLE");
			}
			result=false;
		}
	}
}