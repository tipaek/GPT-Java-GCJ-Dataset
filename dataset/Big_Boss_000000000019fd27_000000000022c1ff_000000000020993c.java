import java.util.HashSet;
import java.util.Scanner;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		for(int i=1; i<=t; i++)
		{
			int n=in.nextInt();
			int[][] mat=new int[n][n];
			int tr=0;
			for(int j=0; j<n; j++)
			{
				for(int k=0; k<n; k++)
				{
					mat[j][k]=in.nextInt();
					if(j==k)
						tr=tr+mat[j][k];
				}
			}
			int row=0;
			int col=0;
			for(int l=0; l<n; l++)
			{
				row=row+rowhelper(mat,l);
				col=col+colhelper(mat,l);
			}
			System.out.println("Case #" + i + ": "+tr+" "+row+" "+col);
		}
	}
	
	public static int rowhelper(int[][] a, int row)
	{
		HashSet<Integer> duplicate=new HashSet<Integer>();
		for(int i=0; i<a.length; i++)
		{
			if(duplicate.contains(a[row][i]))
				return 1;
			else
				duplicate.add(a[row][i]);
		}
		return 0;
	}

	public static int colhelper(int[][] a, int col)
	{
		HashSet<Integer> duplicate=new HashSet<Integer>();
		for(int i=0; i<a.length; i++)
		{
			if(duplicate.contains(a[i][col]))
				return 1;
			else
				duplicate.add(a[i][col]);
		}
		return 0;
	}
	
}
