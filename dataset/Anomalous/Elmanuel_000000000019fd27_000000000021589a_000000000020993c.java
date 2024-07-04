import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int act = 1; act <= cases; act++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + act + ": " + solveVestigium(N, scanner));
        }
        scanner.close();
    }

    public static String solveVestigium(int N, Scanner scanner) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        int[][] matrix = new int[N][N];

        // Read the matrix and calculate the trace
        for (int i = 0; i < N; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            for (int j = 0; j < N; j++) {
                int val = scanner.nextInt();
                matrix[i][j] = val;
                if (i == j) {
                    trace += val;
                }
                // Check for duplicates in the row
                if (!rowSet.add(val)) {
                    rowHasDuplicate = true;
                }
            }
            if (rowHasDuplicate) {
                rowRepeats++;
            }
        }

        // Check for duplicates in columns
        for (int j = 0; j < N; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean colHasDuplicate = false;
            for (int i = 0; i < N; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colHasDuplicate = true;
                }
            }
            if (colHasDuplicate) {
                colRepeats++;
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}