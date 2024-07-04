import java.util.Scanner;

class Test4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		int[][] output = new int[testCases][3];

		for (int t = 1; t <= testCases; t++) {
			
			int n = scanner.nextInt();
			while(n>=2) {
			 n = scanner.nextInt();
			}
			int[][] matrix = new int[n][n];
			
			int dupR = 0;
			int dupC = 0;
			int trace = 0;

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					matrix[r][c] = scanner.nextInt();
					if (r == c)
						trace += matrix[r][r];
				}
			}

			output[t - 1][0] = trace;

			boolean found = false;

			for (int r = 0; r < n; r++)
			{
				for (int c = 0; c < n; c++) {

					for (int j = c + 1; j < n; j++) {

						if (matrix[r][c] == matrix[r][j]) {
							dupR += 1;
							found = true;
							break;
						}	

					}
					
					for (int j = c + 1; j < n; j++) 
					{

						if (matrix[c][r] == matrix[j][r]) {
							dupC += 1;
							System.out.println(c+" "+r);
							found = true;
							break;
						}

					}

					if (found == true) {
						found = false;
						break;
					}
				}

			}
			
			output[t - 1][1] = dupR;
			output[t - 1][2] = dupC;
		}

		for (int i = 0; i < testCases; i++) {
			System.out.println("Case #" + (i + 1) + ": " + output[i][0] + " " + output[i][1] + " " + output[i][2]);
		}

	}

}
