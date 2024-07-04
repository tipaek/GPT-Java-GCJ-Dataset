/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 HashSet<Integer> set = new HashSet<Integer>();
		 Scanner scanner = new Scanner(System.in);
		 int t = scanner.nextInt();
		 
		 for(int p = 1; p <= t; p++) {
		 	int n = scanner.nextInt();
		 	int trace = 0;
		 	int matrix[][] = new int[n][n];
		 	for(int i = 0; i < n; i++) {
		 		for(int j = 0; j < n; j++) {
		 			matrix[i][j] = scanner.nextInt();
		 			if( i == j) {
		 				trace += matrix[i][j];
		 			}
		 		}
		 	}
		 	
		 	// Row traversal
		 	int dupRow = 0;
		 	for(int i = 0; i < n; i++) {
		 		for(int j = 0; j < n; j++) {
		 			if(!set.add(matrix[i][j])) {
		 				dupRow++;
		 				break;
		 			}
		 		}
		 		set.clear();
		 	}
		 	
		 	// Column traversal
		 	int dupCol = 0;
		 	for(int j = 0; j < n; j++) {
		 		for(int i = 0; i < n; i++) {
		 			if(!set.add(matrix[i][j])) {
		 				dupCol++;
		 				break;
		 			}
		 		}
		 		set.clear();
		 	}
		 	
		 	System.out.println("Case #" + p + ": " + trace + " " + dupRow + " " + dupCol);
		 }
	}
}