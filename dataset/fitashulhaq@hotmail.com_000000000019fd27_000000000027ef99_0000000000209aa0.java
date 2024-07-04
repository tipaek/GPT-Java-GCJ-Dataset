

import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {

			String line = in.nextLine(); 

			if (line.isEmpty())
			{
				i--;
				continue;
			}
			boolean possible = true;


			String[] lineParts = line.split(" ");

			int n = Integer.parseInt(lineParts[0]);
			int k = Integer.parseInt(lineParts[1]);

			int matrix[][]=new int[n][n];


			if (n * n < k)
			{
				System.out.print("Case #" + i + ": IMPOSSIBLE" );
				continue;
			}
			int attempts = 0;
			int valuesAtline[]=new int [n];
			
			
			int input = n;
			
			if (k%n==0)
			{
				input=k/n;
			}
			for (int index=0;index<n;index++)
			{
				valuesAtline[index]=input;
			}
			int workingOn = n-1;
			
			
			
			
			int sum=calculateSum(valuesAtline);
			possible = true;

			while (sum !=k)
			{


				if(valuesAtline[workingOn]==1)
				{
					workingOn=workingOn-1;
				}

				if(workingOn==1 && valuesAtline[workingOn]==1)
				{
					possible=false;
					break;
				}

				valuesAtline[workingOn]=valuesAtline[workingOn]-1;
				sum=calculateSum(valuesAtline);	
			}
			if (!possible)
			{
				System.out.print("Case #" + i + ": IMPOSSIBLE" );
				continue;
			}

			int indexcount = 0;

			for (int index=0;index<n;index++)
			{
				for (int j=0;j<n;j++)
				{
					if (j==index)
					{
						matrix[index][j]=valuesAtline[indexcount];
						indexcount++;
					}
				}
			}
			int count = 1;
			for (int index=0;index<n;index++)
			{
				for (int j=0;j<n;j++)
				{
					if (index==j)
						continue;


					Random r = new Random();
					int value =1;
					if( index==0 && j>0)
					{
						while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
						{
							value ++;

							if (value>n)
							{
								attempts=200;
								break;
							}

						}
						matrix[index][j]=value;

						continue;
					}

					if (index<n-1  && j==0)
					{
						if (j>index)
						{
							value=1;
							while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
							{
								value ++;

								if (value>n)
								{
									attempts=200;
									break;
								}

							}
						}
						
						value=n;
						while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
						{
							value --;

							if (value==0)
							{
								attempts=200;
								break;
							}
						}
					}
					else if (index==n-1  && j==0)
					{
						if (j>index)
						{
							value=1;
							while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
							{
								value ++;

								if (value>n)
								{
									attempts=200;
									break;
								}

							}
						}
						value=n;
						while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
						{
							value --;

							if (value==0)
							{
								attempts=200;
								break;
							}
						}
					}


					else if (index==n-1  && j>0)
					{
						if (j>index)
						{
							value=1;
							while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
							{
								value ++;

								if (value>n)
								{
									attempts=200;
									break;
								}
							}
						}
						value=n;
						while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
						{
							value --;

							if (value==0)
							{
								attempts=200;
								break;
							}
						}
					}
					else if (index==0  && j==n-1)
					{
						if (j>index)
						{
							value=1;
							while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
							{
								value ++;

								if (value>n)
								{
									attempts=200;
									break;
								}

							}
						}
						value=n;
						while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
						{
							value --;

							if (value==0)
							{
								attempts=200;
								break;
							}
						}
					}
					else if (index<n-1  && j==n-1)
					{
						if (j>index)
						{
							value=1;
							while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
							{
								value ++;

								if (value>n)
								{
									attempts=200;
									break;
								}
							}
						}
						value=n;
						while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
						{
							value --;

							if (value==0)
							{
								attempts=200;
								break;
							}
						}
					}
					else
					{
						if (j>index)
						{
							value=1;
							while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
							{
								value ++;

								if (value>n)
								{
									attempts=200;
									break;
								}
							}
						}
						value=n;
						while (checkRows(value,matrix,index,j,n) || checkColums(value,matrix,index,j,n))
						{
							value --;

							if (value==0)
							{
								attempts=200;
								break;
							}
						}
					}
					matrix[index][j]=value;


				}
				if(attempts>n)
				{
					System.out.print("Case #" + i + ": IMPOSSIBLE" );
					break;
				}
			}

			if(attempts<=n)
			{
				System.out.print("Case #" + i + ": " );

				for (int ind=0;ind<n;ind++)
				{
					for (int indx=0;indx<n;indx++)
					{
						System.out.print(matrix[ind][indx]);
						if (indx!=n-1)
							System.out.print(" ");
					}
					System.out.println();

				}
			}
			else continue;


		}
	}

	private static boolean checkColums(int value, int[][] matrix, int i, int j, int n) {
		boolean badNews=false;
		for (int row=0;row<n;row++)
		{
			if (row==j)
				continue;
			if(value == matrix[i][row])
			{
				badNews=true;
			}
		}

		return badNews;
	}

	private static boolean checkRows(int value, int[][] matrix, int i, int j, int n) {
		// TODO Auto-generated method stub
		boolean badNews=false;
		for (int row=0;row<n;row++)
		{
			if (row==i)
				continue;
			if(value == matrix[row][j])
			{
				badNews=true;
			}
		}

		return badNews;
	}

	private static int calculateSum(int[] valuesAtline) {
		int sum=0;
		for(int i=0;i<valuesAtline.length;i++)
		{
			sum+=valuesAtline[i];
		}

		return sum;
	}
}
