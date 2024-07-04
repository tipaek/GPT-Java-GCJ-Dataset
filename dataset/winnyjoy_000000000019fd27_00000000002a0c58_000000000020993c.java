import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		List<String> inputs = new ArrayList<>();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // num test cases
		for(int i = 1; i <= t; ++i){
			int n = in.nextInt(); // size of matrix
			int[][] mat = new int[n][n];
			for(int k = 0 ; k < n; ++k){
				for(int l = 0; l < n; l++){
					mat[k][l] = in.nextInt();
				}
			}
			int sum = printPrincipalDiagonal(mat, n);
			int numRow = numRepeatedRow(mat);
			int numCol = numRepeatedCol(mat);
			System.out.println("Case #"+ i+ ": "+ sum+ " "+ numRow+ " "+numCol);
		}

	}

	public static int printPrincipalDiagonal(int[][] mat, int n) {
	    int sum = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {

	            // Condition for principal diagonal
	            if (i == j)
	                sum = sum + mat[i][j];
	        }
	    }
	   return sum;
	}

	public static int numRepeatedRow(int[][] mat){
		int result = 0;
		for(int k = 0 ; k < mat.length; ++k){
			Set<Integer> row = new HashSet<>();
			for(int l = 0; l < mat.length; l++){
				row.add(mat[k][l]);
			}
			if(row.size() != mat.length)
				result ++;
		}

		return result;
	}

	public static int numRepeatedCol(int[][] mat){
		int result = 0;
		for(int k = 0 ; k < mat.length; ++k){
			Set<Integer> col = new HashSet<>();
			for(int l = 0; l < mat.length; l++){
				col.add(mat[l][k]);
			}
			if(col.size() != mat.length)
				result ++;
		}

		return result;
	}
}
