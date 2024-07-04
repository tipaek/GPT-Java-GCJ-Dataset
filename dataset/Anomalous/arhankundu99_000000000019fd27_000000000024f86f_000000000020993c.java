import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate trace and row repeats
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (rowSet.contains(matrix[i][j]) && !rowFlag) {
                        rowRepeats++;
                        rowFlag = true;
                    }
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Calculate column repeats
            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int i = 0; i < size; i++) {
                    if (colSet.contains(matrix[i][j]) && !colFlag) {
                        colRepeats++;
                        colFlag = true;
                    }
                    colSet.add(matrix[i][j]);
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        scanner.close();
    }
}