import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mtix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();

        for (int q = 1; q <= testCases; q++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate diagonal sum
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Count duplicate rows
            int rowCount = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowCount++;
                        break;
                    }
                }
            }

            // Count duplicate columns
            int colCount = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colCount++;
                        break;
                    }
                }
            }

            // Print result for the current test case
            System.out.println("Case #" + q + ": " + diagonalSum + " " + rowCount + " " + colCount);
        }
    }
}