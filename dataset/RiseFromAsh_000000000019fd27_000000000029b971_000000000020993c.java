import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[])
    {
	Scanner sc = new Scanner(System.in);

	//number of test cases
	int t = sc.nextInt();

	int k = 0, r = 0, c = 0, n = 0;

	//contains output
	int ans[][] = new int[t][3];

	//going through number of cases t; x = case number
	for(int x = 1; x <= t; x++)
	    {
		//size of matrix (n x n)
 	        n = sc.nextInt();

		//creating the matrix
		int matrix[][] = new int[n][n];

		//filling the matrix with values
		//rows
		for(int row = 0; row < n; row++)
		    {
			//cols
			for(int col = 0; col < n; col++)
			    {
				matrix[row][col] = sc.nextInt();
			    }
		    }


		//trace
		k = trace(matrix, n);

		//rows with repeated elements
		r = repeatRows(matrix, n);

		//columns with repeated elements
		c = repeatCols(matrix, n);

		for(int p = x - 1; p < x; p++)
		    {
			ans[p][0] = k;
			ans[p][1] = r;
			ans[p][2] = c;
		    }
	    }

	//printing answers
	int v = 1;
	for(int s = 0; s < n; s++)
	    {
		System.out.println("Case #" + v + ": " + ans[s][0] + " " +
				   ans[s][1] + " " + ans[s][2]);
		v++;
	    }
    }

    //calculates trace of matrix
    public static int trace(int m[][], int size)
    {
	int sum = 0;

	for(int i = 0; i < size; i++)
	    {
		for(int j = 0; j < size; j++)
		    {
			if(i == j)
			    {
				sum = sum + m[i][j];
			    }
		    }
	    }
	return sum;
    }

    //calculates number of rows with repeated elements
    public static int repeatRows(int m[][], int size)
    {
	int num = 0;
	int compareValue = 0;

	for(int i = 0; i < size; i++)
	    {
		for(int j = 0; j < size; j++)
		    {
			compareValue = m[i][j];
			
			for(int k = j + 1; k < size; k++)
			    {
				if(compareValue == m[i][k])
				    {
					j = size;
					k = size;
					num++;
				    }
			    }
		    }
		
	    }

	return num;
    }

    //calculates number of columns with repeated elements
    public static int repeatCols(int m[][], int size)
    {
	int num = 0;
	int compareValue = 0;
	
	for(int j = 0; j < size; j++)
	    {
		for(int i = 0; i < size; i++)
		    {
			compareValue = m[i][j];
			
			for(int k = i + 1; k < size; k++)
			    {
				if(compareValue == m[k][j])
				    {
					i = size;
					k = size;
					num++;
				    }
			    }
		    }
		
	    }
	
	return num;

    }
}
