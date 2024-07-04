import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int numberOfMatrices = scnr.nextInt();

		for (int i = 0; i < numberOfMatrices; i++) {
			AnalyzeMatrix(scnr, i + 1);
		}

	}

	private static void AnalyzeMatrix(Scanner colScnr, int currMatrix) {
		int matrixSize = colScnr.nextInt();
		colScnr.nextLine();
		int[][] matrix = new int[matrixSize][matrixSize];
		int traceSize = 0;
		int columnRepeat = 0;
		int rowRepeat = 0;
		boolean repFound;
		for (int i = 0; i < matrixSize; i++) {// this gets the column and row of matrix
			for (int j = 0; j < matrixSize; j++) {
				matrix[i][j] = colScnr.nextInt();
			}
			if(i!= matrixSize-1) {
				colScnr.nextLine();	
			}

		}
		for (int i = 0; i < matrixSize; i++) {//add tracesize
				traceSize+=matrix[i][i];	
		}
		//look for column 
		for(int i=0;i<matrixSize;i++) {// y
		 boolean foundCol = false;
		 boolean foundRow = false;
			for(int j=0;j<matrixSize;j++) {//x
				int valueToFind = matrix[i][j];
				if(!foundCol) {
					
				for(int k=0; k<matrixSize;k++) {
					if(k == j) {
						continue;
					}
					if(valueToFind == matrix[i][k]) {
						foundCol= true;
						columnRepeat++;
						break;
					}
				}
				}
				if(!foundRow) {
				for(int k=0; k<matrixSize;k++) {
					if(k == j) {
						continue;
					}
					if(valueToFind == matrix[k][i]) {
						foundRow = true;
						rowRepeat++;
						break;
					}
				}
				}
			}
		}

		System.out.println("Case #" + currMatrix + ": " + traceSize + " " + columnRepeat + " " + rowRepeat);
	}
}
