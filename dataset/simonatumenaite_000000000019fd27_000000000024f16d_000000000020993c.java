import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//reading input
		Scanner scanner = new Scanner(System.in);
		int N[] = new int[101];
		int[][][] matrix = new int[101][101][101];
		
		int T = scanner.nextInt();
		for (int i=0; i<T; i++) {
			N[i] = scanner.nextInt();
			for (int j=0; j<N[i]; j++) {
				for (int k=0; k<N[i]; k++) {
					matrix[i][j][k] = scanner.nextInt();
				}
			}
		}
		scanner.close();
		int trace[] = new int[101];
		int traceIndex = 0;
		
		for (int i=0; i<T; i++) {
			traceIndex = 0;
			for (int j=0; j<N[i]; j++) { //rows
				for (int k=0; k<N[i]; k++) { //columns
					trace[i] = trace[i] + matrix[i][traceIndex][traceIndex];
					traceIndex++;
				}
			}
			
		}
		//repeating in rows
		int[] repeatInRows = new int[101];
		boolean repeats = false;
		for (int i=0; i<T; i++) {
			for (int j=0; j<N[i]; j++) {
				repeats = false;
				for (int k=0; k<N[i]; k++) {
					for (int l=k+1; l<N[i]; l++) {
						if(matrix[i][j][k] == matrix[i][j][l]) {
							repeats = true;
							break;
						}
					}
				}
				if (repeats) repeatInRows[i]++;
			}
					
		}
		//repeating in columns
		int[] repeatInColumns = new int[101];
		for (int i=0; i<T; i++) {
			for (int k=0; k<N[i]; k++) {
				repeats = false;
				for (int j = 0; j<N[i]; j++) {
					for (int l = j+1; l<N[i]; l++) {
						if(matrix[i][j][k] == matrix[i][l][k]) {
							repeats = true;
							break;
						}
					}
					
				}
				if (repeats) repeatInColumns[i]++;
			}
			
		}
		
		//print out answers
		for (int i = 0; i<T; i++) {
			System.out.println("Case #" + (i+1) + ": " + trace[i] + " " + repeatInRows[i]
					+ " " + repeatInColumns[i]);
		}
	}
}
