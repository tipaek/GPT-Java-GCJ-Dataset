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
						if (matrix[j][k]==matrix[j-1][k])
						{
							if (repeatedRows[j]==0)
							{
								repeatedRows[j]=1;
								sameRow++;
							}
						}
					}
					if (k>0)
					{
						//checking colums
						if (matrix[j][k]==matrix[j][k-1])
						{
							if (repeatedColumn[k]==0)
							{
								repeatedColumn[k]=1;
								sameColumn++;
							}
						}
					}

				} 

			}

			if (sameColumn>0)
			{
				sameColumn++;
			}
			if (sameRow>0)
			{
				sameRow++;
			}
			System.out.println("Case #" + i + ": " + diagonalSum + " " +sameColumn + " " +sameRow );
		}
	}
}