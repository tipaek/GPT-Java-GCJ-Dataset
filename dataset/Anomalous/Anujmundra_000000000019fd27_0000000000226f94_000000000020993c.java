import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate trace and row repeats
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeats = false;

                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasRepeats = true;
                    }
                }

                if (rowHasRepeats) {
                    rowRepeats++;
                }
            }

            // Calculate column repeats
            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasRepeats = false;

                for (int i = 0; i < size; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasRepeats = true;
                    }
                }

                if (colHasRepeats) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}