import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            scanner.nextLine(); // Consume the remaining newline

            for (int j = 0; j < n; j++) {
                String[] row = scanner.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, n);
            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedColumns = countRepeatedColumns(matrix, n);

            System.out.println("Case #" + i + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < n) {
                count++;
            }
        }
        return count;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() < n) {
                count++;
            }
        }
        return count;
    }
}