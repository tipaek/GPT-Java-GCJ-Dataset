
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static int limit = 0;

	public static String solve(int limit, Scanner stdInput) {
		int rowCount = 0;
		int colCount = 0;
		int diagTotal = 0;
		int [][] matrix = new int[limit][limit];
		for (int i = 0; i < limit; i++) {
			for (int j = 0; j < limit; j++) {
				matrix[i][j] = stdInput.nextInt();
				if(i == j) {
					diagTotal += matrix[i][j]; 
				}
			}
//			stdInput.nextLine();
		}
		for (int i = 0; i < limit; i++) {
			Set<Integer> colSet = new HashSet<Integer>();
			for (int j = 0; j < limit; j++) {
				if(!colSet.add(matrix[j][i])) {
					colCount++;
					break;
				}
			}
		}
		for (int i = 0; i < limit; i++) {
			Set<Integer> rowSet = new HashSet<Integer>();
			for (int j = 0; j < limit; j++) {
					if(!rowSet.add(matrix[i][j])) {
						rowCount++;
						break;
					}
			}
		}
		return diagTotal + " " + rowCount + " " + colCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int caseNo = 0;
		Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		caseNo = stdin.nextInt();
		stdin.nextLine();
		for (int k = 1; k <= caseNo; k++) {
			limit = stdin.nextInt();
//			stdin.nextLine();
			System.out.println("Case #" + k + ": " + solve(limit, stdin));
			// long startTime = System.currentTimeMillis();

		}
	}

}


