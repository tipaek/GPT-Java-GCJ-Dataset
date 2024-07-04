import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int[][] results = new int[t][3];

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }
            results[i][0] = diagonalSum;

            int rowDuplicateCount = 0;
            int colDuplicateCount = 0;

            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowDuplicateCount++;
                        break;
                    }
                }
                results[i][1] = rowDuplicateCount;

                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        colDuplicateCount++;
                        break;
                    }
                }
                results[i][2] = colDuplicateCount;
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i][0] + " " + results[i][1] + " " + results[i][2]);
        }
    }
}