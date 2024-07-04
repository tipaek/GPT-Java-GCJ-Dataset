import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++)
		{
			int N = sc.nextInt();
			int rows = 0;
			int cols = 0;
			int sum = 0;
			
			int[][] matrix = new int[N][N];
			
			for(int row = 0; row < N; row++)
			{
				Set<Integer> hashSet = new HashSet<>();
				
				for(int col = 0; col < N; col++)
				{
					matrix[row][col] = sc.nextInt();
					hashSet.add(matrix[row][col]);
				}
				
				if(hashSet.size() != N)
					rows++;
			}
			
			
			for(int col = 0; col < N; col++)
			{
				Set<Integer> hashSet = new HashSet<>();
				
				for(int row = 0; row < N; row++)
				{
					hashSet.add(matrix[row][col]);
				}
				
				if(hashSet.size() != N)
					cols++;
			}
			
			for(int j = 0; j < N; j++)
				sum = sum + matrix[j][j];

			System.out.println("Case #" + (i + 1) + ": " + sum + " " + rows + " " + cols);
			
		}

	}

}