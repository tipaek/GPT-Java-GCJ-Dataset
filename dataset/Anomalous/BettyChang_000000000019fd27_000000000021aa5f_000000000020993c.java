import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Compute trace
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Compute row duplicates
            for (int row = 0; row < size; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Compute column duplicates
            for (int col = 0; col < size; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}