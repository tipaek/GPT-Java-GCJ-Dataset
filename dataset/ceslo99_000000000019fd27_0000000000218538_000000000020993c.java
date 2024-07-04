import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); 
		for (int i = 0; i < t; ++i) {
			int matrixSize = in.nextInt(); // size of matrix
			int numbers[][] = new int[matrixSize][matrixSize];
			for(int row = 0; row < matrixSize; row++) {
				for(int col = 0; col < matrixSize; col++) {
					int num = in.nextInt();
					numbers[row][col] = num;
				}
				
			}
			latinSquare(numbers, matrixSize, i);
		    
		}

	}
	
	public static void latinSquare(int [][] numbers, int matrixSize, int caseNum ) {
		HashSet<Integer> rowDup = new HashSet<>();
		int rowDuplicate = 0;
		HashSet<Integer> colDup = new HashSet<>();
		int colDuplicate = 0;
		boolean lockRow = false;
		boolean lockCol = false;
		int diagnolSum = 0;
		
		//check row
		for(int row = 0; row < matrixSize; row++) {
			for(int col = 0; col < matrixSize; col++) {
				if(col == row) {
					diagnolSum += numbers[row][col];
				}
				if( !rowDup.contains(numbers[row][col] ) ) {
					rowDup.add(numbers[row][col]);
				}
				else if(!lockRow) {
					rowDuplicate++;
					lockRow = true;
					
				}
				if( !colDup.contains(numbers[col][row] ) ) {
					colDup.add(numbers[col][row]);
				}
				else if(!lockCol) {
					colDuplicate++;
					lockCol = true;
					
				}
				
			}
			lockRow = false;
			lockCol = false;
			rowDup.clear();
			colDup.clear();
			
		}
		

		
		
		System.out.println("\nCase #" + (caseNum+1) + ": " + diagnolSum + " " + rowDuplicate + " " + colDuplicate);
		

	}

}
