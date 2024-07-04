import java.util.HashMap;
import java.util.Scanner;

public class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            // Read the matrix and compute the trace
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = in.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            int r = 0;
            int c = 0;

            // Check for duplicate values in each row
            for (int j = 0; j < N; j++) {
                HashMap<Integer, Boolean> map = new HashMap<>();
                for (int k = 0; k < N; k++) {
                    if (map.containsKey(matrix[j][k])) {
                        r++;
                        break;
                    } else {
                        map.put(matrix[j][k], true);
                    }
                }
            }

            // Check for duplicate values in each column
            for (int k = 0; k < N; k++) {
                HashMap<Integer, Boolean> map = new HashMap<>();
                for (int j = 0; j < N; j++) {
                    if (map.containsKey(matrix[j][k])) {
                        c++;
                        break;
                    } else {
                        map.put(matrix[j][k], true);
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }

        in.close();
    }
}