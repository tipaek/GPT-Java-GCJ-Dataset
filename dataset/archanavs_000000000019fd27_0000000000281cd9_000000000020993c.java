import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int matrix[][] = new int[N][N];
            for(int j=0; j<N;j++) {
            	for(int k=0; k<N;k++) {
            		int I = in.nextInt();
            		matrix[j][k]=I;
            	}
            }
            
            outputCase(i, N, matrix);
            
        }

	}

	private static void outputCase(int T, int n, int[][] matrix) {
		int trace = 0;
		int rows = 0;
		int columns = 0;
		
		for (int i=0; i< n; i++){
			java.util.Set values = new HashSet();
			for (int j=0; j< n; j++){
				if(i==j) trace = trace+ matrix[i][j];
				values.add(matrix[i][j]);
			}
			if(values.size()!=n) rows++;
			
		}
		
		for (int j=0; j< n; j++){
			java.util.Set values = new HashSet();
			for (int i=0; i< n; i++){
				values.add(matrix[i][j]);
			}
			if(values.size()!=n) columns++;
		}
		
		System.out.println("Case #" + T +": " + trace+ " " + rows + " " + columns);
		
	}

}
