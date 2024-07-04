import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int repeatedRows = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!uniqueElements.add(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            int repeatedColumns = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!uniqueElements.add(matrix[i][j])) {
                        repeatedColumns++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}