import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < tests; i++) {
            int size = Integer.parseInt(scan.nextLine());
            int[][] matrix = new int[size][size];
            int trace = 0;
            int repeatRows = 0;
            int repeatCols = 0;

            // Reading matrix
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = Integer.parseInt(scan.next());
                }
                scan.nextLine();
            }

            // Calculating trace
            for (int j = 0; j < size; j++) {
                trace += matrix[j][j];
            }

            // Checking for repeated elements in rows
            for (int j = 0; j < size; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        repeatRows++;
                        break;
                    }
                }
            }

            // Checking for repeated elements in columns
            for (int j = 0; j < size; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        repeatCols++;
                        break;
                    }
                }
            }

            // Printing the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, repeatRows, repeatCols);
        }
        scan.close();
    }
}