import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = sc.nextInt();
		for ( int i = 0 ; i < cases; i++ ) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];
			int trace = 0;
			int rowCount = 0;
			for ( int j = 0; j < size; j++ ) {
				int[] rowRep = new int[size+1];
				boolean rowCounted = false;
				for  ( int k = 0; k < size; k++ ) {
					arr[j][k] = sc.nextInt();
					if ( j == k ) 
						trace += arr[j][k];
					if ( rowRep[arr[j][k]] == 1 && !rowCounted ) {
						rowCounted = true;
					} else {
						rowRep[arr[k][j]] = 1;
					}
				}
				if ( rowCounted )
					rowCount += 1;
			}
			int colCount = 0;
			for ( int j = 0; j < size; j++ ) {
				int[] colRep = new int[size+1];
				boolean colCounted = false;
				for  ( int k = 0; k < size; k++ ) {
					if ( colRep[arr[j][k]] == 1 && !colCounted ) {
						colCounted = true;
					} else {
						colRep[arr[k][j]] = 1;
					}
				}
				
				if ( colCounted )
					colCount += 1;
			}
			
			out.println("Case #" + (i+1) +": "+trace+" "+rowCount+" "+colCount);
		}
		out.close();
	}
}

