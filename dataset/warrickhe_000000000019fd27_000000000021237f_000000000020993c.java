import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static int[] sumValue;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = sc.nextInt();
		for ( int i = 0 ; i < cases; i++ ) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];
			int trace = 0;
			int[] rowRep = new int[size+1];
			int[] colRep = new int[size+1];
			int rowCount = 0;
			for ( int j = 0; j < size; j++ ) {
				boolean rowCounted = false;
				for  ( int k = 0; k < size; k++ ) {
					arr[j][k] = sc.nextInt();
					if ( j == k ) 
						trace += arr[j][k];
					if ( rowRep[arr[j][k]] == 0 && !rowCounted ) {
						rowCounted = true;
						rowRep[arr[k][j]] = 1;
					}
				}
				rowCount += 1;
			}
			int colCount = 0;
			for ( int j = 0; j < size; j++ ) {
				boolean colCounted = false;
				for  ( int k = 0; k < size; k++ ) {
					if ( colRep[arr[k][j]] == 0 && !colCounted ) {
						colCounted = true;
						colRep[arr[k][j]] = 1;
					}
				}
				colCount += 1;
			}
			
			out.println("Case #" + (i+1) +": "+trace+" "+rowCount+" "+colCount);
		}
		out.close();
	}
}

