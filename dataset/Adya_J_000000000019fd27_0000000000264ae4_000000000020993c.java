import java.util.*;
import java.lang.*;
class prob_1
{
	public static void main(String args[])
	{
	    try{
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

