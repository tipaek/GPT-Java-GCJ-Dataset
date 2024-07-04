import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static String processMatrix(int[][] matrix, int size) {
        int diagonalSum = 0, rowRepeats = 0, colRepeats = 0;

        // Calculate diagonal sum and row repeats
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowIncremented = false;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j]) && !rowIncremented) {
                    rowRepeats++;
                    rowIncremented = true;
                }
            }
        }

        // Calculate column repeats
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean colIncremented = false;
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j]) && !colIncremented) {
                    colRepeats++;
                    colIncremented = true;
                }
            }
        }

        return diagonalSum + " " + rowRepeats + " " + colRepeats;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            String result = processMatrix(matrix, size);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }

        scanner.close();
    }
}