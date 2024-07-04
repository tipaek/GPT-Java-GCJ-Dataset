import java.util.Scanner;
public class Solution
{
	static int[][] sqsss = new int[60][60];
	static int n, k, t;
	static boolean[][]  rowsss = new boolean[60][60];
	static boolean[][]  colsss = new boolean[60][60]; 
	static boolean solved;
	 
	public static void solver(int row, int col, int m) 
	{
	    if (row == n && col == n + 1 && m == k && !solved) 
	    {
		solved = true;
		System.out.println("Case #"+t+": "+"POSSIBLE");
		for (int i = 1; i <= n; ++i) 
		{
		    for (int j = 1; j <= n; ++j) 
		    {
		        System.out.print(sqsss[i][j]+" ");
		    }
		    System.out.println();
		}
		return;
	    } 
	    else if (row > n)
	    {
		return;
	    } 
	    else if (col > n) 
	    {
		solver(row + 1, 1, m);
	    }
	    for (int i = 1; i <= n && !solved; ++i) 
	    {
		if (!rowsss[row][i] && !colsss[col][i]) 
		{
		    rowsss[row][i] = colsss[col][i] = true;
		    if (row == col) {
		        m += i;
		    }
		    sqsss[row][col] = i;
	 
		    solver(row, col + 1, m);
	 
		    rowsss[row][i] = colsss[col][i] = false;
		    if (row == col) {
		        m -= i;
		    }
		    sqsss[row][col] = 0;
		}
	    }
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(t=1;t<=T;t++)
		{
			n = sc.nextInt();
			k = sc.nextInt();
			solver(1,1,0);
			if(!solved)
			{
				System.out.println("Case #"+t+": "+"IMPOSSIBLE");
			}
			solved = false;
		}
	}
	
}
