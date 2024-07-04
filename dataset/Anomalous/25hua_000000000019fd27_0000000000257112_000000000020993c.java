import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseCount = scanner.nextInt();
        int[][] matrix = new int[100][100];
        int[] exists = new int[100];

        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            int n = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                Arrays.fill(exists, 0);
                boolean hasRowDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!hasRowDuplicate && exists[matrix[i][j]] == 1) {
                        rowDuplicates++;
                        hasRowDuplicate = true;
                    }
                    exists[matrix[i][j]] = 1;
                }
            }

            // Check columns for duplicates
            for (int j = 0; j < n; j++) {
                Arrays.fill(exists, 0);
                for (int i = 0; i < n; i++) {
                    if (exists[matrix[i][j]] == 1) {
                        colDuplicates++;
                        break;
                    }
                    exists[matrix[i][j]] = 1;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", caseIndex, trace, rowDuplicates, colDuplicates);
        }

        scanner.close();
    }
}