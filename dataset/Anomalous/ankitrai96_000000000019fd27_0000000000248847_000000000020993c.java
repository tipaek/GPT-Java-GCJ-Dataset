import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte testCases = scanner.nextByte();

        for (byte t = 0; t < testCases; t++) {
            byte n = scanner.nextByte();
            byte[][] matrix = new byte[n][n];

            // Reading the matrix
            for (byte i = 0; i < n; i++) {
                for (byte j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextByte();
                }
            }

            int trace = 0, rowDuplicates = 0, columnDuplicates = 0;

            // Calculate trace
            for (byte i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row duplicates
            for (byte i = 0; i < n; i++) {
                Set<Byte> rowSet = new HashSet<>();
                for (byte j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (byte i = 0; i < n; i++) {
                Set<Byte> columnSet = new HashSet<>();
                for (byte j = 0; j < n; j++) {
                    columnSet.add(matrix[j][i]);
                }
                if (columnSet.size() < n) {
                    columnDuplicates++;
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, rowDuplicates, columnDuplicates);
        }

        scanner.close();
    }
}