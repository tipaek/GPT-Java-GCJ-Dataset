import java.util.*;
class Vestigium {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of test cases");
		int testcases = sc.nextInt(); 
		System.out.println("number of test cases: "+testcases);
		System.out.println("Enter number of test cases");
		int n = sc.nextInt();
		Random rand = new Random(n*n);
		int trace=0;
		int row=0, col=0, rowcount=0, colcount=0;
		int mat[][]=new int[n][n];
		for (int p=1;p<=testcases;p++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					int val = rand.nextInt(n*n);
					mat[i][j]=val;
				}
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(mat[i][j]+" ");
					if (i==j)
					{
						trace=trace+mat[i][j];
					}
				}
				System.out.println();
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					int t1=mat[i][j];
					int t2=mat[j][i];
					for (int k=j+1;k<n;k++)
					{
						if (t1==mat[i][k])
							row++;
						if (t2==mat[k][i])
							col++;
					}	
				}
				if (row >= 1)
					rowcount=rowcount+1;
				if (col >= 1)
					colcount=colcount+1;
				row=0;
				col=0;
			}
			System.out.println("Case #"+p+": "+trace+" "+rowcount + " " +colcount);
			trace=0;
			rowcount=0;
			colcount=0;
	}	}
}