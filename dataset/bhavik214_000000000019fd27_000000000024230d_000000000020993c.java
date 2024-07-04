import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void solve(Scanner scanner, int caseNumber) {
		int n = scanner.nextInt();
		int [][] matrix = new int [n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		// Row calculation
		int row = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j++) {				
				boolean flag = false;
				for(int k = 0; k < j; k++) {
					if(matrix[i][j] == matrix[i][k]){
						row++;
						flag = true;
						break;
					}
				}
				if(flag)
					break;
			}
		}
		
		// Column calculation
		int column = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j++) {				
				boolean flag = false;
				for(int k = 0; k < j; k++) {
					if(matrix[j][i] == matrix[k][i]){
						column++;
						flag = true;
						break;
					}
				}
				if(flag)
					break;
			}
		}
		
		// Trace calculation
		int trace = 0;
		for(int i = 0; i < n; i++) {
			trace = trace + matrix[i][i];
		}
		System.out.println("Case #" + caseNumber + ": " + trace + " " + row + " " + column);
		System.out.flush();
	}
	
	public static void main(String args[]) throws IOException {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		
		int t = scanner.nextInt();
		
		for(int i = 1; i <= t; i++) {
			solve(scanner, i);
		}
	}

}