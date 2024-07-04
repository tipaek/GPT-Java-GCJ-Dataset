import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(args[0]);
        Scanner scanner = new Scanner(inputFile);

        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j] - 1]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[matrix[i][j] - 1] = true;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j] - 1]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[matrix[i][j] - 1] = true;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}