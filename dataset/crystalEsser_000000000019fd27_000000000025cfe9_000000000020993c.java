import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    int T = Integer.parseInt(scanner.nextLine());
	    for (int i = 0; i < T; i++) {
	        int N = Integer.parseInt(scanner.nextLine());
	        int[][] matrix = new int[N][N];
	        for (int j = 0; j < N; j++) {
                String[] row = scanner.nextLine().split(" ");
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }
	        int rowN = 0;
	        int columnN = 0;
	        int trace = 0;
	        for (int j = 0; j < N; j++) {
                boolean[] rows = new boolean[N];
                for (int k = 0; k < N; k++) {
                    if (rows[matrix[j][k] - 1]) {
                        rowN += 1;
                        break;
                    } else {
                        rows[matrix[j][k] - 1] = true;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                boolean[] columns = new boolean[N];
                for (int k = 0; k < N; k++) {
                    if (columns[matrix[k][j] - 1]) {
                        columnN += 1;
                        break;
                    } else {
                        columns[matrix[k][j] - 1] = true;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                trace += matrix[j][j];
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowN + " " + columnN);
        }
    }
}