import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

final class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int lines = in.nextInt();
            int[][] matrix = new int[lines][lines];
            int diagSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read matrix and calculate diagonal sum
            for (int j = 0; j < lines; j++) {
                for (int k = 0; k < lines; k++) {
                    matrix[j][k] = in.nextInt();
                    if (j == k) {
                        diagSum += matrix[j][k];
                    }
                }
            }

            // Check for duplicate rows
            for (int j = 0; j < lines; j++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int k = 0; k < lines; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < lines; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int k = 0; k < lines; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    duplicateCols++;
                }
            }

            // Output the result for the current case
            System.out.println("Case #" + (i + 1) + ": " + diagSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}