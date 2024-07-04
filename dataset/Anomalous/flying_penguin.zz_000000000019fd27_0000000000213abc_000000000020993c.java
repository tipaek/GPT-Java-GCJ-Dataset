import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }
                }
                if (rowHasDuplicates) {
                    rowRepeats++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicates = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicates = true;
                    }
                }
                if (colHasDuplicates) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}