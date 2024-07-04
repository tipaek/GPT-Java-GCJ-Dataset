import java.util.HashSet;
import java.util.Scanner;

/*Quick Notes
Use BigInteger & BigDecimal for large numbers - They are arbitrarily precise.

*/
public class Solution {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < totalTestCases; i++) {
			
			int N = in.nextInt();
			in.nextLine();
			int[][] rows = new int[N][N];
			int[][] columns = new int[N][N];
			
			HashSet<Integer> rowNums = new HashSet<Integer>();
			HashSet<Integer> colNums = new HashSet<Integer>();
			
			int incorrectRows = 0;
			int incorrectCols = 0;
			int trace = 0;
			
			for(int j = 0; j < N; j++) {
				boolean isRowIncorrect = false;
				for(int k = 0; k < N; k++) {
					int currentNumber = in.nextInt();
					rows[j][k] = currentNumber;
					columns[k][j] = currentNumber;
					
					if(j == k) {
						trace += rows[j][k];
					}
					
					if(!isRowIncorrect && !rowNums.add(rows[j][k])) {
						isRowIncorrect = true;
						incorrectRows++;
					}
				}
				in.nextLine();
				isRowIncorrect = false;
				rowNums.clear();
			}
			
			for(int j = 0; j < N; j++) {
				boolean isColIncorrect = false;
				for(int k = 0; k < N; k++) {
					if(!isColIncorrect && !colNums.add(columns[j][k])) {
						isColIncorrect = true;
						incorrectCols++;
					}
				}
				isColIncorrect = false;
				colNums.clear();
			}
			
			System.out.println("Case #" + (i+1) + ": " + trace + " " + incorrectRows + " " + incorrectCols);
		}
		in.close();
	}
}
