import java.util.*;
class LatinSquare{
	public static void main(String args[]){
		int[][] arr = new int[10][10];
		int max_rows,max_cols,k;
		int countC,countR,N;
		countC = 0;
		countR = 0;
		k = 0;
		// System.out.println("Enter N :");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	
		max_rows = 0;
		max_cols = 0;
		System.out.println("Enter the values into the matrix");
		for(int row = 0; row < N ; row++)
		{
			for(int col = 0;col < N; col++)
			{
				arr[row][col] = sc.nextInt();
			}
		}
		//code to get the max_row

		for(int row = 0; row < N ; row++)
		{
			for(int col = 0;col < N; col++)
			{
				for(int i = 0 ; i < N;i++)
				{
					if(arr[row][col]==arr[i][col])
					{
						countC++;
					}
				}
				if(countC>max_cols)
				{
					max_cols = countC;
				}
				countC = 0;
			}
	
		}

		for(int col = 0; col < N ; col++)
		{
			for(int row = 0;row < N; row++)
			{
				for(int i = 0 ; i < N;i++)
				{
					if(arr[row][col]==arr[row][i])
					{
						countR++;
					}
				}
				if(countR>max_rows)
				{
					max_rows = countR;
				}
				countR = 0;
				if(row == col)
				{
					k += arr[row][col];
				}
			}
	
		}
		if(max_cols == 1)
		{
			max_cols = 0;
		}
		if(max_rows == 1)
		{
			max_rows = 0;
		}

		System.out.println(k+" "+max_rows+" "+max_cols);
		

	}
}