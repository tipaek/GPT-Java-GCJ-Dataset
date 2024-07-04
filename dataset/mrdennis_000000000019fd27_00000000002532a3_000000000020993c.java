import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    
		for(int tCase=1; tCase<=testCases; tCase++) {
			int N = in.nextInt();
			int[][] matrix = new int[N][N];
			int trace = 0;
			int rowCount = 0;
			int colCount = 0;
			for(int i=0; i<N; i++) {
				Set<Integer> row = new HashSet<Integer>();
				boolean repeated = false;
				for(int j=0; j<N; j++) {
					matrix[i][j] = in.nextInt();
					if(i==j) {
						trace += matrix[i][j];
					}
					if(!repeated && !row.add(matrix[i][j])) {
						repeated = true;
					}
				}
				if(repeated) {
					rowCount++;
				}
			}
			
			for(int j=0; j<N; j++) {
				Set<Integer> column = new HashSet<Integer>();
				boolean repeated = false;
				for(int i=0;i<N; i++) {
					if(!repeated && !column.add(matrix[i][j])) {
						repeated = true;
						break;
					}
				}
				if(repeated) {
					colCount++;
				}
			}
			
			System.out.println("Case #"+tCase+": "+trace+" "+rowCount+" "+colCount);
		}
		in.close();
	}
}
