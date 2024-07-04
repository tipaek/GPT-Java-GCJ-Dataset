import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int T;

    static int[][][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        T = scan.nextInt();

        matrix = new int[T][][];

        for (int i = 0; i < T; i++) {
            int n = scan.nextInt();
            matrix[i] = new int[n][n];
            for (int ii = 0; ii < n; ii++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][ii][j] = scan.nextInt();
                }
            }
        }

        // Process each matrix one by one

        for (int t = 0; t < T; t++) {
            int n = matrix[t].length;

            // Compute the sum
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[t][i][i];
            }

            // Compute by-row score
            int byRow = 0;
            for (int i = 0; i < n; i++) {
                int[] row = Arrays.copyOf(matrix[t][i], n);
                Arrays.sort(row);
                int lastRepeated = row[0]-1;
                for (int j = 1; j < n; j++) {
                    if (row[j] == row[j-1] && row[j] != lastRepeated) {
                        byRow++;
                        lastRepeated = row[j];
                        break;
                    }
                }
            }

            // Compute by-column score
            int byColumn = 0;
            for (int i = 0; i < n; i++) {
                int[] row = new int[n];
                for (int j = 0; j < n; j++) {
                    row[j] = matrix[t][j][i];
                }
                Arrays.sort(row);
                int lastRepeated = row[0]-1;
                for (int j = 1; j < n; j++) {
                    if (row[j] == row[j-1] && row[j] != lastRepeated) {
                        byColumn++;
                        lastRepeated = row[j];
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + sum + " " + byRow + " " + byColumn);

        }

    }
}
