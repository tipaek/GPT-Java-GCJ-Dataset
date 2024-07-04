import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int cases = sc.nextInt();
		int size, trace;
		int[][] matrix;
		int[] aux;
		boolean diagonalFound;
		
		for(int index = 1; index <= cases; index++)
		{
			size = sc.nextInt();
			trace = sc.nextInt();
			
			if(trace < size)
			{
				System.out.println("Case #" + index + ": IMPOSSIBLE");
			}
			else
			{
				matrix = new int[size][];
				aux = new int[size];
				diagonalFound = false;
				for(int i = 0; i < size; i++)
				{
					matrix[i] = new int[size];
					aux[i] = i + 1;
				}
				
				for(int i = 0; i < size; i++)
				{
					for(int j = 0; j < size; j++)
					{
						for(int k = 0; k < size; k++)
						{
							matrix[j][k] = aux[(i + k + j) % size];
						}
					}
					
					int currentTrace = 0;
					
					for(int j = 0; j < size; j++)
					{
						currentTrace += matrix[j][j];
					}
					
					if(currentTrace == trace)
					{
						diagonalFound = true;
						break;
					}
				}
				
				if(diagonalFound)
				{
					System.out.println("Case #" + index + ": POSSIBLE");
					
					for(int i = 0; i < size; i++)
					{
						for(int j = 0; j < size - 1; j++)
						{
							System.out.print(matrix[i][j] + " ");
						}
						System.out.println(matrix[i][size - 1]);
					}
				}
				else
				{
					System.out.println("Case #" + index + ": IMPOSSIBLE");
				}
			}
		}
	}
}
