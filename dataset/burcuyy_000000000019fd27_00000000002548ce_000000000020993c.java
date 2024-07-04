import java.util.Scanner;
class Vestigium {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String s1 = scan.nextLine();
		int number_of_test_cases = Integer.parseInt(s1);
		for(int i = 1; i <= number_of_test_cases; i++) {
			String s2 = scan.nextLine();
			int n = Integer.parseInt(s2);
			int[][] matrix = new int[n][n];
			int k = 0;
			int r = 0;
			int c = 0;
			for(int j = 0; j < n; j++) {
				boolean repeated = false;
				String s3 = scan.nextLine();
				String[] s4 = s3.split("\\s+");
				for(int l = 0; l < n; l++) {
					matrix[j][l] = Integer.parseInt(s4[l]);
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
