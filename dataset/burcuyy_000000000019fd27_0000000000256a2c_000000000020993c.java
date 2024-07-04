import java.io.*;
import java.util.Scanner;
class solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int number_of_test_cases = scan.nextInt();
		for(int i = 1; i <= number_of_test_cases; i++) {
			int n = scan.nextInt();
			int[][] matrix = new int[n][n];
			int k = 0;
			int r = 0;
			int c = 0;
			for(int j = 0; j < n; j++) {
				boolean repeated = false;
				for(int l = 0; l < n; l++) {
					matrix[j][l] = scan.nextInt();
					if (!repeated) {
						for(int t = 0; t < l; t++) {
							if (matrix[j][t] == matrix[j][l]) {
								repeated = true;
								break;
							}
						}
					}
				}
				if (repeated) r++;
				k += matrix[j][j];
			}
			for (int j = 0; j < n; j++) {
				boolean repeated = false;
				for (int t = 0; t < n; t++) {
					if (!repeated) {
						for(int m = 0; m < t; m++) {
							if (matrix[t][j] == matrix[m][j]) {
								repeated = true;
								break;
							}
						}
					}
				}
				if (repeated) c++;
			}
			System.out.println("Case #"+i+": "+k+" "+r+" "+c);

		}
	}

}