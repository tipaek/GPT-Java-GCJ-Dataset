import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {

	public static String getSolution(int testCaseNo, int matrix[][], int N) {
		
		int k=0, r=0, c=0;
		for(int i=0; i<N; i++) {
			
			Set<Integer> rowElements = new HashSet<>();
			Set<Integer> columnElements = new HashSet<>();
			for(int j=0; j<N; j++) {
				if(i==j) {
					k += matrix[i][j]; //To find trace
				}
				rowElements.add(matrix[i][j]);
				columnElements.add(matrix[j][i]);
			}
			if(rowElements.size() !=  N) {
				++r;
			}
			if(columnElements.size() != N) {
				++c;
			}
		}
		
		return String.format("Case #%s: %s %s %s", testCaseNo, k, r, c);
	}
	
	public static void main(String[] args) {
		
		int T, N, mat[][];

		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		List<String> output=new ArrayList<>();
		for(int i=0; i<T; i++) {
			
			N = scanner.nextInt();
			mat = new int[N][N];
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++){
					mat[j][k] = scanner.nextInt();
				}
			}
			output.add(getSolution(i+1, mat, N));
		}
		scanner.close();
		
		output.forEach(System.out::println);
	}

}