import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		int n, i, j;
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int noOfTestCase = in.nextInt();
			for(int z=0; z<noOfTestCase; z++)
			{
				n = in.nextInt();
				// Declare the matrix
				int first[][] = new int[n][n];

				// Read the matrix values
				for (i = 0; i < n; i++)
					for (j = 0; j < n; j++)
						first[i][j] = in.nextInt();

				
				
				int k=0;
				int r = 0;
				int c = 0;
				for (i = 0; i < n; i++) {
					Set<Integer> rowSet = new HashSet<>();
					for (j = 0; j < n; j++)
					{
						rowSet.add(first[i][j]);
						if(i==j)
						{
							k += first[i][j];
						}
					}
					if(rowSet.size()<n)
						r += 1;
					
				}
				
				for (i = 0; i < n; i++) {
					Set<Integer> colSet = new HashSet<>();
					for (j = 0; j < n; j++)
					{
						colSet.add(first[j][i]);
					}
					if(colSet.size()<n)
						c += 1;
					
				}
				int testCaseNo = z+1;
				System.out.println("Case #"+testCaseNo+ ":"+" "+k+ " "+r+ " "+c);
			}
			
			
		} catch (Exception e) {
		} finally {
			in.close();
		}
	}

}
