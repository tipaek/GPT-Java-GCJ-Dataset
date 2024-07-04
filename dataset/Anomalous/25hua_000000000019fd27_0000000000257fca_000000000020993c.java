import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        int[][] matrix = new int[100][100];
        int[] exists = new int[100];

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                boolean rowHasRepeat = false;
                Arrays.fill(exists, 0);
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (exists[matrix[i][j]] == 1) {
                        if (!rowHasRepeat) {
                            rowRepeats++;
                            rowHasRepeat = true;
                        }
                    } else {
                        exists[matrix[i][j]] = 1;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Arrays.fill(exists, 0);
                for (int i = 0; i < n; i++) {
                    if (exists[matrix[i][j]] == 1) {
                        colRepeats++;
                        break;
                    } else {
                        exists[matrix[i][j]] = 1;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}