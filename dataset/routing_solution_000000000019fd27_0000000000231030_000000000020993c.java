import java.util.*;
import java.io.*;


class Solution {

	public static void main(String[] args) {
		
		int testCase , rowNumber, testCounter = 1;
		
		Scanner inputScanner = new Scanner(System.in);
		
		testCase = inputScanner.nextInt();
		
		while(testCounter <= testCase) {
			
			int traceNumer = 0, repeatRow = 0, repeatCol = 0;
			
			rowNumber = inputScanner.nextInt();
			int inputArray[][] = new int[rowNumber][rowNumber];
			int rowCounter [] = new int[rowNumber + 1];
			int colCounter [] = new int[rowNumber + 1];
			
			int i,j,p;
			
			for (i = 0; i < rowNumber; i++) {
				
				Arrays.fill(rowCounter, 0);
				for (j = 0; j < rowNumber; j++) {
					inputArray[i][j] = inputScanner.nextInt();
					rowCounter[inputArray[i][j]]++;
					if(i==j) {
						traceNumer += inputArray[i][j];
					}
				}
				
				for ( p = 0; p <= rowNumber; p++) {
					if(rowCounter[p] > 1) {
						repeatRow++;
						break;
					}
				}
			}

			for ( i = 0; i < rowNumber; i++) {
				Arrays.fill(colCounter, 0);
				for ( j = 0; j < rowNumber; j++) {
					colCounter[inputArray[j][i]]++;
				}
				
				for ( p = 0; p <= rowNumber; p++) {
					if(colCounter[p] > 1) {
						repeatCol++;
						break;
					}
				}
				
			}
			
			System.out.println("Case #"+testCounter+": "+traceNumer+" "+repeatRow+" "+repeatCol);
			
			testCounter++;
			
		}
	}

}
