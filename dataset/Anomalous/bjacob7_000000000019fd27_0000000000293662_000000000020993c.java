import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            scanner.nextLine(); // consume the remaining newline
            for (int i = 0; i < size; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            int rowViolations = 0;
            int colViolations = 0;
            for (int i = 0; i < size; i++) {
                if (!isUniqueInColumn(matrix, size, i)) {
                    colViolations++;
                }
                if (!isUniqueInRow(matrix, size, i)) {
                    rowViolations++;
                }
            }

            int traceValue = calculateTrace(matrix, size);
            System.out.println("Case #" + (t + 1) + ": " + traceValue + " " + rowViolations + " " + colViolations);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static boolean isUniqueInColumn(int[][] matrix, int size, int col) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (!set.add(matrix[i][col])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniqueInRow(int[][] matrix, int size, int row) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (!set.add(matrix[row][i])) {
                return false;
            }
        }
        return true;
    }
}