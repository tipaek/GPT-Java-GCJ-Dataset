import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Google1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testCaseNumber = 0;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int[][] matrix = new int[n][n];

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                trace += matrix[i][i];
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (++testCaseNumber) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}