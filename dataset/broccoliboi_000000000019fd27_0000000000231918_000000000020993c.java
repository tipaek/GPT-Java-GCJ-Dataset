import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = scan.nextInt();
		scan.nextLine();
		for (int c = 1; c <= numCases; c++) {
			int n = scan.nextInt();
			scan.nextLine();
			int[][] matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = scan.nextInt();
				}
				scan.nextLine();
			}
			solution(c, n, matrix);
		}
		scan.close();
	}
	public static void solution(int caseNum, int n, int[][] matrix) {
		Set<Integer> currentRow;
		Set<Integer> currentColumn;
		int k = 0, r = 0, c = 0;
		for (int i = 0; i < n; i++) {
			currentRow = new HashSet<Integer>();
			currentColumn = new HashSet<Integer>();
			for (int j = 0; j < n; j++) {
				if(i == j ) k += matrix[i][j];
				currentRow.add(matrix[i][j]);
				currentColumn.add(matrix[j][i]);
				
			}
			if(currentRow.size() != n) r++;
			if(currentColumn.size() != n) c++;
			
		}
		System.out.printf("Case #%d: %d %d %d\n", caseNum, k, r, c);
	}
	
}
