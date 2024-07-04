import java.io.*;
import java.util.*;

public class Vestigium {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//Num Test Cases
		int t = Integer.parseInt(in.nextLine()); 
		for (int x = 1; x <= t; ++x) 
		{
			int diagonalIndex = 0;
			int totalDiagonal = 0;
			int rowDupeCount = 0;
			int colDupeCount = 0;
			Set<Integer> checkRow = new HashSet<Integer>();	
			Set<Integer> checkCol = new HashSet<Integer>();
			
			//Matrix Size
			int n = Integer.parseInt(in.nextLine());
			int[][] row = new int[n][n];
			
			//Iterating for Current Row
			for(int m = 0; m < n; m++) 
			{
				//Clear Set
				checkRow.clear();
				
				//Input Row
				String[] strNumbers = in.nextLine().split(" "); //list of numbers per row
				for(int j = 0; j < n; j++) {
					row[m][j] = Integer.parseInt(strNumbers[j]);
				}
				
				//Iterates through Row
				for(int i = 0; i < n; i++) {  
					
					//Row Dupes										
					if(checkRow.contains(row[m][i])) {
						rowDupeCount++;
						break;
					}
					
					else
						checkRow.add(row[m][i]);

				}
				
				//Diagonal
				totalDiagonal += row[diagonalIndex][diagonalIndex];		
				diagonalIndex++;

			}
			
			//Column Dupes Check
			for(int i = 0; i < n; i++) {
				checkCol.clear();
				for(int j = 0; j < n; j++) {
					if(checkCol.contains(row[j][i])) {			
						colDupeCount++;
						break;
					}
					
					else {
						checkCol.add(row[j][i]);
					}
				
				}
			}
			
			//Output 
			int k = totalDiagonal;
			int r = rowDupeCount;
			int c = colDupeCount;

			System.out.println("Case #" +x+ ": " +k+ " " +r+ " " +c);

		}		    
		in.close();
	}

}

