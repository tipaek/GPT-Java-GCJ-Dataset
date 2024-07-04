import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();  // Consume the remaining newline

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int repeatedRows = 0, repeatedCols = 0, diagonalSum = 0;

            // Check for repeated elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Check for repeated elements in columns and calculate diagonal sum
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        repeatedCols++;
                        break;
                    }
                }
                diagonalSum += matrix[j][j];
            }

            writer.printf("Case #%d: %d %d %d%n", t, diagonalSum, repeatedRows, repeatedCols);
        }

        writer.flush();
        writer.close();
        scanner.close();
    }
}