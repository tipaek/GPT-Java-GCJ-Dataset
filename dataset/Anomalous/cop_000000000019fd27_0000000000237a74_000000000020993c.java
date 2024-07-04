import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();

            for (int caseNumber = 1; caseNumber <= totalCases; caseNumber++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                boolean[] seen = new boolean[size + 1];

                int trace = 0;
                int rowDuplicates = 0;
                int colDuplicates = 0;

                // Read matrix and calculate trace and row duplicates
                for (int row = 0; row < size; row++) {
                    Arrays.fill(seen, false);
                    boolean hasDuplicates = false;

                    for (int col = 0; col < size; col++) {
                        matrix[row][col] = scanner.nextInt();

                        if (row == col) {
                            trace += matrix[row][col];
                        }

                        if (seen[matrix[row][col]]) {
                            hasDuplicates = true;
                        } else {
                            seen[matrix[row][col]] = true;
                        }
                    }

                    if (hasDuplicates) {
                        rowDuplicates++;
                    }
                }

                // Calculate column duplicates
                for (int col = 0; col < size; col++) {
                    Arrays.fill(seen, false);
                    boolean hasDuplicates = false;

                    for (int row = 0; row < size; row++) {
                        if (seen[matrix[row][col]]) {
                            hasDuplicates = true;
                        } else {
                            seen[matrix[row][col]] = true;
                        }
                    }

                    if (hasDuplicates) {
                        colDuplicates++;
                    }
                }

                System.out.printf("Case #%d: %d %d %d\n", caseNumber, trace, rowDuplicates, colDuplicates);
            }
        }
    }
}