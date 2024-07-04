import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {

		// Input
		Scanner input = new Scanner(System.in);

		// Number of test cases
		int t = input.nextInt();

		for (int i = 1; i <= t; ++i) {
			// Size of the matrix
			int n = input.nextInt();

		// Matriz nxn
		int[][] matrix = new int[n][n];
		
		//Variables
		int trace = 0;
		int repetedRows = 0;
		int repetedColumns = 0;
		
		//Fill Matrix
        for(int j = 0; j < matrix.length; ++j)
        {
            int comparar = 0;
            boolean repetido = false;
            
            //Read all rows
            for(int k = 0; k < matrix.length && input.hasNext(); ++k)
            {
                //Read row
                int l = input.nextInt();
                matrix[j][k] = l;
                
               // System.out.println(matrix[j][k]);
                
                //Sum diagonal
                if(j == k)
                {
                    trace += l;
                }
                //repeated row
                if(comparar != l)
				{
					comparar = l; 
				}
				else if (comparar == l && repetido == false)
				{
				    repetido = true;
				    repetedRows += 1;
				}
            }
            
        }
        
        			// repeated column 
			for (int j = 0; j < matrix.length; ++j) {
				boolean repetido = false;
				
				for (int k = 0; k < matrix.length; ++k) {
					
					for (int p = 1; p < matrix.length; ++p) {
						
						if(matrix[j][k] == matrix[p][k] && repetido == false )
						{
							repetido = true;
							repetedColumns +=1;
						}
					}
				}
			}
        
			// sum of main diagonal
			int k = trace;
			// number of rows repeated elements
			int r = repetedRows;
			// number of columns repeated elements
			int c = repetedColumns;

			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);

		}

	}
}