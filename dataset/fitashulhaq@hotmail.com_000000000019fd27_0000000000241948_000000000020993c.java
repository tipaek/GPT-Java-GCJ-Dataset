
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {

			int sizeOfMatrix=in.nextInt();

			int matrix[][]=new int[sizeOfMatrix][];
			int diagonalSum=0;
			int sameRow=0;
			int sameColumn=0;

			int repeatedRows[]=new int[sizeOfMatrix];
			int repeatedColumn[]=new int[sizeOfMatrix];


			for (int j = 0; j < sizeOfMatrix; j++) {

				String row = in.nextLine(); 
				if (row.isEmpty())
				{
					j--;
					continue;
				}
				matrix[j]=new int[sizeOfMatrix];

				String[] rowparts = row.split(" ");
				for (int k=0;k<rowparts.length;k++)
				{
					int value = Integer.parseInt((rowparts[k]));
					matrix[j][k]=value;
					if (k==j)
					{
						diagonalSum+=value;
					}
					if (j>0)
					{
						//checking rows
						int totalRows=j+1;

						while(totalRows>0)
						{
							if (j!=totalRows-1)
							{
								if (matrix[j][k]==matrix[totalRows-1][k])
								{
									if (repeatedRows[k]==0)
									{
										repeatedRows[k]=1;
										sameRow++;
									}
								}
							}
							totalRows-=1;

						}
					}
					if (k>0)
					{
						int totalColums=k+1;
						//checking colums
						while(totalColums>0)
						{
							if (k!=totalColums-1)
							{
								if (matrix[j][k]==matrix[j][totalColums-1])
								{
									if (repeatedColumn[j]==0)
									{
										repeatedColumn[j]=1;
										sameColumn++;
									}
								}
							}
							totalColums-=1;
						}
					}

				} 

			}


			System.out.println("Case #" + i + ": " + diagonalSum + " " +sameColumn + " " + sameRow);
		}
	}
}