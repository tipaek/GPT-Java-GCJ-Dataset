import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			while(scanner.hasNext())
			{
				int T = scanner.nextInt();
				for(int i=0; i< T; i++)
				{
					int N = scanner.nextInt();
					int[][] matrix = new int[N][N];
					int traceSum = 0;
					int dupRow = 0;
					Set<Integer> set = new HashSet<>();
					for(int j=0;j<N;j++)
					{
						set.clear();
						boolean dupFound = false;
						for(int k=0;k<N;k++)
						{
							matrix[j][k] = scanner.nextInt();
							if(!dupFound && set.contains(matrix[j][k]))
							{
								dupFound=true;
								dupRow++;
							}
							set.add(matrix[j][k]);
							if(j==k)
								traceSum+=matrix[j][k];
						}
					}
					
					int dupCol = 0;
					for(int j=0;j<N;j++)
					{
						set.clear();
						boolean dupFound = false;
						for(int k=0;k<N;k++)
						{
							if(!dupFound && set.contains(matrix[k][j]))
							{
								dupFound=true;
								dupCol++;
							}
							set.add(matrix[k][j]);
						}
					}
					
				 System.out.println(String.format("Case #%d: %d %d %d", (i+1), traceSum, dupRow , dupCol));
				}
			}
			
		}
		
	}

}
