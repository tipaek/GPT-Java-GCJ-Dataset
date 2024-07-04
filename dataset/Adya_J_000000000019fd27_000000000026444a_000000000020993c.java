import java.util.*;
import java.lang.*;
class prob_1
{
	public static void main(String args[])
	{
	    try{
			Scanner sc=new Scanner(System.in);
			int t, x, i, j, n;
			t=Integer.parseInt(sc.nextLine().trim());
			
			for(x=1; x<=t; x++)
			{
				int trace=0;			
				n=Integer.parseInt(sc.nextLine().trim());
				int a[][]=new int[n][n];
				for(i=0; i<n; i++)
				{
					String[] temp = sc.nextLine().trim().split(" ", 0);
					for(j=0; j<n; j++)  
					{
						a[i][j] = Integer.parseInt(temp[j]);
						if(i==j)
							trace=trace+a[i][j];
					}

				}
				System.out.print("\nCase #"+t+" : "+trace);
				countRows(a, n);
				countCols(a, n);

			}
	    }
	    catch(Exception e) {
	        System.exit(0);
	    }
	}
	public static void countRows(int [][] array, int n) throws Exception
	{
		int i, j, k, count=0;
		for(i=0; i<n; i++)
		{
			outer:
			for(j=0; j<n; j++)
			{
				for(k=j+1; k<n; k++)
				{
					if(array[i][j]==array[i][k])
					{
						count++;
						break outer;
					}
				}
			}
		}
		System.out.print(" " +count);
	}

	public static void countCols(int [][] array, int n) throws Exception
	{
		int i, j, k, count=0;
		for(i=0; i<n; i++)
		{
			outer:
			for(j=0; j<n; j++)
			{
				for(k=j+1; k<n; k++)
				{
					if(array[j][i]==array[k][i])
					{
						count++;
						break outer;
					}
				}
			}
		}
		System.out.print(" "+count);
	}
}

