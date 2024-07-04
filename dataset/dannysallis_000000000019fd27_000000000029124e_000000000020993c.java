import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class LatinSquares {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = Integer.parseInt(in.nextLine());  //number of test cases
		
		for(int testCase = 1; testCase <= T; testCase++) { //for each test case
			int N = Integer.parseInt(in.nextLine()); //size of square, max int
			int[][] matrix = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.nextLine());
				for(int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int trace = 0;
			int repeatedRows = 0;
			int repeatedColumns = 0;
			for(int i = 0; i < N; i++) {
				int[] howManyTimesRow = new int[N + 1];
				for(int j = 0; j < N; j++) { //see if row repeats
					howManyTimesRow[matrix[i][j]]++;
					if(howManyTimesRow[matrix[i][j]] > 1) {
						repeatedRows++;
						break;
					}
				}
				int[] howManyTimesColumns = new int[N + 1];
				for(int j = 0; j < N; j++) { //see if column repeats
					howManyTimesColumns[matrix[j][i]]++;
					if(howManyTimesColumns[matrix[j][i]] > 1) {
						repeatedColumns++;
						break;
					}
				}
			}
			for(int j = 0; j < N; j++) {
				trace += matrix[j][j];
			}
			
			System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
		}
		
		in.close();
	}
}
