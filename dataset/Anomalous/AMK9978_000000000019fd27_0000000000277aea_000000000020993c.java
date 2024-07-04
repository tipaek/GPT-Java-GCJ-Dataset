import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for duplicate elements in rows
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicate elements in columns
            for (int j = 0; j < size; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}