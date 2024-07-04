import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read matrix and calculate trace and row repeats
            for (int i = 0; i < n; i++) {
                boolean rowHasRepeat = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowHasRepeat) {
                        for (int k = 0; k < j; k++) {
                            if (matrix[i][k] == matrix[i][j]) {
                                rowHasRepeat = true;
                                break;
                            }
                        }
                    }
                }
                if (rowHasRepeat) {
                    rowRepeats++;
                }
            }

            // Calculate column repeats
            for (int j = 0; j < n; j++) {
                boolean colHasRepeat = false;
                for (int i = 0; i < n; i++) {
                    if (!colHasRepeat) {
                        for (int k = 0; k < i; k++) {
                            if (matrix[k][j] == matrix[i][j]) {
                                colHasRepeat = true;
                                break;
                            }
                        }
                    }
                }
                if (colHasRepeat) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}