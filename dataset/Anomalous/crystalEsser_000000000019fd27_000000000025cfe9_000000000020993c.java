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

            // Calculate trace and check for duplicate elements in rows
            for (int j = 0; j < N; j++) {
                boolean[] rowCheck = new boolean[N];
                for (int k = 0; k < N; k++) {
                    if (rowCheck[matrix[j][k] - 1]) {
                        rowN++;
                        break;
                    }
                    rowCheck[matrix[j][k] - 1] = true;
                }
                trace += matrix[j][j];
            }

            // Check for duplicate elements in columns
            for (int j = 0; j < N; j++) {
                boolean[] colCheck = new boolean[N];
                for (int k = 0; k < N; k++) {
                    if (colCheck[matrix[k][j] - 1]) {
                        columnN++;
                        break;
                    }
                    colCheck[matrix[k][j] - 1] = true;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowN + " " + columnN);
        }
        scanner.close();
    }
}